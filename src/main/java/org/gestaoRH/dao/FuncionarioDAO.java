package org.gestaoRH.dao;

import org.gestaoRH.connection.Conexao;
import org.gestaoRH.model.Funcionario;
import org.gestaoRH.model.StatusFuncionario;
import org.gestaoRH.view.MensagensSistema;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public static void cadastrarFuncionario(Funcionario funcionario) {

        String query = "INSERT INTO funcionario (cracha, nome, cpf, endereco, email, telefone, cargo, salario, curso, status, data_admissao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, funcionario.getCracha());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getCpf());
            stmt.setString(4, funcionario.getEndereco());
            stmt.setString(5, funcionario.getEmail());
            stmt.setString(6, funcionario.getTelefone());
            stmt.setString(7, funcionario.getCargo());
            stmt.setDouble(8, funcionario.getSalario());
            stmt.setString(9, funcionario.getCurso());
            stmt.setString(10, funcionario.getStatus().name());
            stmt.setDate(11, Date.valueOf(funcionario.getDataAdmissao()));
            stmt.executeUpdate();

            MensagensSistema.mensagemPadraoAcerto("Funcionário adicionado com sucesso"); //vai sair daq, ns

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //fecha cadastro

    public static List<Funcionario> listarFuncionariosPorNome() {

        String query = "SELECT cracha, nome, email, cargo, curso, status, data_admissao FROM funcionario ORDER BY nome";
        List<Funcionario> listaFuncionarios = new ArrayList<>();

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                listaFuncionarios.add(criarFuncionarioParaListar(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaFuncionarios;
    }

    public static Funcionario buscarFuncionariosPorCracha(String cracha) {

        String query = "SELECT id, cracha, nome, cpf, endereco, email, telefone, cargo, salario, curso, status, data_admissao FROM funcionario WHERE cracha LIKE ?";
        Funcionario funcionario = null;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, cracha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                funcionario = criarFuncionario(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return funcionario;
    }

    public static List<Funcionario> buscarFuncionariosPorNome(String nome) {

        String query = "SELECT cracha, nome, cpf, endereco, email, telefone, cargo, salario, curso, status, data_admissao FROM funcionario WHERE nome LIKE ?";
        List<Funcionario> listaFuncionarios = new ArrayList<>();

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, "%" + nome + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                listaFuncionarios.add(criarFuncionario(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaFuncionarios;
    }

    public static void removerFuncionariosPorNome(String nome) {

        String query = "DELETE FROM funcionario WHERE nome = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nome);
            stmt.executeUpdate();

            MensagensSistema.mensagemPadraoAcerto("Funcionário(s) removido(s) com sucesso");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void removerFuncionarioPorCracha(String cracha) {

        String query = "DELETE FROM funcionario WHERE cracha = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, cracha);
            stmt.executeUpdate();

            MensagensSistema.mensagemPadraoAcerto("Funcionário removido com sucesso");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void atualizarFuncionario(Funcionario funcionario) {

        String query = "UPDATE funcionario SET nome = ?, cpf = ?, endereco = ?, email = ?, telefone = ?, cargo = ?, salario = ?, curso = ? WHERE cracha = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getEndereco());
            stmt.setString(4, funcionario.getEmail());
            stmt.setString(5, funcionario.getTelefone());
            stmt.setString(6, funcionario.getCargo());
            stmt.setDouble(7, funcionario.getSalario());
            stmt.setString(8, funcionario.getCurso());
            stmt.setString(9, funcionario.getCracha());
            stmt.executeUpdate();

            MensagensSistema.mensagemPadraoAcerto("Funcionário atualizado com sucesso");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void atualizarCampo(String cracha, String campo, String novoValor) {

        String query = "UPDATE funcionario SET " + campo + " = ? WHERE cracha = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, novoValor);
            stmt.setString(2, cracha);
            stmt.executeUpdate();

            MensagensSistema.mensagemPadraoAcerto("Campo atualizado com sucesso");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void gerenciarStatus(String cracha, StatusFuncionario novoStatus) {

        String query = "UPDATE funcionario SET status = ? WHERE cracha = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, novoStatus.name());
            stmt.setString(2, cracha);
            stmt.executeUpdate();

            MensagensSistema.mensagemPadraoAcerto("Status atualizado com sucesso");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static Funcionario criarFuncionario(ResultSet rs) throws SQLException {
        Funcionario funcionario = new Funcionario();
        funcionario.setCracha(rs.getString("cracha"));
        funcionario.setNome(rs.getString("nome"));
        funcionario.setCpf(rs.getString("cpf"));
        funcionario.setEndereco(rs.getString("endereco"));
        funcionario.setEmail(rs.getString("email"));
        funcionario.setTelefone(rs.getString("telefone"));
        funcionario.setCargo(rs.getString("cargo"));
        funcionario.setSalario(rs.getDouble("salario"));
        funcionario.setCurso(rs.getString("curso"));
        funcionario.setStatus(StatusFuncionario.valueOf(rs.getString("status")));
        funcionario.setDataAdmissao(rs.getDate("data_admissao").toLocalDate());
        return funcionario;
    }

    private static Funcionario criarFuncionarioParaListar(ResultSet rs) throws SQLException {
        Funcionario funcionario = new Funcionario();
        funcionario.setCracha(rs.getString("cracha"));
        funcionario.setNome(rs.getString("nome"));
        funcionario.setEmail(rs.getString("email"));
        funcionario.setCargo(rs.getString("cargo"));
        funcionario.setCurso(rs.getString("curso"));
        funcionario.setStatus(StatusFuncionario.valueOf(rs.getString("status")));
        funcionario.setDataAdmissao(rs.getDate("data_admissao").toLocalDate());
        return funcionario;
    }

}