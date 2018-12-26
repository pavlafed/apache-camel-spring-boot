package net.pavlafed.camelapigateway.config;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ServiceCallConfig extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        rest("/serviceCall")
                .consumes("application/json").produces("application/json")
                .get().description("Service Call example").outType(String.class)
                .route()
                .serviceCall("camel-api-gateway/api/hello?bridgeEndpoint=true")
                .endRest()
        ;
    }
}
