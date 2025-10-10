package view;

import application.controller.InscricaoController;
import application.dto.curso.DetalheCursoResponse;
import application.dto.curso.ListarMeusCursosResponse;
import application.factory.AppFactory;
import application.sessao.SessaoSistema;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MeusCursosView {
    private final Scanner scanner = new Scanner(System.in);
    private final InscricaoController inscricaoController = AppFactory.getInscricaoController();


    public void exibir() {
        System.out.println("\n=== Meus Cursos ===");

        try {
            int idFuncionario = SessaoSistema.obterInstancia().obterSessaoId();

            List<ListarMeusCursosResponse> meusCursos = inscricaoController.listarMeusCursos(idFuncionario);

            if (meusCursos.isEmpty()) {
                System.out.println("Você não está matriculado em nenhum curso no momento.");
                return;
            }

            System.out.println("Cursos em que você está matriculado:");
            for (int i = 0; i < meusCursos.size(); i++) {
                ListarMeusCursosResponse curso = meusCursos.get(i);
                System.out.printf("[%d] %s (Seu status: %s)%n", i + 1, curso.nomeCurso(), curso.statusPessoal());
            }

            while (true) {
                System.out.print("\nDigite o número do curso para ver detalhes (ou 0 para voltar): ");
                String input = scanner.nextLine();

                try {
                    int escolha = Integer.parseInt(input);

                    if (escolha == 0) {
                        System.out.println("Voltando ao menu anterior...");
                        break;
                    }

                    if (escolha > 0 && escolha <= meusCursos.size()) {
                        int idCursoSelecionado = meusCursos.get(escolha - 1).idCurso();

                        exibirDetalhesDoCurso(idFuncionario, idCursoSelecionado);

                        break;
                    } else {
                        System.out.println("Opção inválida. Escolha um número da lista.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Digite apenas números.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Ocorreu um erro de banco de dados ao buscar seus cursos. Por favor, tente mais tarde.");
            e.printStackTrace();
        } catch (IllegalStateException e) {
            System.err.println("Erro de sessão: " + e.getMessage());
        }
    }


    private void exibirDetalhesDoCurso(int idFuncionario, int idCurso) throws SQLException {
        DetalheCursoResponse detalhes = inscricaoController.detalharMeuCurso(idFuncionario, idCurso);

        if (detalhes != null) {
            System.out.println("==========  DETALHES DO CURSO ==========");
            System.out.printf("  Nome: %s%n", detalhes.nomeCurso());
            System.out.printf("  Descrição: %s%n", detalhes.descricao());
            System.out.println("  ------------------------------------");
            System.out.printf("  Seu Status: %s%n", detalhes.statusPessoal());
            System.out.printf("  Status Geral do Curso: %s%n", detalhes.statusGeral());
        } else {
            System.out.println("Não foi possível carregar os detalhes para o curso selecionado.");
        }
    }
}