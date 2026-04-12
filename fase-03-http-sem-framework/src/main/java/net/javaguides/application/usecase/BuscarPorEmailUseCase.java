package net.javaguides.application.usecase;


import net.javaguides.application.dto.BuscarPorEmailInput;
import net.javaguides.application.dto.BuscarPorEmailOutput;
import net.javaguides.application.port.UsuarioRepository;
import net.javaguides.dominio.Email;
import net.javaguides.dominio.Usuario;
import net.javaguides.dominio.UsuarioNaoEncontradoException;

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
