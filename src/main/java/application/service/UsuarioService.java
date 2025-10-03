package application.service;

import application.dto.usuario.CadastrarUsuarioRequest;
import application.dto.usuario.LoginUsuarioRequest;
import application.mapper.UsuarioMapper;
import domain.model.Sessao;
import domain.model.Usuario;
import domain.model.valueobjects.Email;
import domain.repository.SessaoRepository;
import domain.repository.UsuarioRepository;
import infrastructure.persistence.UsuarioRepositoryImpl;
import shared.exceptions.AutenticacaoException;
import shared.util.SenhaUtil;

import java.sql.SQLException;

public class UsuarioService {

    private final UsuarioMapper mapper;
    private final UsuarioRepository usuarioRepository;
    private final SessaoService sessaoService;

    public UsuarioService(UsuarioMapper mapper, UsuarioRepository usuarioRepository, SessaoService sessaoService) {
        this.mapper = mapper;
        this.usuarioRepository = usuarioRepository;
        this.sessaoService = sessaoService;
    }

    public int cadastrarUsuario(CadastrarUsuarioRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Funcionário não pode ser nulo.");
        }

        Usuario usuario = mapper.toEntity(request);

        System.out.println("DEBUG senha: " + usuario.getSenha());

        String senhaHash = SenhaUtil.hashSenha(usuario.getSenha());
        usuario.setSenha(senhaHash);

        return usuarioRepository.cadastrarUsuario(usuario);
    }

    public Sessao validarUsuario(LoginUsuarioRequest request) throws SQLException {
        if (request == null || request.email() == null) {
            throw new IllegalArgumentException("Úsuario não pode ser nulo.");
        }

        Email email = request.email();

        Usuario usuario = usuarioRepository.buscarPorEmail(email);

        if(usuario == null || usuario.getEmail() == null) {
            throw new AutenticacaoException("Usuario ou Senha Invalida");
        }

        if(!SenhaUtil.verificaSenha(request.senha(),usuario.getSenha())) {
            throw new AutenticacaoException("Usuario ou Senha Invalida");
        }

        return sessaoService.autenticarSessao(usuario);
    }
}
