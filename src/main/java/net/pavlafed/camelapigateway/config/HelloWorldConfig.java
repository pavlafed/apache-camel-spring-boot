package net.pavlafed.camelapigateway.config;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldConfig extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        rest("/hello")
                .consumes("application/json").produces("application/json")
                .get("/").description("Hello World example").outType(String.class)
                .to("bean:helloWorld?method=hello");
    }
}
