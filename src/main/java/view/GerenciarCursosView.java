package view;

import application.controller.CursoController;
import application.controller.InscricaoController;
import application.dto.curso.*;
import application.dto.inscricao.AtribuirCursoCargoRequest;
import application.dto.inscricao.AtribuirCursoFuncionarioRequest;
import application.factory.AppFactory;
import application.service.CursoService;
import domain.model.enums.StatusCurso;
import domain.model.enums.StatusCursoPessoal;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciarCursosView {
    private final Scanner scanner = new Scanner(System.in);
    private final CursoController cursoController;
    private final InscricaoController inscricaoController;

    public GerenciarCursosView() {
        this.cursoController = AppFactory.getCursoController();
        this.inscricaoController = AppFactory.getInscricaoController();
    }

    public void exibir() {
        while (true) {
            System.out.println("\n=== Gerenciar Cursos ===");
            System.out.println("[1] Listar Cursos");
            System.out.println("[2] Cadastrar Novo Curso");
            System.out.println("[3] Vincular Funcionário a Curso");
            System.out.println("[4] Atualizar Status de Curso");
            System.out.println("[5] Configurar Automação de Curso por Cargo");
            System.out.println("[0] Voltar");
            System.out.print("Escolha: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    listarCursos();
                    break;
                case "2":
                    cadastrarCurso();
                    break;
                case "3":
                    vincularFunionarioCurso();
                    break;
                case "4":
                    atualizarStatusCurso();
                    break;
                case "5":
                    AtribuirCursoCargoRequest();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void listarCursos() {
        List<ListarTodosCursoResponse> cursos = cursoController.listarTodosCurso();
        for (ListarTodosCursoResponse c : cursos) {
            System.out.println(c.idCurso() + " - " + c.nome() + " (" + c.status() + ")");
        }
    }

    private void cadastrarCurso() {
        System.out.print("Digite o nome do curso: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite a data de termino (yyyymmdd): ");
        Long dataNumero = scanner.nextLong();

        java.sql.Date data = new Date(dataNumero);


        CadastrarCursoRequest request = new CadastrarCursoRequest(nome, descricao, data);
        CadastrarCursoResponse response = cursoController.cadastrarCurso(request);

        System.out.println(" Curso cadastrado: " + response.nome());
    }

    private void atualizarStatusCurso() {
        System.out.print("ID do curso: ");
        int id = scanner.nextInt();

        System.out.println("\nSelecione o novo status:");
        System.out.println("[1] Ativo");
        System.out.println("[2] Inativo");
        System.out.print("Escolha: ");

        int escolha = scanner.nextInt();
        StatusCurso status;

        switch (escolha) {
            case 1 -> status = StatusCurso.ATIVO;
            case 2 -> status = StatusCurso.INATIVO;
            default -> {
                System.out.println(" Opção inválida!");
                return;
            }
        }

        EditarStatusCursoRequest request = new EditarStatusCursoRequest(id, status);
        EditarStatusCursoResponse response = cursoController.editarStatusCurso(request);

        System.out.println(" Status atualizado para: " + response.mensagem());

    }

    private void vincularFunionarioCurso() {
        List<Integer> idFuncionarios = new ArrayList<>();
        int idFuncionario;

        listarCursos();

        System.out.println("Digite o ID do Curso: ");
        int idCurso = scanner.nextInt();
        scanner.nextLine();

        GerenciarFuncionariosView gerenciarFuncionariosView = new GerenciarFuncionariosView();

        gerenciarFuncionariosView.listarFuncionarios();

        System.out.println("\n--- Seleção de Funcionários ---");
        System.out.println("Digite o ID do funcionário a ser vinculado (ou 0 para finalizar):");

        while (true) {
            System.out.print("ID: ");

            if (scanner.hasNextInt()) {
                idFuncionario = scanner.nextInt();
                scanner.nextLine();

                if (idFuncionario == 0) {
                    break;
                } else if (idFuncionario > 0) {
                    idFuncionarios.add(idFuncionario);
                    System.out.println("ID " + idFuncionario + " adicionado. Digite o próximo ou 0 para finalizar.");
                } else {
                    System.out.println("ID inválido. Digite um número positivo ou 0 para finalizar.");
                }
            } else {
                System.out.println("Entrada inválida. Digite apenas números.");
                scanner.nextLine();
            }
        }

        if (!idFuncionarios.isEmpty()) {

            AtribuirCursoFuncionarioRequest request = new AtribuirCursoFuncionarioRequest(
                    idCurso,
                    idFuncionarios
            );

            System.out.println("\nResumo: Vinculando o Curso ID " + idCurso +
                    " aos Funcionários IDs: " + idFuncionarios);


             inscricaoController.atribuirCursoFuncionario(request);
        } else {
            System.out.println("Nenhum funcionário selecionado. Operação cancelada.");
        }
    }

    public void AtribuirCursoCargoRequest(){

        listarCursos();
        System.out.print("Digite o ID do curso: ");
        int idCurso = scanner.nextInt();
        System.out.print("Digite o nome do cargo: ");
        String nomeCargo = scanner.nextLine();

        AtribuirCursoCargoRequest request = new AtribuirCursoCargoRequest(idCurso, nomeCargo);

        inscricaoController.atribuirCursoCargo(request);

    }
}

