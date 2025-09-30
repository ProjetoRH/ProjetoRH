package org.gestaoRH.view;

import org.gestaoRH.model.Funcionario;
import org.gestaoRH.utils.LerVariaveis;
import org.gestaoRH.utils.ValidadorFuncionario;

import java.util.Scanner;

public class InteracaoUsuario {
    private static Scanner input;

    public InteracaoUsuario(Scanner input) {
        this.input = input;
    }

    public Funcionario cadastrarFuncionario() {
        int crachaInt = LerVariaveis.lerInteiro(input, "\nDigite o número do crachá do funcionário: ");
        String nome = LerVariaveis.lerTexto(input, "Digite o nome do funcionário: ");
        String cpf = LerVariaveis.lerTexto(input, "Digite o CPF do funcionário (apenas números): ");
        String endereco = LerVariaveis.lerTexto(input, "Digite o endereço do funcionário: ");
        String email = LerVariaveis.lerTexto(input, "Digite o email do funcionário: ");
        String telefone = LerVariaveis.lerTexto(input, "Digite o telefone do funcionário: ");
        String cargo = LerVariaveis.lerTexto(input, "Digite o cargo do funcionário: ");
        double salario = LerVariaveis.lerDouble(input, "Digite o salário do funcionário: ");
        String curso = LerVariaveis.lerTexto(input, "Digite o curso do funcionário: ");

        String cracha = String.valueOf(crachaInt);

        Funcionario funcionario = new Funcionario(cracha, nome, cpf, endereco, email, telefone, cargo, salario, curso);

        try {
            ValidadorFuncionario.validarFuncionario(funcionario);
            return funcionario;
        } catch (IllegalArgumentException e) {
            System.out.println();
            MensagensSistema.mensagemPadraoErro(e.getMessage());
            System.out.println("Tente novamente!\n");
            return cadastrarFuncionario();
        }
    }

    public int buscarFuncionarios(){
        System.out.println("\nDigite a forma de busca:" +
                "\n1. Por crachá" +
                "\n2. Por nome (virá nomes repetidos)");

        String escolha = input.nextLine();
        int formaPesquisa = 0;

        try {
            formaPesquisa = Integer.parseInt(escolha);
        } catch (NumberFormatException e){
            System.out.println("\n\u001B[31mOpção inválida! Digite apenas 1 ou 2.\u001B[0m\n");
        }

        return formaPesquisa;
    }

