package net.javaguides.infra;

import net.javaguides.application.usecase.BuscarPorEmailUseCase;
import net.javaguides.application.usecase.CadastrarUsuarioUseCase;
import net.javaguides.controller.UsuarioController;
import net.javaguides.http.*;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class IntegracaoUsuarioTest {

    @Test
    void deveCadastrarUsuarioViaHttp() {

        var repo = new InMemoryUsuarioRepository();

        var cadastrar = new CadastrarUsuarioUseCase(repo);
        var buscar = new BuscarPorEmailUseCase(repo);

        var controller = new UsuarioController(cadastrar, buscar);

        var router = new Router();

        router.register(HttpMethod.POST, "/users", controller);

        HttpRequest request = new HttpRequest(
                HttpMethod.POST,
                "/users",
                Map.of(
                        "nome", "Celso",
                        "email", "celso@gmail.com",
                        "idade", "19"
                )
        );

        HttpResponse response = router.dispatch(request);

        assertEquals(201, response.getStatusCode());
    }
}