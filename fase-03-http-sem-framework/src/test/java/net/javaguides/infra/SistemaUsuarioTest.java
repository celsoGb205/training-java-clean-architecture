package net.javaguides.infra;

import net.javaguides.application.usecase.BuscarPorEmailUseCase;
import net.javaguides.application.usecase.CadastrarUsuarioUseCase;
import net.javaguides.controller.UsuarioController;
import net.javaguides.http.*;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SistemaUsuarioTest {

    @Test
    void deveCadastrarEBuscarUsuario() {

        var repo = new InMemoryUsuarioRepository();

        var cadastrar = new CadastrarUsuarioUseCase(repo);
        var buscar = new BuscarPorEmailUseCase(repo);

        var controller = new UsuarioController(cadastrar, buscar);

        var router = new Router();

        router.register(HttpMethod.POST, "/users", controller);
        router.register(HttpMethod.GET, "/users/{email}", controller);

        HttpRequest post = new HttpRequest(
                HttpMethod.POST,
                "/users",
                Map.of(
                        "nome", "Celso",
                        "email", "celso@gmail.com",
                        "idade", "19"
                )
        );

        router.dispatch(post);

        HttpRequest get = new HttpRequest(
                HttpMethod.GET,
                "/users/celso@gmail.com",
                null
        );

        HttpResponse response = router.dispatch(get);

        assertEquals(200, response.getStatusCode());
        assertTrue(response.getBody().contains("Celso"));
    }
}