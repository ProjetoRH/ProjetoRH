package view;

import application.controller.FuncionarioController;
import application.dto.funcionario.*;
import application.factory.AppFactory;
import domain.model.valueobjects.Email;
import domain.model.valueobjects.Telefone;
import infrastructure.persistence.xlsx.LerExcel;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class GerenciarFuncionariosView {
    private final Scanner scanner = new Scanner(System.in);

    private final FuncionarioController funcionarioController = AppFactory.getFuncionarioController();

    public void exibir() throws SQLException {
        while (true) {
            System.out.println("\n=== Gerenciar Funcionários ===");
            System.out.println("[1] Listar Funcionários");
            System.out.println("[2] Cadastrar Novo Funcionário");
            System.out.println("[3] Cadastrar Múltiplos (via Excel)");
            System.out.println("[4] Deletar Funcionário");
            System.out.println("[0] Voltar");
            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    listarFuncionarios();
                    break;
                case 2:
                    cadastrarFuncionario();
                    break;
                case 3:
                    cadastrarMultiplosFuncionarios();
                    break;
                case 4:
                    deletarFuncionario();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public void listarFuncionarios() {
        try {
            List<ListarTodosFuncionarioResponse> funcionarios = funcionarioController.listarTodosFuncionarios();

            if (funcionarios.isEmpty()) {
                System.out.println("Nenhum funcionário encontrado.");
                return;
            }

            System.out.println("\n============== Lista de Funcionários ==============");
            System.out.printf("%-5s %-25s %-20s%n", "ID", "Nome", "Cargo");
            System.out.println("----------------------------------------------------");

            for (ListarTodosFuncionarioResponse f : funcionarios) {
                System.out.printf("%-5d %-25s %-20s%n",
                        f.id(),
                        f.nome(),
                        f.cargo());
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar funcionários: " + e.getMessage());
        }
    }

    private CadastrarFuncionarioResponse cadastrarFuncionario() throws SQLException {

        System.out.println("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o Email: ");
        String emailString = scanner.nextLine();

        System.out.println("Digite o cargo: ");
        String cargo = scanner.nextLine();

        System.out.println("Digite o Telefone: ");
        String telefoneString = scanner.nextLine();

        System.out.println("Digite o Setor: ");
        String departamento = scanner.nextLine();

        Email email = new Email(emailString);
        Telefone telefone = new Telefone(telefoneString);

        FuncionarioControllerRequest request = new FuncionarioControllerRequest(
                nome,email,telefone,cargo,departamento);

        return funcionarioController.cadastrarFuncionario(request);
    }

    private void cadastrarMultiplosFuncionarios() {
        System.out.println("Digite o caminho do arquivo Excel (.xlsx): ");
        String caminho = scanner.nextLine();

        LerExcel lerExcel = new LerExcel();
        try {
            List<FuncionarioControllerRequest> funcionarios = lerExcel.lerExcel(caminho);

            if (funcionarios.isEmpty()) {
                System.out.println("Nenhum funcionário encontrado no arquivo.");
                return;
            }

            System.out.println("\n=== Cadastrando Funcionários ===");

            for (FuncionarioControllerRequest request : funcionarios) {
                try {
                    CadastrarFuncionarioResponse response = funcionarioController.cadastrarFuncionario(request);
                    System.out.printf("Funcionário '%s' cadastrado com sucesso! ID: %d%n",
                            request.nome(), response.idFuncionario());
                } catch (Exception e) {
                    System.out.printf("Erro ao cadastrar '%s': %s%n", request.nome(), e.getMessage());
                }
            }

            System.out.println("\nCadastro em massa concluído.");

        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo Excel: " + e.getMessage());
        }
    }

    public void deletarFuncionario() {

        listarFuncionarios();
        System.out.println("Digite o ID do funcionario: ");
        int idFuncionario = scanner.nextInt();

        ExcluirFuncionarioRequest request = new ExcluirFuncionarioRequest(idFuncionario);

        funcionarioController.excluirFuncionario(request);
    }

}
