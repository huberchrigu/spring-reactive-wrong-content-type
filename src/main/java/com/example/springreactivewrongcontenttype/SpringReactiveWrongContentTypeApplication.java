package com.example.springreactivewrongcontenttype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

import java.util.Map;

@SpringBootApplication
public class SpringReactiveWrongContentTypeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringReactiveWrongContentTypeApplication.class, args);
    }

    @RestController
    public static class DemoController {
        @PostMapping
        public Map<String, Object> getAttributes(@RequestBody Body body, ServerWebExchange serverWebExchange) {
            return serverWebExchange.getAttribute(body.getAttribute());
        }
    }

    private static class Body {
        private final String attribute;

        Body(String attribute) {
            this.attribute = attribute;
        }

        public String getAttribute() {
            return attribute;
        }
    }
}
