package infrastructure.database;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

        FileInputStream fileInputStream = new FileInputStream("database.properties");

        private static final String URL = "jdbc:mysql://localhost:3306/projetoFinal?useSSL=false&serverTimezone=UTC";
        private static final String USER = "root";
        private static final String SENHA = "mysqlPW";


        public static Connection conectar() throws SQLException {
            try {
                return DriverManager.getConnection(URL, USER, SENHA);
            } catch (SQLException e) {
                throw new SQLException("ERRO ao conectar BD" + e.getMessage(), e);
            }
        }
}
