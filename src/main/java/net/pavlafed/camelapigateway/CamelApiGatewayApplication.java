package net.pavlafed.camelapigateway;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestHostNameResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CamelApiGatewayApplication extends RouteBuilder {

	public static void main(String[] args) {
		SpringApplication.run(CamelApiGatewayApplication.class, args);
	}

	@Override
	public void configure() throws Exception {

		restConfiguration()
				//.component("netty4-http")
				.component("servlet")
				.bindingMode(RestBindingMode.json)
				.contextPath("/camel")
				.enableCORS(true)
				.port(8080)
				.hostNameResolver(RestHostNameResolver.localHostName)
				.apiContextPath("/api-doc")
				.apiProperty("api.title", "Example API")
				.apiProperty("api.version", "1.0")
				.apiContextRouteId("doc-api")
				.apiProperty("cors", "true")
				.dataFormatProperty("prettyPrint", "true")
		;

		rest("/hello")
				.consumes("application/json").produces("application/json")
				.get("/").description("Hello World example").outType(String.class)
					.to("bean:helloWorld?method=hello");
	}
}

