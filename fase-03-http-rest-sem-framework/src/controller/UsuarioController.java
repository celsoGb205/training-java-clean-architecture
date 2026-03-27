package controller;

import application.usecase.BuscarPorEmailUseCase;
import application.usecase.CadastrarUsuarioUseCase;
import http.Controller;
import http.HttpMethod;
import http.HttpRequest;
import http.HttpResponse;


public final class UsuarioController implements Controller {

    private final CadastrarUsuarioUseCase cadastrar;
    private final BuscarPorEmailUseCase buscar;

    public UsuarioController(CadastrarUsuarioUseCase cadastrar, BuscarPorEmailUseCase buscar) {
        if(cadastrar == null){
            throw new IllegalArgumentException("UseCase cadastrar não pode ser null.");
        }

        if(buscar == null){
            throw new IllegalArgumentException("UseCase buscar não pode ser null.");
        }

        this.cadastrar = cadastrar;
        this.buscar = buscar;
    }

    @Override
    public HttpResponse handle(HttpRequest request){
        if(request == null){
            return HttpResponse.badRequest("Request não pode ser null.");
        }

        if(request.getMethod() == HttpMethod.POST){
            return handlePost(request);
        }

        if(request.getMethod() == HttpMethod.GET){
            return handleGet(request);
        }

        return HttpResponse.notFound("Route not found.");
    }

    private HttpResponse handlePost(HttpRequest request){
       try{
            String nome = request.getBody().get("nome");
            String email = request.getBody().get("email");
            String idadeStr = request.getBody().get("idade");

            if(nome == null || email == null || idadeStr == null){
                return HttpResponse.badRequest("Campos obrigatorios: nome, email, idade.");
            }

            int idade;

            try{
                idade = Integer.parseInt(idadeStr);
            } catch (NumberFormatException e) {
                return HttpResponse.badRequest("idade inválida");
            }

            var input = new application.dto.CadastrarUsuarioInput(nome,email,idade);
            var output = cadastrar.executar(input);

            String body = output.nome() + " - " + output.email() + " - " + output.idade();

            return HttpResponse.created(body);

       } catch (dominio.UsuarioJaExisteException e) {
            return HttpResponse.conflict("Usuário já existe.");
       } catch (IllegalArgumentException e) {
           return HttpResponse.badRequest(e.getMessage());
       } catch (RuntimeException e) {
           return HttpResponse.internalError("Erro inesperado.");
       }
    }

    private HttpResponse handleGet(HttpRequest request){
        try{
            String path = request.getPath();

            if(! path.startsWith("/users/")){
                return HttpResponse.notFound("Route not found.");
            }

            String email = path.substring("/users/".length());

            if(email.isBlank()){
                return HttpResponse.badRequest("Email não informado.");
            }

            var input = new application.dto.BuscarPorEmailInput(email);
            var output = buscar.executar(input);

            String body = output.nome() + " - " + output.email() + " - " + output.idade();

            return HttpResponse.ok(body);
        } catch (dominio.UsuarioJaExisteException e) {
            return HttpResponse.conflict("Usuário já existe.");
        } catch (IllegalArgumentException e) {
            return HttpResponse.badRequest(e.getMessage());
        } catch (RuntimeException e) {
            return HttpResponse.internalError("Erro inesperado.");
        }
    }
}
