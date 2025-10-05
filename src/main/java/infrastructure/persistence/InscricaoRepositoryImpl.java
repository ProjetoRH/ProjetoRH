package infrastructure.persistence;

import application.dto.inscricao.AtribuirCursoCargoRequest;
import application.dto.inscricao.AtribuirCursoCargoResponse;
import application.dto.inscricao.AtribuirCursoFuncionarioRequest;
import application.dto.inscricao.AtribuirCursoFuncionarioResponse;
import application.dto.curso.ListarMeusCursosResponse;
import application.dto.curso.DetalheCursoResponse;
import domain.model.enums.StatusCurso;
import domain.model.enums.StatusCursoPessoal;
import domain.repository.InscricaoRepository;
import infrastructure.database.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InscricaoRepositoryImpl implements InscricaoRepository {

    @Override
    public AtribuirCursoFuncionarioResponse atribuirCursoFuncionario(AtribuirCursoFuncionarioRequest request) {
        int idCurso = request.idCurso();
        List<Integer> idFuncionarios = request.idFuncionarios();
        int funcionariosAtribuidos = 0;
        int funcionariosJaExistentes = 0;

        String checkIfExistsSql = "SELECT COUNT(*) FROM Curso_Funcionario WHERE id_curso = ? AND id_funcionario = ?";
        String insertSql = "INSERT INTO Curso_Funcionario (id_curso, id_funcionario, status) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoFactory.conectar()) {

            conn.setAutoCommit(false);

            try (PreparedStatement checkStmt = conn.prepareStatement(checkIfExistsSql);
                 PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {

                for (Integer idFuncionario : idFuncionarios) {

                    checkStmt.setInt(1, idCurso);
                    checkStmt.setInt(2, idFuncionario);
                    ResultSet rs = checkStmt.executeQuery();
                    if (rs.next() && rs.getInt(1) > 0) {
                        System.out.println("Associação para o funcionário ID " + idFuncionario + " já existe. Ignorando.");
                        funcionariosJaExistentes++;
                        continue;
                    }

                    insertStmt.setInt(1, idCurso);
                    insertStmt.setInt(2, idFuncionario);
                    insertStmt.addBatch();
                }

                int[] resultados = insertStmt.executeBatch();
                for (int resultado : resultados) {
                    if (resultado > 0) {
                        funcionariosAtribuidos++;
                    }
                }

                conn.commit();

                String mensagem = String.format(
                        "Operação finalizada. %d funcionários atribuídos com sucesso. %d já estavam no curso.",
                        funcionariosAtribuidos,
                        funcionariosJaExistentes
                );
                return new AtribuirCursoFuncionarioResponse(mensagem);

            } catch (SQLException e) {
                System.err.println("Erro de SQL ao atribuir funcionários. Desfazendo a transação.");
                conn.rollback();
                e.printStackTrace();
                return new AtribuirCursoFuncionarioResponse("Erro ao atribuir funcionários: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.err.println("Falha ao obter conexão com o banco de dados.");
            e.printStackTrace();
            return new AtribuirCursoFuncionarioResponse("Erro de conexão com o banco de dados: " + e.getMessage());
        }
    }

    @Override
    public AtribuirCursoCargoResponse atribuirCursoCargo(AtribuirCursoCargoRequest request) {

        String queryInsertCursoCargo = """
        INSERT INTO CursoCargo (id_curso, id_cargo) 
        VALUES (?, (SELECT id_cargo FROM Cargo WHERE nome = ?))
        ON CONFLICT DO NOTHING; -- Para evitar duplicatas na regra
    """;

        String querySincronizarFuncionarios = """
        INSERT INTO Curso_Funcionario (id_funcionario, id_curso, status)
        SELECT 
            f.id_funcionario,
            ? AS id_curso,
            'PENDENTE'
        FROM 
            Funcionario f
        WHERE 
            f.id_cargo = (SELECT id_cargo FROM Cargo WHERE nome = ?)
        ON CONFLICT (id_funcionario, id_curso) DO NOTHING; 
    """;

        int linhasAfetadasRegra = 0;
        int funcionariosSincronizados = 0;

        try (Connection conn = ConexaoFactory.conectar()) {

            conn.setAutoCommit(false);

            try (PreparedStatement stmtRegra = conn.prepareStatement(queryInsertCursoCargo)) {
                stmtRegra.setInt(1, request.idCurso());
                stmtRegra.setString(2, request.nomeCargo());
                linhasAfetadasRegra = stmtRegra.executeUpdate();
            }

            try (PreparedStatement stmtSinc = conn.prepareStatement(querySincronizarFuncionarios)) {
                stmtSinc.setInt(1, request.idCurso());
                stmtSinc.setString(2, request.nomeCargo());
                funcionariosSincronizados = stmtSinc.executeUpdate();
            }

            conn.commit();

            String mensagem = String.format(
                    "Regra de atribuição criada (Curso ID: %d para Cargo: %s). %d funcionário(s) existente(s) foram inscritos.",
                    request.idCurso(), request.nomeCargo(), funcionariosSincronizados
            );
            return new AtribuirCursoCargoResponse(mensagem);

        } catch (SQLException e) {

            e.printStackTrace();

            return new AtribuirCursoCargoResponse("ERRO: Falha ao atribuir curso ao cargo no banco de dados.");
        }
    }

    @Override
    public List<ListarMeusCursosResponse> buscarCursosPorFuncionario(int idFuncionario) throws SQLException {
        String query = """
                SELECT c.id_curso, c.nome, c.status AS status_geral, cf.status AS status_pessoal
                FROM Curso c
                JOIN Curso_Funcionario cf ON c.id_curso = cf.id_curso
                WHERE cf.id_funcionario = ?
                ORDER BY c.nome
                """;

        List<ListarMeusCursosResponse> respostas = new ArrayList<>();

        try (Connection conn = ConexaoFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idFuncionario);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int idCurso = rs.getInt("id_curso");
                    String nome = rs.getString("nome");
                    String statusGeralStr = rs.getString("status_geral");
                    String statusPessoalStr = rs.getString("status_pessoal");

                    // Corrige: passa status como String para o DTO
                    respostas.add(new ListarMeusCursosResponse(
                        idCurso,
                        nome,
                        statusPessoalStr,
                        statusGeralStr
                    ));
                }
            }
        }

        return respostas;
    }

    @Override
    public DetalheCursoResponse buscarDetalheCursoDoFuncionario(int idFuncionario, int idCurso) throws SQLException {
        String query = """
                SELECT c.id_curso, c.nome, c.descricao, c.status AS status_geral, cf.status AS status_pessoal
                FROM Curso c
                LEFT JOIN Curso_Funcionario cf ON c.id_curso = cf.id_curso AND cf.id_funcionario = ?
                WHERE c.id_curso = ?
                """;

        try (Connection conn = ConexaoFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idFuncionario);
            stmt.setInt(2, idCurso);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id_curso");
                    String nome = rs.getString("nome");
                    String descricao = rs.getString("descricao");
                    String statusGeralStr = rs.getString("status_geral");
                    String statusPessoalStr = rs.getString("status_pessoal");

                    // Corrige: passa status como String para o DTO
                    return new DetalheCursoResponse(
                        id,
                        nome,
                        descricao,
                        statusPessoalStr,
                        statusGeralStr
                    );
                }
            }
        }

        return null;
    }
}
