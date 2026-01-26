package application.ports;

import dominio.Email;
import dominio.Usuario;

import java.util.Optional;

public interface UsuarioRepository {

    boolean existePorEmail(Email email);

    void salvar(Usuario usuario);

    Optional<Usuario> buscarPorEmail(Email email);
}
