package daggerok.webapp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static org.springframework.web.servlet.function.RequestPredicates.path;
import static org.springframework.web.servlet.function.RouterFunctions.route;

@SpringBootApplication
public class Webapp2Application extends SpringBootServletInitializer {

  @Bean
  RouterFunction<ServerResponse> routes() {
    return route().nest(path("/"),
                        builder -> builder.GET("/hello", this::hello)
                                          .build())
                  .build()
                  .andRoute(path("/**"), this::fallback);
  }

  private ServerResponse hello(ServerRequest serverRequest) {
    return ServerResponse.ok().body(Collections.singletonMap("message", "Hello, World 2!"));
  }

  private ServerResponse fallback(ServerRequest serverRequest) {
    URI uri = serverRequest.uri();
    Function<String, String> base = path -> String.format("%s://%s%s", uri.getScheme(), uri.getAuthority(), path);
    HashMap<Object, Object> body = new HashMap<>();
    body.putIfAbsent("_self", serverRequest.uri());
    body.putIfAbsent("hello 2 GET", base.apply("/hello"));
    return ServerResponse.ok().body(body);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(Webapp2Application.class);
  }

  public static void main(String[] args) {
    SpringApplication.run(Webapp2Application.class, args);
  }
}
