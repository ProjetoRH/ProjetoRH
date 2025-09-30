package org.gestaoRH.service;

import org.gestaoRH.dao.FuncionarioDAO;
import org.gestaoRH.model.Funcionario;
import org.gestaoRH.model.StatusFuncionario;
import org.gestaoRH.utils.LerVariaveis;
import org.gestaoRH.view.InteracaoUsuario;
import org.gestaoRH.view.MensagensSistema;

import java.util.List;

public class Service {

    public void cadastrarFuncionario(Funcionario funcionario) {
        FuncionarioDAO.cadastrarFuncionario(funcionario);
    }

    public void listarFuncionariosPorNome() {
        List<Funcionario> listaFuncionarios = FuncionarioDAO.listarFuncionariosPorNome();

        if (listaFuncionarios == null || listaFuncionarios.isEmpty()) {
            MensagensSistema.mensagemPadraoErro("Nenhum funcionário cadastrado no sistema");
        } else {
            MensagensSistema.mensagemPadraoAcerto("Funcionário encontrado");
            System.out.println("Total: " + listaFuncionarios.size() + " funcionários");
            MensagensSistema.listarFuncionarios(listaFuncionarios);
        }
    }

    public void buscarFuncionariosPorCracha(String cracha) {
        Funcionario funcionario = FuncionarioDAO.buscarFuncionariosPorCracha(cracha);

        if (funcionario == null) {
            MensagensSistema.mensagemPadraoErro("Funcionário com o crachá " + cracha + " não encontrado");
        } else {
            MensagensSistema.mensagemPadraoAcerto("Funcionário encontrado");
            MensagensSistema.exibirFuncionario(funcionario);
        }
    }

    public void buscarFuncionariosPorNome(String nome) {
        List<Funcionario> listaFuncionarios = FuncionarioDAO.buscarFuncionariosPorNome(nome.trim());

        if (listaFuncionarios == null || listaFuncionarios.isEmpty()) {
            MensagensSistema.mensagemPadraoErro("Funcionário com o nome " + nome + " não encontrado");
        } else {
            MensagensSistema.mensagemPadraoAcerto("Funcionário encontrado");
            MensagensSistema.exibirListaFuncionarios(listaFuncionarios);
        }
    }

    public void removerFuncionarioPorCracha(String cracha) {
        while (true) {
            String confirmacao = InteracaoUsuario.confirmarRemocaoCracha(cracha);
            confirmacao = confirmacao.trim();

            if (confirmacao.equalsIgnoreCase("n")) {
                return;
            } else if (confirmacao.equalsIgnoreCase("s")) {
                break;
            } else {
                MensagensSistema.mensagemPadraoErro("Inválido. Digite apenas 's' ou 'n'");
            }
        }
        FuncionarioDAO.removerFuncionarioPorCracha(cracha.trim());
    } //fecha removerPorCracha()

    public void removerFuncionariosPorNome(String nome) {
        while (true) {
            String confirmacao = InteracaoUsuario.confirmarRemocaoNome(nome);
            confirmacao = confirmacao.trim();

            if (confirmacao.equalsIgnoreCase("n")) {
                return;
            } else if (confirmacao.equalsIgnoreCase("s")) {
                break;
            } else {
                MensagensSistema.mensagemPadraoErro("Inválido. Digite apenas 's' ou 'n'");
            }
        }
        FuncionarioDAO.removerFuncionariosPorNome(nome.trim());
    } //fecha removerPorNome()

    public void atualizarFuncionario(String cracha) {
        Funcionario funcionarioAtual = FuncionarioDAO.buscarFuncionariosPorCracha(cracha);

        if (funcionarioAtual == null) {
            MensagensSistema.mensagemPadraoErro("Funcionário não encontrado");
            return;
        }

        MensagensSistema.mensagem("\nDados Atuais: ");
        MensagensSistema.exibirFuncionario(funcionarioAtual);

        Funcionario funcionarioAtualizado = InteracaoUsuario.atualizarFuncionario(funcionarioAtual);
        FuncionarioDAO.atualizarFuncionario(funcionarioAtualizado);
    }

    public void atualizarCampo(String cracha) {
        Funcionario funcionarioAtual = FuncionarioDAO.buscarFuncionariosPorCracha(cracha);

        if (funcionarioAtual == null) {
            MensagensSistema.mensagemPadraoErro("Funcionário não encontrado");
            return;
        }

        MensagensSistema.mensagem("\nDados Atuais: ");
        MensagensSistema.exibirFuncionario(funcionarioAtual);

        int opcao = InteracaoUsuario.atualizarCampo();

        String campo = "";
        String novoValor = "";

        switch (opcao) {
            case 1 -> {
                campo = "nome";
                novoValor = InteracaoUsuario.atualizarNome(funcionarioAtual);
            }
            case 2 -> {
                campo = "cpf";
                novoValor = InteracaoUsuario.atualizarCpf(funcionarioAtual);
            }
            case 3 -> {
                campo = "endereco";
                novoValor = InteracaoUsuario.atualizarEndereco(funcionarioAtual);
            }
            case 4 -> {
                campo = "email";
                novoValor = InteracaoUsuario.atualizarEmail(funcionarioAtual);
            }
            case 5 -> {
                campo = "telefone";
                novoValor = InteracaoUsuario.atualizarTelefone(funcionarioAtual);
            }
            case 6 -> {
                campo = "cargo";
                novoValor = InteracaoUsuario.atualizarCargo(funcionarioAtual);
            }
            case 7 -> {
                campo = "salario";
                double salario = InteracaoUsuario.atualizarSalario(funcionarioAtual);
                novoValor = String.valueOf(salario);
            }
            case 8 -> {
                campo = "curso";
                novoValor = InteracaoUsuario.atualizarCurso(funcionarioAtual);
            }
            default -> MensagensSistema.mensagemPadraoErro("Opção inválida! Digite apenas números de 1 a 8");
        }

        FuncionarioDAO.atualizarCampo(cracha, campo, novoValor);
    }

    public void gerenciarStatus(String cracha) {
        Funcionario funcionarioAtual = FuncionarioDAO.buscarFuncionariosPorCracha(cracha);

        if (funcionarioAtual == null) {
            MensagensSistema.mensagemPadraoErro("Funcionário não encontrado");
            return;
        }

        MensagensSistema.mensagem("\nDados Atuais: ");
        MensagensSistema.exibirFuncionario(funcionarioAtual);

        int opcao = InteracaoUsuario.gerenciarNovoStatus();

        StatusFuncionario novoStatus = switch (opcao) {
            case 1 -> StatusFuncionario.ATIVO;
            case 2 -> StatusFuncionario.FERIAS;
            case 3 -> StatusFuncionario.LICENCA_MEDICA;
            case 4 -> StatusFuncionario.ATESTADO;
            case 5 -> StatusFuncionario.LICENCA_MATERNIDADE;
            case 6 -> StatusFuncionario.SUSPENSO;
            case 7 -> StatusFuncionario.DEMITIDO;
            default -> {
                MensagensSistema.mensagemPadraoErro("Opção inválida, mantendo status atual");
                yield StatusFuncionario.ATIVO;
            }
        };

        FuncionarioDAO.gerenciarStatus(cracha, novoStatus);
    }

}