package infrastructure.persistence;

import domain.repository.CargoRepository;
import infrastructure.database.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CargoRepositoryImpl implements CargoRepository {

    @Override
    public int buscarIdCargo(String nome, String departamento) {
        String query = """
                SELECT id_cargo FROM Cargo
                WHERE nome = ? AND departamento = ?
                """;

        try(Connection conn = ConexaoFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nome);
            stmt.setString(2, departamento);
            var resultSet = stmt.executeQuery();
            if(resultSet.next()) {
                return resultSet.getInt("id_cargo");
            } else {
                return -1;
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar ou cadastrar cargo", e);
        }
    }

    @Override
    public int cadastrarCargo(String nome, String departamento) {
        String insert = """
                INSERT INTO Cargo (nome, departamento) VALUES (?, ?)
                """;
        String select = "SELECT id_cargo FROM Cargo WHERE nome = ? AND departamento = ?";
        try(Connection conn = ConexaoFactory.conectar();
            PreparedStatement stmtInsert = conn.prepareStatement(insert);
            PreparedStatement stmtSelect = conn.prepareStatement(select)) {

            stmtInsert.setString(1, nome);
            stmtInsert.setString(2, departamento);
            stmtInsert.executeUpdate();

            stmtSelect.setString(1, nome);
            stmtSelect.setString(2, departamento);
            var resultSet = stmtSelect.executeQuery();
            if(resultSet.next()) {
                return resultSet.getInt("id_cargo");
            } else {
                throw new RuntimeException("Falha ao cadastrar cargo");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar cargo", e);
        }
    }
}
