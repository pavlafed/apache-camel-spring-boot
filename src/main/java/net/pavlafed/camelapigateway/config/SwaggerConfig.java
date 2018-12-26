package net.pavlafed.camelapigateway.config;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestHostNameResolver;
import org.springframework.stereotype.Component;

@Component
public class SwaggerConfig extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration()
                //.component("netty4-http")
                //.component("servlet")
                //.bindingMode(RestBindingMode.json)
                .contextPath("/api")
                .apiProperty("basePath", "/api")
                .enableCORS(true)
                .port(8080)
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
