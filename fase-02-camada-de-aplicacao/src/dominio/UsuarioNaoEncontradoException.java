package dominio;

public class UsuarioNaoEncontradoException extends RuntimeException{

    public UsuarioNaoEncontradoException(String email){
        super("Usuario não encontrado para o email: " + email);
    }
}
