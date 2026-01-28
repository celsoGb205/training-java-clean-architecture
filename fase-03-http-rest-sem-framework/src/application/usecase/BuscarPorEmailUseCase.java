package application.usecase;

import application.dto.BuscarPorEmailInput;
import application.dto.BuscarPorEmailOutput;
import application.porst.UsuarioRepository;
import dominio.Email;
import dominio.Usuario;
import dominio.UsuarioNaoEncontradoException;

public final class BuscarPorEmailUseCase {

    private final UsuarioRepository repository;

    public BuscarPorEmailUseCase(UsuarioRepository repository) {
        this.repository = repository;
    }

    public BuscarPorEmailOutput executar(BuscarPorEmailInput input){
        if(input == null){
            throw new IllegalArgumentException("Input não pode ser null");
        }

        Email email = new Email(input.email());

        Usuario usuario = repository.buscarPorEmail(email).orElseThrow(() -> new UsuarioNaoEncontradoException(email.getEmail()));

        return new BuscarPorEmailOutput(
            usuario.getNome().getNome(),
            usuario.getEmail().getEmail(),
            usuario.getIdade()
        );
    }
}
