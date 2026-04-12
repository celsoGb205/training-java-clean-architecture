package net.javaguides.http;

import java.util.ArrayList;
import java.util.List;

public final class Router {

    private final List<Route> routes = new ArrayList<>();


    public void register(HttpMethod method, String pathPattern, Controller controller){

        if(method == null){
            throw new IllegalArgumentException("Method não pode ser null.");
        }

        if(pathPattern == null|| pathPattern.isBlank() || !pathPattern.startsWith("/")){
            throw new IllegalArgumentException("PathPatter inválido.");
        }

        if(controller == null){
            throw new IllegalArgumentException("Controller não pode ser null.");
        }

        routes.add(new Route(method,pathPattern,controller));
    }

    public HttpResponse dispatch(HttpRequest request){

        if(request == null){
            throw new IllegalArgumentException("Request não pode ser null.");
        }

        for(Route route : routes){
            if(route.matches(request.getMethod(), request.getPath())){
                return route.controller.handle(request);
            }
        }

        return HttpResponse.notFound("Route not Found.");
    }

    private static final class Route{
        private final HttpMethod method;
        private final String pattern;
        private final Controller controller;

        public Route(HttpMethod method, String pattern, Controller controller) {
            this.method = method;
            this.pattern = pattern;
            this.controller = controller;
        }

        private boolean matches(HttpMethod method, String path){
            if(!this.method.equals(method)){
                return false;
            }

            if(!pattern.contains("{")){
                return pattern.equals(path);
            }

            String base = path.substring(0,pattern.indexOf("/{"));
            if(!path.startsWith(base + "/")){
                return false;
            }

            String param = path.substring((base + "/").length());

            return !param.isBlank();
        }
    }
}
