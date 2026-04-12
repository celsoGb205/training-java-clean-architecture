package net.javaguides.http;

public interface Controller {

    HttpResponse handle(HttpRequest request);
}
