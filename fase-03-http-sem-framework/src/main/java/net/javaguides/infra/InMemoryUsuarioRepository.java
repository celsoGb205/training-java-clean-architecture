package net.javaguides.infra;

import net.javaguides.application.port.UsuarioRepository;
import net.javaguides.dominio.Email;
import net.javaguides.dominio.Usuario;
import net.javaguides.dominio.UsuarioJaExisteException;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class InMemoryUsuarioRepository implements UsuarioRepository {
    private final Set<Usuario> usuarios = new HashSet<>();

    @Override
    public boolean existePorEmail(Email email){
        return usuarios.stream().anyMatch(u -> u.getEmail().equals(email));
    }

    @Override
    public void salvar(Usuario usuario){
        usuarios.add(usuario);
    }

    @Override
    public Optional<Usuario> buscarPorEmail(Email email){
        return usuarios.stream().filter(u -> u.getEmail().equals(email)).findFirst();
    }
}
