package net.javaguides.application.usecase;


import net.javaguides.application.dto.CadastrarUsuarioInput;
import net.javaguides.application.dto.CadastrarUsuarioOutput;
import net.javaguides.application.port.UsuarioRepository;
import net.javaguides.dominio.Email;
import net.javaguides.dominio.Nome;
import net.javaguides.dominio.Usuario;
import net.javaguides.dominio.UsuarioJaExisteException;

public final class CadastrarUsuarioUseCase {

    private final UsuarioRepository repository;

    public CadastrarUsuarioUseCase(UsuarioRepository repository) {
        this.repository = repository;
    }

    public CadastrarUsuarioOutput executar(CadastrarUsuarioInput input){

        if(input == null){
            throw new IllegalArgumentException("Input não pode ser null");
        }

        Email email = new Email(input.email());

        if(repository.existePorEmail(email)){
            throw new UsuarioJaExisteException(email.getEmail());
        }

        Nome nome = new Nome(input.nome());
        Usuario usuario = new Usuario(nome, email, input.idade());

        repository.salvar(usuario);

        return new CadastrarUsuarioOutput(
                usuario.getNome().getNome(),
                usuario.getEmail().getEmail(),
                usuario.getIdade()
        );
    }
}
