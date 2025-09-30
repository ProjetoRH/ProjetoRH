package org.gestaoRH.view;

import org.gestaoRH.model.Funcionario;

import java.util.List;

public class MensagensSistema {

    // 30 -- preto
    // 31 -- vermelho (errado
    // 32 -- verde (certo
    // 33 -- amarelo
    // 34 -- azul
    // 35 -- rosa/roxo (entrada
    // 36 -- ciano
    // 37 -- cinza

    public void mensagemPadraoErroMenuPrincipal() {
    }

    public static void mensagem(String mensagem) {
        System.out.println("\n" + mensagem + "!");
    }

    public static void mensagemPadraoAcerto(String mensagem) {
        System.out.println("\n\u001b[32m✅ " + mensagem + "! \u001b[0m\n");
    }

    public static void mensagemPadraoErro(String mensagem) {
        System.out.println("\n\u001b[31m❌ " + mensagem + "! \u001b[0m\n");
    }

    public static void exibirFuncionario(Funcionario funcionario) {
        System.out.println("\nCrachá: " + funcionario.getCracha());
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("CPF: " + funcionario.getCpf());
        System.out.println("Endereço: " + funcionario.getEndereco());
        System.out.println("Email: " + funcionario.getEmail());
        System.out.println("Telefone: " + funcionario.getTelefone());
        System.out.println("Cargo: " + funcionario.getCargo());
        System.out.println("Salário: R$ " + String.format("%.2f", funcionario.getSalario()));
        System.out.println("Curso: " + funcionario.getCurso());
        System.out.println("Status: " + funcionario.getStatus().getDescricao());
        System.out.println("Data Admissão: " + funcionario.getDataAdmissao());
    }

    public static void exibirListaFuncionarios(List<Funcionario> listaFuncionarios) {
        for (Funcionario funcionario : listaFuncionarios) {
            System.out.println("\nCrachá: " + funcionario.getCracha());
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("CPF: " + funcionario.getCpf());
            System.out.println("Endereço: " + funcionario.getEndereco());
            System.out.println("Email: " + funcionario.getEmail());
            System.out.println("Telefone: " + funcionario.getTelefone());
            System.out.println("Cargo: " + funcionario.getCargo());
            System.out.println("Salário: R$ " + String.format("%.2f", funcionario.getSalario()));
            System.out.println("Curso: " + funcionario.getCurso());
            System.out.println("Status: " + funcionario.getStatus().getDescricao());
            System.out.println("Data Admissão: " + funcionario.getDataAdmissao());
        }
    }

    public static void listarFuncionarios(List<Funcionario> listaFuncionarios) {
        for (Funcionario funcionario : listaFuncionarios) {
            System.out.println("\nCrachá: " + funcionario.getCracha());
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Email: " + funcionario.getEmail());
            System.out.println("Cargo: " + funcionario.getCargo());
            System.out.println("Curso: " + funcionario.getCurso());
            System.out.println("Status: " + funcionario.getStatus().getDescricao());
            System.out.println("Data Admissão: " + funcionario.getDataAdmissao());
        }
    }

}