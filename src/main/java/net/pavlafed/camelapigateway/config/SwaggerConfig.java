package net.pavlafed.camelapigateway.config;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestHostNameResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwaggerConfig extends RouteBuilder {

    @Value("${server.port:8080}")
    int port;

    @Override
    public void configure() throws Exception {
        restConfiguration()
                .contextPath("/api")
                .apiProperty("basePath", "/api")
                .enableCORS(true)
                .port(port)
                .hostNameResolver(RestHostNameResolver.localHostName)
                .apiContextPath("/swagger")
                .apiProperty("api.title", "Example API")
                .apiProperty("api.version", "1.0")
                .apiContextRouteId("swagger")
                .apiProperty("cors", "true")
                .dataFormatProperty("prettyPrint", "true")
        ;
    }
}
