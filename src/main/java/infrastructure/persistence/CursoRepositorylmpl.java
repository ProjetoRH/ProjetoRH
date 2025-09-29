package infrastructure.persistence;

import domain.model.Curso;
import domain.repository.CursoRepository;
import infrastructure.database.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CursoRepositorylmpl implements CursoRepository {


    @Override
    public void cadastrarCurso(Curso curso) {
        String query = """
                INSERT INTO Curso (nome, data_inicio, data_termino, status)
                VALUES (?,?,?,?)
                """;

        try (Connection conn = ConexaoFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getData_inicio());
            stmt.setString(3, curso.getData_termino());
            stmt.setString(4, curso.getStatusCurso());
            stmt.executeUpdate();
            System.out.println("Curso cadastrado com sucesso ✓");

        } catch (SQLException e ){
            e.printStackTrace();
        }

    }

    @Override
    public void atualizarStatus(Curso curso) {
        String query = """
                UPDATE Curso SET status = ? WHERE id_curso = ?
                """;

        try(Connection conn = ConexaoFactory.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, curso.getStatusCurso());
            stmt.setInt(2, curso.getId_curso());
            stmt.executeUpdate();
            System.out.printf("Status atualizado!");

        }catch (SQLException e ){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Curso> buscarCurso(Curso curso) {
        String query = "SELECT id_curso, nome, data_inicio, data_termino, status FROM Curso WHERE id_curso = ?";
        try (Connection conn = ConexaoFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, curso.getId_curso());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Curso c = new Curso();
                    c.setId_curso(rs.getInt("id_curso"));
                    c.setNome(rs.getString("nome"));
                    c.setData_inicio(rs.getString("data_inicio"));
                    c.setData_termino(rs.getString("data_termino"));
                    c.setStatusCurso(rs.getString("status"));
                    return Optional.of(c);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }



    @Override
    public void desativarCurso(int id){
        String query = "DELETE FROM Curso WHERE id_curso = ?";

        try(Connection conn = ConexaoFactory.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
        stmt.setInt(1, id);
        stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }


    }

    @Override
    public List<Curso> listarCurso() {
        String query = """
            SELECT id_curso, nome, data_inicio, data_termino, status
            FROM Curso
            """;

        List<Curso> cursos = new ArrayList<>();

        try (Connection conn = ConexaoFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Curso c = new Curso();
                c.setId_curso(rs.getInt("id_curso"));
                c.setNome(rs.getString("nome"));
                c.setData_inicio(rs.getString("data_inicio"));
                c.setData_termino(rs.getString("data_termino"));
                c.setStatusCurso(rs.getString("status"));
                cursos.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cursos;
    }
}
