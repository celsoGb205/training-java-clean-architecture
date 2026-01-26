package infra;

import dominio.*;

import java.util.HashSet;
import java.util.Set;


public class InMemoryUsuarioRepository implements UsuarioRepository{

    private final Set<Usuario> usuarios = new HashSet<>();

    @Override
    //Salvar usuario na memória
    public void salvar(Usuario usuario){
        //verificação de email já existentes
        if(usuario == null){
            throw  new IllegalArgumentException("Usuario não pode ser null");
        }

        if(existemPorEmail(usuario.getEmail())){
            throw new UsuarioJaExisteException(
                    "Usuario já existe com esse email: " + usuario.getEmail().getValor()
            );
        }

        //adicionando usuarios
        usuarios.add(usuario);
    }

    @Override
    public boolean existemPorEmail(Email email) {
        return usuarios.stream().anyMatch(u -> u.getEmail().equals(email));
    }
}
