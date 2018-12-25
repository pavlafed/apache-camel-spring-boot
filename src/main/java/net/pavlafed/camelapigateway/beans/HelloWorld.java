package net.pavlafed.camelapigateway.beans;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {

    public String hello() {
        return "{\"response\":\"hellow !\"}";
    }
}
