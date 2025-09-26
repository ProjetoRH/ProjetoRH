package application.service;

import application.mapper.FuncionarioParaUsuarioMapper;
import domain.model.Funcionario;
import domain.model.Usuario;

public class UsuarioService {
    private final FuncionarioParaUsuarioMapper funcionarioUsuarioMapper = new FuncionarioParaUsuarioMapper();


    public void cadastrarUsuario(Funcionario funcionario) {

        Usuario usuario = funcionarioUsuarioMapper.convert(funcionario);

        //metodo para cadastrar usuario(DAO)
    }
}
