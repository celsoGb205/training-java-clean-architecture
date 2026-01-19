package app;

import java.util.Scanner;

import dominio.Nome;
import dominio.Email;
import dominio.Usuario;
import dominio.UsuarioRepository;
import infra.InMemoryUsuarioRepository;

public class CadastroDeUsuario {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        UsuarioRepository repo = new InMemoryUsuarioRepository();


        Usuario u1 = new Usuario(
            new Nome("u1"),
            new Email("u1@gmail.com"),
            20
        );
        Usuario u2 = new Usuario(
                new Nome("u2"),
                new Email("u2@gmail.com"),
                30
        );

     repo.salvar(u1);
     repo.salvar(u2);
    }
}