    public static String obterCracha(){
        while (true) {
            int crachaInt = LerVariaveis.lerInteiro(input, "\nDigite o crachá do funcionário: ");
            String cracha = String.valueOf(crachaInt);

            try {
                ValidadorFuncionario.validarCracha(cracha);
                return cracha;
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
        }
    }

    public String obterNome(){
        String nome = LerVariaveis.lerTexto(input, "\nDigite o nome do funcionário: ");
        return nome;
    }

    public int removerFuncionario() {
        System.out.println("\nDigite a forma de remoção:" +
                "\n1. Por crachá" +
                "\n2. Por nome (excluirá nomes repetidos)");

        String escolha = input.nextLine();
        int formaRemocao = 0;

        try {
            formaRemocao = Integer.parseInt(escolha);
        } catch (NumberFormatException e){
            System.out.println("\n\u001B[31mOpção inválida! Digite apenas 1 ou 2.\u001B[0m\n");
        }

        return formaRemocao;
    }

    public static String confirmarRemocaoNome(String nome) {
        System.out.println("Você tem certeza de que deseja excluir todos os usuários com esse nome? (s/n) \n(isso afetará permanentemente o sistema)");
        return input.nextLine();
    }

    public static String confirmarRemocaoCracha(String cracha) {
        System.out.println("Você tem certeza de que deseja excluir esse funcionário? (s/n) \n(isso afetará permanentemente o sistema)");
        return input.nextLine();
    }

    public int atualizarInfo() {
        System.out.println("\nDigite o que deseja atualizar:" +
                "\n1. Apenas uma coisa" +
                "\n2. Tudo");

        String escolha = input.nextLine();
        int formaAtualizar = 0;

        try {
            formaAtualizar = Integer.parseInt(escolha);
        } catch (NumberFormatException e){
            System.out.println("\n\u001B[31mOpção inválida! Digite apenas 1 ou 2.\u001B[0m\n");
        }

        return formaAtualizar;
    }

    public static String atualizarNome(Funcionario funcionarioAtual) {
        System.out.print("\nNome Atual: " + funcionarioAtual.getNome());
        String nome = LerVariaveis.lerTexto(input, "\nDigite o novo nome: ");
        nome = nome.trim();
        return nome;
    }

    public static String atualizarCpf(Funcionario funcionarioAtual) {
        System.out.print("\nCpf Atual: " + funcionarioAtual.getCpf());
        String cpf = LerVariaveis.lerTexto(input, "\nDigite o novo cpf: ");
        cpf = cpf.trim();
        return cpf;
    }

    public static String atualizarEndereco(Funcionario funcionarioAtual) {
        System.out.print("\nEndereço Atual: " + funcionarioAtual.getEndereco());
        String endereco = LerVariaveis.lerTexto(input, "\nDigite o novo endereco: ");
        endereco = endereco.trim();
        return endereco;
    }

    public static String atualizarEmail(Funcionario funcionarioAtual) {
        System.out.print("\nEmail Atual: " + funcionarioAtual.getEmail());
        String email = LerVariaveis.lerTexto(input, "\nDigite o novo email: ");
        email = email.trim();
        return email;
    }

    public static String atualizarTelefone(Funcionario funcionarioAtual) {
        System.out.print("\nTelefone Atual: " + funcionarioAtual.getTelefone());
        String telefone = LerVariaveis.lerTexto(input, "\nDigite o novo telefone: ");
        telefone = telefone.trim();
        return telefone;
    }

    public static String atualizarCargo(Funcionario funcionarioAtual) {
        System.out.print("\nCargo Atual: " + funcionarioAtual.getCargo());
        String cargo = LerVariaveis.lerTexto(input, "\nDigite o novo cargo: ");
        cargo = cargo.trim();
        return cargo;
    }

    public static double atualizarSalario(Funcionario funcionarioAtual) {
        System.out.print("\nSalário Atual: " + funcionarioAtual.getSalario());
        String salarioStr = LerVariaveis.lerTexto(input, "\nDigite o novo salário: ");
        salarioStr = salarioStr.trim();

        double salario = 0;
        if (!salarioStr.isEmpty()) {
            try {
                salario = Double.parseDouble(salarioStr);
            } catch (NumberFormatException e) {
                MensagensSistema.mensagemPadraoErro("Valor inválido, mantendo salário atual");
            }
        }

        return salario;
    }

    public static String atualizarCurso(Funcionario funcionarioAtual) {
        System.out.print("\nCurso Atual: " + funcionarioAtual.getCurso());
        String curso = LerVariaveis.lerTexto(input, "\nDigite o novo curso: ");
        curso = curso.trim();
        return curso;
    }

    public static Funcionario atualizarFuncionario(Funcionario funcionarioAtual) { //validação e tirar if

        String nome = atualizarNome(funcionarioAtual);
        funcionarioAtual.setNome(nome);

        String cpf = atualizarCpf(funcionarioAtual);
        funcionarioAtual.setCpf(cpf);

        String endereco = atualizarEndereco(funcionarioAtual);
        funcionarioAtual.setEndereco(endereco);

        String email = atualizarEmail(funcionarioAtual);
        funcionarioAtual.setEmail(email);

        String telefone = atualizarTelefone(funcionarioAtual);
        funcionarioAtual.setTelefone(telefone);

        String cargo = atualizarCargo(funcionarioAtual);
        funcionarioAtual.setCargo(cargo);

        double salario = atualizarSalario(funcionarioAtual);
        if (salario != 0) funcionarioAtual.setSalario(salario);

        String curso = atualizarCurso(funcionarioAtual);
        funcionarioAtual.setCurso(curso);

        return funcionarioAtual;
    }

    public static int atualizarCampo() {
        System.out.println("\nSelecione o campo para atualizar: ");
        System.out.println("1. Nome");
        System.out.println("2. CPF");
        System.out.println("3. Endereço");
        System.out.println("4. Email");
        System.out.println("5. Telefone");
        System.out.println("6. Cargo");
        System.out.println("7. Salário");
        System.out.println("8. Curso");

        String opcaoAtualizar = LerVariaveis.lerTexto(input, "\nDigite o número da opção desejada: ");
        int opcao = 0;

        try {
            opcao = Integer.parseInt(opcaoAtualizar);
        } catch (NumberFormatException e) {
            MensagensSistema.mensagemPadraoErro("Opção inválida! Digite apenas números de 1 a 8");
        }

        return opcao;
    }

    public static int gerenciarNovoStatus() {
        System.out.println("\nSelecione o novo status: ");
        System.out.println("1. Ativo");
        System.out.println("2. Férias");
        System.out.println("3. Licença Médica");
        System.out.println("4. Atestado");
        System.out.println("5. Licença Maternidade");
        System.out.println("6. Suspenso");
        System.out.println("7. Demitido");

        String opcaoAtualizar = LerVariaveis.lerTexto(input, "\nDigite o número da opção desejada: ");
        int opcao = 0;

        try {
            opcao = Integer.parseInt(opcaoAtualizar);
        } catch (NumberFormatException e) {
            MensagensSistema.mensagemPadraoErro("Opção inválida! Digite apenas números de 1 a 7");
        }

        return opcao;
    }

}