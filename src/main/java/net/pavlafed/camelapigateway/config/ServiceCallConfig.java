package net.pavlafed.camelapigateway.config;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cloud.ServiceDefinition;
import org.apache.camel.cloud.ServiceDiscovery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceCallConfig extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        rest("/serviceCall")
                .verb("GET")
                .route()
                .serviceCall("camel-api-gateway/api/hello?bridgeEndpoint=true", "http4:camel-api-gateway/api/hello?bridgeEndpoint=true")
                .outputType(String.class).endRest()
        ;
    }
}
