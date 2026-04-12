package net.javaguides.http;

import java.util.Collections;
import java.util.Map;

public final class HttpRequest {

    private final HttpMethod method;
    private final String path;
    private final Map<String, String> body;

    public HttpRequest(HttpMethod method, String path, Map<String, String> body) {

        if(method == null){
            throw new IllegalArgumentException("HTTP method não pode ser null.");
        }

        if(path == null || path.isBlank() || !path.startsWith("/")){
            throw new IllegalArgumentException("Path inválido.");
        }

        this.method = method;
        this.path = path;
        this.body = body == null ? Collections.emptyMap() : Collections.unmodifiableMap(body);
    }

    public HttpMethod getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public Map<String, String> getBody() {
        return body;
    }
}
