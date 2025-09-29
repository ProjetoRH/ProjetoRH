package application.service;

import application.mapper.FuncionarioParaUsuarioMapper;
import domain.model.Funcionario;
import domain.model.Usuario;
import domain.repository.FuncionarioRepository;
import domain.repository.UsuarioRepository;
import infrastructure.persistence.FuncionarioRepositoryImpl;
import infrastructure.persistence.UsuarioRepositoryImpl;
import shared.util.SenhaUtil;

public class UsuarioService {

    private final FuncionarioParaUsuarioMapper funcionarioUsuarioMapper = new FuncionarioParaUsuarioMapper();
    private final UsuarioRepository usuarioRepository = new UsuarioRepositoryImpl();


    public int cadastrarUsuario(Funcionario funcionario) {
        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionário não pode ser nulo.");
        }

        Usuario usuario = funcionarioUsuarioMapper.convert(funcionario);

        String senhaHash = SenhaUtil.hashSenha(usuario.getSenha());
        usuario.setSenha(senhaHash);

        return usuarioRepository.cadastrarUsuario(usuario);
    }
}
