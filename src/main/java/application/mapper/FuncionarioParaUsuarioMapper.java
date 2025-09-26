package application.mapper;

import domain.model.Funcionario;
import domain.model.Usuario;
import shared.util.SenhaUtil;

public class FuncionarioParaUsuarioMapper {

    public Usuario convert(Funcionario funcionario) {
        if(funcionario == null || funcionario.getEmail() == null) {
            throw new IllegalArgumentException("Funcionario ou Email não pode ser nulo");
        }

        Usuario novoUsuario = new Usuario(
                funcionario.getEmail(),
                SenhaUtil.geraSenha()
        );

        return novoUsuario;
    }
}
