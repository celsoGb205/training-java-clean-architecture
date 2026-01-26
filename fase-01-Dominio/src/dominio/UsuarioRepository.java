package dominio;

public interface UsuarioRepository {
    void salvar(Usuario usuario);
    boolean existemPorEmail(Email email);
}
