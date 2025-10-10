package application.factory;

import application.controller.*;
import application.mapper.*;
import application.service.*;
import domain.repository.*;
import infrastructure.persistence.*;

/**
 * Fábrica central responsável por criar e gerenciar instâncias únicas
 * de Services, Controllers, Repositories e Mappers.
 *
 * Serve como substituto leve de um contêiner de injeção de dependências (ex: Spring).
 */
public class AppFactory {

    // ==== MAPPERS ====
    private static final UsuarioMapper usuarioMapper = new UsuarioMapper();
    private static final FuncionarioMapper funcionarioMapper = new FuncionarioMapper();
    private static final CursoMapper cursoMapper = new CursoMapper();

    // ==== REPOSITORIES ====
    private static final UsuarioRepository usuarioRepository = new UsuarioRepositoryImpl();
    private static final CargoRepository cargoRepository = new CargoRepositoryImpl();
    private static final FuncionarioRepository funcionarioRepository = new FuncionarioRepositoryImpl();
    private static final InscricaoRepository inscricaoRepository = new InscricaoRepositoryImpl();
    private static final CursoRepository cursoRepository = new CursoReposityImpl();
    private static final SessaoRepository sessaoRepository = new SessaoRepositoryImpl();
    private static final RelatorioRepository relatorioRepository = new RelatorioRepositoryImpl();

    // ==== SERVICES ====
    private static final SessaoService sessaoService = new SessaoService(sessaoRepository);
    private static final UsuarioService usuarioService = new UsuarioService(usuarioMapper, usuarioRepository, sessaoService);
    private static final CargoService cargoService = new CargoService();
    private static final FuncionarioService funcionarioService = new FuncionarioService(
            funcionarioRepository,
            funcionarioMapper,
            usuarioService,
            cargoService
    );
    private static final InscricaoService inscricaoService = new InscricaoService(inscricaoRepository);
    private static final CursoService cursoService = new CursoService(cursoMapper, cursoRepository);
    private static final RelatorioService relatorioService = new RelatorioService(relatorioRepository);

    // ==== CONTROLLERS ====
    private static final FuncionarioController funcionarioController = new FuncionarioController(
            usuarioService,
            cargoService,
            funcionarioService,
            inscricaoService
    );
    private static final UsuarioController usuarioController = new UsuarioController(usuarioService);
    private static final InscricaoController inscricaoController = new InscricaoController(inscricaoService);
    private static final CursoController cursoController = new CursoController(cursoService);
    private static final SessaoController sessaoController = new SessaoController();
    private static final RelatorioController relatorioController = new RelatorioController(relatorioService);

    // ==== MÉTODOS DE ACESSO ====
    public static FuncionarioController getFuncionarioController() {
        return funcionarioController;
    }

    public static UsuarioController getUsuarioController() {
        return usuarioController;
    }

    public static InscricaoController getInscricaoController() {
        return inscricaoController;
    }

    public static CursoController getCursoController() {
        return cursoController;
    }

    public static SessaoController getSessaoController() {
        return sessaoController;
    }

    public static RelatorioController getRelatorioController() {
        return relatorioController;
    }

    public static UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public static FuncionarioService getFuncionarioService() {
        return funcionarioService;
    }

    public static CargoService getCargoService() {
        return cargoService;
    }

    public static CursoService getCursoService() {
        return cursoService;
    }

    public static InscricaoService getInscricaoService() {
        return inscricaoService;
    }

    public static SessaoService getSessaoService() {
        return sessaoService;
    }

    public static RelatorioService getRelatorioService() {
        return relatorioService;
    }
}
