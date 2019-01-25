package net.pavlafed.camelapigateway.config;

import net.pavlafed.camelapigateway.model.Order;
import org.apache.camel.ValidationException;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class ApiGatewayConfig extends RouteBuilder {

    public void configure() throws Exception {
        rest("/orders")
                .bindingMode(RestBindingMode.json)
                .post()
                .consumes("application/json").produces("application/json").description("API for orders")
                .type(Order.class).outType(String.class)
                .to("direct:newOrder");

        validator()
                .type(Order.class)
                .withBean("orderValidator");

        onException(ValidationException.class).handled(true)
                .transform(exceptionMessage());

        from("direct:newOrder")
                .outputTypeWithValidate(Order.class)
                .log("Got new order: ${body}")
                .endRest()
        ;
    }
}
