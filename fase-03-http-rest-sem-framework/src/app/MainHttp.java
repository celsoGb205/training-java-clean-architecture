package app;

import application.usecase.BuscarPorEmailUseCase;
import application.usecase.CadastrarUsuarioUseCase;
import controller.UsuarioController;
import http.HttpMethod;
import http.HttpRequest;
import http.Router;
import infra.InMemoryUsuarioRepository;

import java.util.Map;

public class MainHttp {
    public static void main(String[] args){

        var repository = new InMemoryUsuarioRepository();
        var cadastrar =  new CadastrarUsuarioUseCase(repository);
        var buscar = new BuscarPorEmailUseCase(repository);

        var controller = new UsuarioController(cadastrar, buscar);

        var router = new Router();

        router.register(HttpMethod.POST,"/users", controller);
        router.register(HttpMethod.GET,"/users/{email}", controller);

        var request1 = new HttpRequest(
                HttpMethod.POST,
                "/users",
                Map.of(
                        "nome", "Celso",
                        "email", "cg@gmail.com",
                        "idade", "19"
                )
        );

        var response1 = router.dispatch(request1);

        System.out.println(response1.getStatusCode());
        System.out.println(response1.getBody());

        var request2 = new HttpRequest(
                HttpMethod.GET,
                "/users/cg@gmail.com",
                null
        );

        var response2 = router.dispatch(request2);

        System.out.println(response2.getStatusCode());
        System.out.println(response2.getBody());

        var response3 = router.dispatch(request1);

        System.out.println(response3.getStatusCode());
        System.out.println(response3.getBody());
    }
}
