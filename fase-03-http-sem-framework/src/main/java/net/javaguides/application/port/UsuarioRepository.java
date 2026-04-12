package net.javaguides.application.port;

import net.javaguides.dominio.Email;
import net.javaguides.dominio.Usuario;

import java.util.Optional;

public interface UsuarioRepository {

    boolean existePorEmail(Email email);

    void salvar(Usuario usuario);

    Optional<Usuario> buscarPorEmail(Email email);
}
