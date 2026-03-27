package http;

public interface Controller {

    HttpResponse handle(HttpRequest request);
}
