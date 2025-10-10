    package infrastructure.persistence;

    import application.dto.curso.*;
    import domain.model.Curso;
    import domain.model.enums.StatusCurso;
    import domain.model.enums.StatusCursoPessoal;
    import domain.model.enums.TipoUsuario;
    import domain.repository.CursoRepository;
    import infrastructure.database.ConexaoFactory;

    import java.sql.*;
    import java.time.LocalDate;
    import java.util.ArrayList;
    import java.util.List;

    import static java.sql.Statement.RETURN_GENERATED_KEYS;

    public class CursoReposityImpl implements CursoRepository {

        @Override
        public CadastrarCursoResponse cadastrarCurso(Curso curso) {
            String query = """
            INSERT INTO Curso(nome, descricao, data_termino)
            VALUES(?,?,?)
            """;

            try (Connection conn = ConexaoFactory.conectar();

                 PreparedStatement stmt = conn.prepareStatement(query, RETURN_GENERATED_KEYS)) {

                stmt.setString(1, curso.getNome());
                stmt.setString(2, curso.getDescricao());
                stmt.setDate(3, curso.getData_fim());

                stmt.executeUpdate();

                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {

                        int idGerado = rs.getInt(1);


                        return new CadastrarCursoResponse(curso.getNome());
                    }
                    throw new SQLException("Falha ao obter o ID do curso após a inserção.");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        @Override
        public ExcluirCursoResponse excluirCurso(ExcluirCursoRequest request) {

            String query = """
                    DELETE FROM Curso
                    WHERE nome = ?
                    """;

            try (Connection conn = ConexaoFactory.conectar();
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setString(1, request.nome());

                int linhasAfetadas = stmt.executeUpdate();

                if(linhasAfetadas > 0) {
                    return new ExcluirCursoResponse("O Curso Excluido Com Sucesso: "+request.nome());
                } else {
                    return new ExcluirCursoResponse("O Curso "+request.nome()+" Não Foi Encontrado");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return new ExcluirCursoResponse("Erro De Banco de Dados ao Tentar Excluir o Curso " + request.nome());
            }
        }

        @Override
        public List<ListarCursoResponse> listarCurso(ListarCursoRequest request) {
            String query = """
                    SELECT status FROM Curso
                    WHERE nome ILIKE ?
                    """;

            List<ListarCursoResponse> respostas = new ArrayList<>();

            try (Connection conn = ConexaoFactory.conectar();
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setString(1, "%" + request.nome() + "%");

                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        String statusDoCursoString = rs.getString("status");
                        String nome = rs.getString("nome");

                        StatusCurso statusCurso = StatusCurso.valueOf(statusDoCursoString.toUpperCase());

                        respostas.add(new ListarCursoResponse(nome, statusCurso));
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return respostas;
        }

        @Override
        public List<ListarTodosCursoResponse> listarTodosCurso() {
            String query = """
                    SELECT nome, status, id_curso
                    FROM Curso
                    ORDER BY nome ASC
                    """;

            List<ListarTodosCursoResponse> todosOsCursos = new ArrayList<>();

            try (Connection conn = ConexaoFactory.conectar();
                 PreparedStatement stmt = conn.prepareStatement(query);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    int idCurso = rs.getInt("id_curso");
                    String nome = rs.getString("nome");
                    String statusDoCursoString = rs.getString("status");

                    StatusCurso statusCurso = StatusCurso.valueOf(statusDoCursoString.toUpperCase());

                    todosOsCursos.add(
                            new ListarTodosCursoResponse(idCurso ,nome, statusCurso)
                    );
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return todosOsCursos;
        }

        @Override
        public EditarStatusCursoResponse editarStatusCurso(EditarStatusCursoRequest request) {
            String query = """
                UPDATE Curso
                SET status = ?
                WHERE id_curso = ?
            """;

            try(Connection conn = ConexaoFactory.conectar();
                PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setString(1, request.status().toString());

                stmt.setInt(2, request.idCurso());

                int linhasAfetadas = stmt.executeUpdate();

                if (linhasAfetadas > 0) {
                    String mensagem = "O status do Curso com ID " + request.idCurso() + " foi atualizado para " + request.status() + " com sucesso.";
                    return new EditarStatusCursoResponse(mensagem);
                } else {
                    return new EditarStatusCursoResponse("Aviso: O Curso com ID " + request.idCurso() + " não foi encontrado ou o status já estava definido.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao editar o status do curso no banco de dados.", e);
            }
        }

    }
