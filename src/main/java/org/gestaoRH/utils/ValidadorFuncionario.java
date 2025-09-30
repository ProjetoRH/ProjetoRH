package org.gestaoRH.utils;

import org.gestaoRH.model.Funcionario;

public class ValidadorFuncionario {

    public static void validarFuncionario(Funcionario funcionario) {

        if (funcionario == null) {
            throw new IllegalArgumentException("Dados do funcionário são obrigatórios!"); //revê
        }

        validarCracha(funcionario.getCracha());
        //validarNome(funcionario.getNome());
        //validarCPF(funcionario.getCpf());
        //validarEndereco(funcionario.getEndereco());
        //validarEmail(funcionario.getEmail());
        //validarTelefone(funcionario.getTelefone());
        //validarSalario(funcionario.getSalario());
        //cargo/curso

    } //fecha validarFuncionario()

    public static void validarCracha(String cracha){

        if (!cracha.matches("\\d{5}")) {
            throw new IllegalArgumentException("\u001B[31mErro: O número do crachá deve ter exatamente 5 dígitos.\u001B[0m");
        }

    } //fecha validarCracha()

    public static void validarSalario(double salario){

        if (salario < 0) {
            System.out.println("\u001B[31mErro: Os valores devem ser positivos (ou igual a 0).\u001B[0m");
        }

    }

}