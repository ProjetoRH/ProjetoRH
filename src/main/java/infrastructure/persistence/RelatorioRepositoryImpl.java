package infrastructure.persistence;

import application.dto.relatorio.*;
import domain.model.enums.StatusCurso;
import domain.model.enums.StatusCursoPessoal;
import domain.repository.RelatorioRepository;
import infrastructure.database.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RelatorioRepositoryImpl implements RelatorioRepository {

    @Override
    public List<RelatorioGeralCursoResponse> relatorioGeralCurso() throws SQLException {
        String query = """
        SELECT
            c.nome AS nome_curso,
            c.status AS status_curso,
            COUNT(cf.id_funcionario) AS total_inscritos,
            COUNT(CASE WHEN cf.status = 'CONCLUIDO' THEN 1 END) AS total_concluidos,
            COUNT(CASE WHEN cf.status = 'PENDENTE' THEN 1 END) AS total_pendentes
        FROM Curso c
        LEFT JOIN Curso_Funcionario cf ON c.id_curso = cf.id_curso
        GROUP BY c.id_curso, c.nome, c.status
        ORDER BY c.nome
    """;
        List<RelatorioGeralCursoResponse> relatorio = new ArrayList<>();

        try (Connection conn = ConexaoFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while(rs.next()) {
                String statusCursoStr = rs.getString("status_curso");

                StatusCurso statusCurso = StatusCurso.valueOf(statusCursoStr.toUpperCase());
                        relatorio.add(new RelatorioGeralCursoResponse(
                        rs.getString("nome_curso"),
                        statusCurso,
                        rs.getInt("total_inscritos"),
                        rs.getInt("total_concluidos"),
                        rs.getInt("total_pendentes")
                ));
            }
        }
        return relatorio;
    }

    @Override
    public RelatorioCursoParticipantesResponse relatorioCursoParticipantes(int idCurso) throws SQLException {
        String query = """
        SELECT
            c.nome AS nome_curso,
            c.status AS status_curso,
            f.nome_funcionario,
            ca.nome AS nome_cargo,
            cf.status AS status_inscricao
        FROM Curso c
        LEFT JOIN Curso_Funcionario cf ON c.id_curso = cf.id_curso
        LEFT JOIN Funcionario f ON cf.id_funcionario = f.id_funcionario
        LEFT JOIN Cargo ca ON f.id_cargo = ca.id_cargo
        WHERE c.id_curso = ?
        ORDER BY f.nome_funcionario
    """;

        RelatorioCursoParticipantesResponse cursoDetalhado = null;

        try (Connection conn = ConexaoFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idCurso);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    StatusCurso statusCurso = StatusCurso.valueOf(rs.getString("status_curso").toUpperCase());
                    if (cursoDetalhado == null) {
                        cursoDetalhado = new RelatorioCursoParticipantesResponse(
                                rs.getString("nome_curso"),
                                statusCurso,
                                new ArrayList<>()
                        );
                    }

                    StatusCursoPessoal statusCursoPessoal = StatusCursoPessoal.valueOf(rs.getString("status_inscricao").toUpperCase());

                    if (rs.getString("nome_funcionario") != null) {
                        cursoDetalhado.participantes().add(new ParticipanteCursoResponse(
                                rs.getString("nome_funcionario"),
                                rs.getString("nome_cargo"),
                                statusCursoPessoal
                        ));
                    }
                }
            }
        }
        return cursoDetalhado;
    }

    @Override
    public RelatorioCursoParticipantePendenteResponse relatorioCursoParticipantesPendentes(int idCurso) throws SQLException {
        String query = """
        SELECT
            c.nome AS nome_curso,
            c.status AS status_curso,
            f.nome_funcionario,
            ca.nome AS nome_cargo,
            cf.status AS status_inscricao
        FROM Curso c
        LEFT JOIN Curso_Funcionario cf ON c.id_curso = cf.id_curso
        LEFT JOIN Funcionario f ON cf.id_funcionario = f.id_funcionario
        LEFT JOIN Cargo ca ON f.id_cargo = ca.id_cargo
        WHERE c.id_curso = ?
        AND cf.status IN ('PENDENTE')
        ORDER BY f.nome_funcionario
    """;

        RelatorioCursoParticipantePendenteResponse cursoDetalhado = null;

        try (Connection conn = ConexaoFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idCurso);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    if (cursoDetalhado == null) {

                        StatusCurso statusCurso = StatusCurso.valueOf(rs.getString("status_curso").toUpperCase());
                        cursoDetalhado = new RelatorioCursoParticipantePendenteResponse(
                                rs.getString("nome_curso"),
                                statusCurso,
                                new ArrayList<>()
                        );
                    }

                    if (rs.getString("nome_funcionario") != null) {

                        StatusCursoPessoal statusCursoPessoal = StatusCursoPessoal.valueOf(rs.getString("status_inscricao").toUpperCase());
                        cursoDetalhado.participantes().add(new ParticipanteCursoPendenteResponse(
                                rs.getString("nome_funcionario"),
                                rs.getString("nome_cargo"),
                                statusCursoPessoal
                        ));
                    }
                }
            }
        }

        return cursoDetalhado;
    }
}

