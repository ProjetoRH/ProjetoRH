package infrastructure.persistence;

import application.dto.curso_funcionario.AtribuirCursoFuncionarioRequest;
import application.dto.curso_funcionario.AtribuirCursoFuncionarioResponse;
import domain.repository.InscricaoRepository;
import infrastructure.database.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
