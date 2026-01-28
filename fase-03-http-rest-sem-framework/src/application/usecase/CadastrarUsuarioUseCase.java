package application.usecase;

import application.dto.CadastrarUsuarioInput;
import application.dto.CadastrarUsuarioOutput;
import application.porst.UsuarioRepository;
import dominio.Email;
import dominio.Nome;
import dominio.Usuario;
import dominio.UsuarioJaExisteException;

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
            throw  new UsuarioJaExisteException(email.getEmail());
        }

        Nome nome = new Nome(input.nome());
        Usuario usuario = new Usuario(nome, email, input.idade());

        repository.salvar(usuario);

        return new CadastrarUsuarioOutput(
                usuario.getEmail().getEmail(),
                usuario.getNome().getNome(),
                usuario.getIdade()
        );
    }
}
