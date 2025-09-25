package infrastructure.persistence;

import domain.model.Curso;
import domain.model.Funcionario;
import domain.repository.CursoRepository;
import infrastructure.database.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CursoRepositorylmpl implements CursoRepository {


    @Override
    public void cadastrarCurso(Curso curso) {
        String query = """
                INSERT INTO Curso (nome, data_inicio, data_termino, status
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
    public Optional<Funcionario> buscarCurso(Curso curso) {
        String query = """
                SELECT 
                id_curso,
                nome, 
                data_inicio,
                data_termino,
                status
                FROM Curso
                WHERE id = ?
                """;

        try (Connection conn = ConexaoFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1, curso.getId_curso());

            try (ResultSet rs = stmt.executeQuery()){
                while (rs.next()){
                    int idCurso = rs.getInt("id_curso");
                    String nome = rs.getString("nome");
                    String data_inicio = rs.getString("data_inicio");
                    String dataTermino = rs.getString("data_termino");
                    String status = rs.getString("status");

                    System.out.printf(
                            "Curso %d | Nome: %s | Data Início: %s | Data Término: %s | Status: %s(%s - %s)%n",
                            idCurso,nome, data_inicio, dataTermino, status
                    );
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }


    @Override
    public void desativarCurso(int id){
        String query = "DELETE FROM Curso WHERE id = ?";

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
    public Optional<Funcionario> listarCurso() {
        String query = """
                SELECT nome, data_inicio, data_termino, status
                FROM Curso
                """;

        try (Connection conn = ConexaoFactory.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            String nomeCurso = rs.getString("nome");
            String data_inicio = rs.getString("data_inicio");
            String dataTermino= rs.getString("data_termino");
            String status = rs.getString("status");

            System.out.println(
                    "Nome: " + nomeCurso +
                            ", Data início: " + data_inicio +
                            ", Data término: " + dataTermino +
                            ", Status: " + status);
        }

        }catch (SQLException e ){
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
