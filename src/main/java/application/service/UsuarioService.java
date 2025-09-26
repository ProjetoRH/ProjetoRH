package application.service;

import domain.model.Usuario;
import shared.util.SenhaUtil;

public class UsuarioService {

    public void cadastrarUsuario(Usuario usuario) {
        //Define uma senha aleatória de 5 digitos
        usuario.setSenha_hash(SenhaUtil.geraSenha());

        //metodo para cadastrar usuario(DAO)
    }
}
