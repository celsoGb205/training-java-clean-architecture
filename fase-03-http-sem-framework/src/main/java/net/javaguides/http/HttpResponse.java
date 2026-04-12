package net.javaguides.http;

public final class HttpResponse {

    private final int statusCode;
    private final String body;

    public HttpResponse(int statusCode, String body) {

        if(statusCode < 100){
            throw new IllegalArgumentException("Status inválido.");
        }

        this.statusCode = statusCode;
        this.body = body == null ? "" : body;
    }

    public static HttpResponse ok(String body){
        return new HttpResponse(200, body);
    }

    public static HttpResponse created(String body){
        return new HttpResponse(201, body);
    }

    public static HttpResponse badRequest(String body){
        return new HttpResponse(400, body);
    }

    public static HttpResponse notFound(String body){
        return new HttpResponse(404, body);
    }

    public static HttpResponse conflict(String body){
        return new HttpResponse(409, body);
    }

    public static HttpResponse internalError(String body){
        return new HttpResponse(500, body);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getBody() {
        return body;
    }
}
