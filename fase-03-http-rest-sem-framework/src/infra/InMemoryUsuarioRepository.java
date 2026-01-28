package infra;

import application.porst.UsuarioRepository;
import dominio.Email;
import dominio.Usuario;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class InMemoryUsuarioRepository implements UsuarioRepository {
    private final Set<Usuario> usuarios = new HashSet<>();

    public boolean existePorEmail(Email email){
        return usuarios.stream().anyMatch(u -> u.getEmail().equals(email));
    }

    public void salvar(Usuario usuario){
        usuarios.add(usuario);
    }

    public Optional<Usuario> buscarPorEmail(Email email){
        return usuarios.stream().filter(u -> u.getEmail().equals(email)).findFirst();
    }
}
