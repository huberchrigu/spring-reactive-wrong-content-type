package com.example.springreactivewrongcontenttype;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient
class SpringReactiveWrongContentTypeApplicationTests {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void postRequestWithWrongContentType() {
        webTestClient.post().uri("/")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .bodyValue("{}")
                .exchange()
                .expectStatus().isBadRequest();
    }
}
