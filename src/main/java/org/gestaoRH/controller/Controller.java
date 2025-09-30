package org.gestaoRH.controller;

import org.gestaoRH.model.Funcionario;
import org.gestaoRH.service.Service;
import org.gestaoRH.utils.LerVariaveis;
import org.gestaoRH.view.InteracaoUsuario;
import org.gestaoRH.view.MensagensSistema;
import org.gestaoRH.view.MenuOpcoes;

public class Controller {

    private Service service;
    private MensagensSistema mensagensView;
    private MenuOpcoes menuView;
    private InteracaoUsuario interacaoView;

    public Controller(MenuOpcoes menuView, InteracaoUsuario interacaoView, MensagensSistema mensagensView, Service service) {
        this.menuView = menuView;
        this.interacaoView = interacaoView;
        this.mensagensView = mensagensView;
        this.service = service;
    }

    public void iniciar() {
        boolean executando = true;

        while (executando) {
            int opcaoMenu = menuView.menuPrincipal(0);

            switch (opcaoMenu) {

                //cadastrar funcionário
                case 1 -> {
                    Funcionario funcionario = interacaoView.cadastrarFuncionario();
                    service.cadastrarFuncionario(funcionario);
                }

                //listar funcionários
                case 2 -> {
                    service.listarFuncionariosPorNome();
                }

                //buscar funcionário
                case 3 -> {

                    int formaPesquisa = interacaoView.buscarFuncionarios();

                    if (formaPesquisa == 1){
                        String cracha = interacaoView.obterCracha();

                        try {
                            service.buscarFuncionariosPorCracha(cracha);
                        } catch (Exception e) {
                            MensagensSistema.mensagemPadraoErro(e.getMessage());
                        }

                    } else if (formaPesquisa == 2){
                        String nome = interacaoView.obterNome();

                        try {
                            service.buscarFuncionariosPorNome(nome);
                        } catch (Exception e) {
                            MensagensSistema.mensagemPadraoErro(e.getMessage());
                        }
                    }

                }

                //remover funcionário
                case 4 -> {

                    int formaRemocao = interacaoView.removerFuncionario();

                    if (formaRemocao == 1){
                        String cracha = interacaoView.obterCracha();

                        try {
                            service.removerFuncionarioPorCracha(cracha);
                        } catch (Exception e) {
                            MensagensSistema.mensagemPadraoErro(e.getMessage());
                        }

                    } else if (formaRemocao == 2){
                        String nome = interacaoView.obterNome();

                        try {
                            service.removerFuncionariosPorNome(nome);
                        } catch (Exception e) {
                            MensagensSistema.mensagemPadraoErro(e.getMessage());
                        }
                    }

                }

                //atualizar informações
                case 5 -> {

                    int formaAtualizar = interacaoView.atualizarInfo();
                    String cracha = InteracaoUsuario.obterCracha();

                    if (formaAtualizar == 1) {
                        service.atualizarCampo(cracha);
                    } if (formaAtualizar == 2) {
                        service.atualizarFuncionario(cracha);
                    }

                }

                //gerenciar status
                case 6 -> {
                    String cracha = InteracaoUsuario.obterCracha();
                    service.gerenciarStatus(cracha);
                }

                //voltar
                case 7 -> {
                    executando = false;
                }

                default -> {

                }

            } //fecha switch
        } //fecha while()
    } //fecha iniciar()
} //fecha classe