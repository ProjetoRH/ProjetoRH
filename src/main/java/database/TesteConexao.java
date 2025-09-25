package database;


import java.sql.Connection;


public class TesteConexao {
    public static void main(String [] args){
        try {
            Connection conn = Conexao.conectar();
            conn.close();
            System.out.println("deu boa");
        }catch (Exception e){
            System.out.println("Falha a conexao" + e.getMessage());
        }
    }
}

