package net.javaguides.infra;

import net.javaguides.application.dto.CadastrarUsuarioInput;
import net.javaguides.application.dto.CadastrarUsuarioOutput;
import net.javaguides.application.usecase.CadastrarUsuarioUseCase;
import net.javaguides.dominio.UsuarioJaExisteException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CadastroUsuarioTest {


    @Test
    void deveCadastrarUsuarioValido() {
        var repo = new InMemoryUsuarioRepository();
        var useCase = new CadastrarUsuarioUseCase(repo);

        var input = new CadastrarUsuarioInput("Celso", "celso@gmail.com", 19);

        CadastrarUsuarioOutput output = useCase.executar(input);

        assertEquals("Celso", output.nome());
        assertEquals("celso@gmail.com", output.email());
        assertEquals(19, output.idade());
    }

    @Test
    void naoDevePermitirEmailDuplicado() {
        var repo = new InMemoryUsuarioRepository();
        var useCase = new CadastrarUsuarioUseCase(repo);

        var input = new CadastrarUsuarioInput("Celso", "celso@gmail.com", 19);

        useCase.executar(input);

        assertThrows(UsuarioJaExisteException.class, () -> {
            useCase.executar(input);
        });
    }

    @Test
    void deveCadastrarMultiplosUsuariosDiferentes() {
        var repo = new InMemoryUsuarioRepository();
        var useCase = new CadastrarUsuarioUseCase(repo);

        useCase.executar(new CadastrarUsuarioInput("Celso", "celso@gmail.com", 19));
        useCase.executar(new CadastrarUsuarioInput("Joao", "joao@gmail.com", 25));

        // se não lançar exceção, já passou
        assertTrue(true);
    }

    @Test
    void deveFalharComEmailInvalido() {
        var repo = new InMemoryUsuarioRepository();
        var useCase = new CadastrarUsuarioUseCase(repo);

        assertThrows(RuntimeException.class, () -> {
            useCase.executar(new CadastrarUsuarioInput("Celso", "email-invalido", 19));
        });
    }

}
