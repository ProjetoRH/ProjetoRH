package application.mapper;

import domain.model.Sessao;
import domain.model.Usuario;

public class SessaoMapper {

    public Sessao toEntity(Usuario usuario) {
        return new Sessao(usuario);
    }
}
