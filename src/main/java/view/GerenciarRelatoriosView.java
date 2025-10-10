package view;

import application.controller.CursoController;
import application.controller.RelatorioController;
import application.dto.curso.ListarTodosCursoResponse;
import application.dto.relatorio.ParticipanteCursoPendenteResponse; // Import necessário
import application.dto.relatorio.ParticipanteCursoResponse;
import application.dto.relatorio.RelatorioCursoParticipantePendenteResponse; // Import necessário
import application.dto.relatorio.RelatorioCursoParticipantesResponse;
import application.dto.relatorio.RelatorioGeralCursoResponse;
import application.factory.AppFactory;

import java.util.InputMismatchException; // Import para tratar erro de entrada
import java.util.List;
import java.util.Scanner;

public class GerenciarRelatoriosView {

    private final CursoController cursoController;
    private final RelatorioController relatorioController;
    private final Scanner scanner = new Scanner(System.in);

    public GerenciarRelatoriosView() {
        this.cursoController = AppFactory.getCursoController();
        this.relatorioController = AppFactory.getRelatorioController();
    }

    public void exibir() {
        while (true) {
            System.out.println("\n=== Gerenciar Relatorios ===");
            System.out.println("[1] Detalhar Cursos e Participantes");
            System.out.println("[2] Relatório de Pendentes por Curso");
            System.out.println("[3] Relatório de Cursos (Geral)");
            System.out.println("[0] Voltar");

            System.out.print("Escolha: ");
            try {
                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        detalharCursosEParticipantes();
                        break;
                    case 2:
                        relatorioPendentesPorCurso();
                        break;
                    case 3:
                        relatorioGeralCurso();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
            }
        }
    }

    private void listarCursos() {

        List<ListarTodosCursoResponse> cursos = cursoController.listarTodosCurso();

        for (ListarTodosCursoResponse c : cursos) {

            System.out.println(c.idCurso() + " - " + c.nome() + " (" + c.status() + ")");

        }

    }

    private void relatorioGeralCurso() {
        try {
            System.out.println("\n==================================== Relatório Geral de Cursos ====================================");
            List<RelatorioGeralCursoResponse> relatorio = relatorioController.relatorioGeralCurso();

            if (relatorio.isEmpty()) {
                System.out.println("Nenhum curso encontrado.");
                return;
            }

            System.out.printf("%-30s | %-10s | %-10s | %-10s | %-10s%n", "CURSO", "STATUS", "INSCRITOS", "CONCLUÍDOS", "PENDENTES");
            System.out.println("=====================================================================================================");

            for (RelatorioGeralCursoResponse r : relatorio) {
                System.out.printf("%-30s | %-10s | %-10d | %-10d | %-10d%n",
                        r.nomeCurso(), r.statusCurso(), r.totalInscritos(), r.totalConcluidos(), r.totalPendentes());
            }
            System.out.println("=====================================================================================================");
        } catch (Exception e) {
            System.err.println("Ocorreu um erro ao gerar o relatório geral: " + e.getMessage());
        }
    }

    public void detalharCursosEParticipantes() {
        System.out.println("\n=============== Detalhes de Cursos e Participantes ===============");
        try {
            List<ListarTodosCursoResponse> cursos = cursoController.listarTodosCurso();
            if (cursos.isEmpty()) {
                System.out.println("Nenhum curso cadastrado para detalhar.");
                return;
            }
            System.out.println("Selecione um curso para ver os detalhes:");
            for (int i = 0; i < cursos.size(); i++) {
                System.out.printf("[%d] %s (%s)%n", i + 1, cursos.get(i).nome(), cursos.get(i).status());
            }
            System.out.println("[0] Voltar ao menu anterior");

            while (true) {
                System.out.print("Escolha: ");
                int escolha = scanner.nextInt();
                if (escolha == 0) return;
                if (escolha > 0 && escolha <= cursos.size()) {
                    int idCursoSelecionado = cursos.get(escolha - 1).idCurso();
                    RelatorioCursoParticipantesResponse cursoDetalhado = relatorioController.relatorioCursoParticipantes(idCursoSelecionado);
                    imprimirDetalhesDoCurso(cursoDetalhado);
                    break;
                } else {
                    System.out.println("Opção inválida.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Digite um número.");
        } catch (Exception e) {
            System.err.println("Ocorreu um erro ao detalhar cursos: " + e.getMessage());
        }
    }

    private void imprimirDetalhesDoCurso(RelatorioCursoParticipantesResponse curso) {

        if (curso == null) {

            System.out.println("Não foi possível encontrar informações para o curso selecionado.");

            return;

        }
    }

    public void relatorioPendentesPorCurso() {
        System.out.println("\n=============== Relatório de Participantes Pendentes ===============");
        try {
            List<ListarTodosCursoResponse> cursos = cursoController.listarTodosCurso();
            if (cursos.isEmpty()) {
                System.out.println("Nenhum curso cadastrado para detalhar.");
                return;
            }
            System.out.println("Selecione um curso para ver os participantes pendentes:");
            for (int i = 0; i < cursos.size(); i++) {
                System.out.printf("[%d] %s (%s)%n", i + 1, cursos.get(i).nome(), cursos.get(i).status());
            }
            System.out.println("[0] Voltar ao menu anterior");

            while (true) {
                System.out.print("Escolha: ");
                int escolha = scanner.nextInt();
                if (escolha == 0) return;

                if (escolha > 0 && escolha <= cursos.size()) {
                    int idCursoSelecionado = cursos.get(escolha - 1).idCurso();

                    RelatorioCursoParticipantePendenteResponse cursoComPendentes = relatorioController.relatorioCursoParticipantePendente(idCursoSelecionado);

                    String nomeCursoSelecionado = cursos.get(escolha - 1).nome();
                    imprimirRelatorioPendentes(cursoComPendentes, nomeCursoSelecionado);
                    break;
                } else {
                    System.out.println("Opção inválida.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Digite um número.");
        } catch (Exception e) {
            System.err.println("Ocorreu um erro ao gerar o relatório de pendentes: " + e.getMessage());
        }
    }

    private void imprimirRelatorioPendentes(RelatorioCursoParticipantePendenteResponse curso, String nomeCurso) {
        System.out.printf("\n============================================\n");
        System.out.printf("PENDENTES DO CURSO: %s\n", nomeCurso);
        System.out.println("--------------------------------------------");

        if (curso == null || curso.participantes().isEmpty()) {
            System.out.println("(Nenhum participante pendente neste curso)");
        } else {
            System.out.printf("%-25s | %-15s | %-15s%n", "Funcionário", "Cargo", "Status");
            System.out.println("----------------------------------------------------------------");
            for (ParticipanteCursoPendenteResponse p : curso.participantes()) {
                System.out.printf("%-25s | %-15s | %-15s%n", p.nomeFuncionario(), p.nomeCargo(), p.statusCursoPessoal());
            }
        }
        System.out.println("============================================\n");
    }
}