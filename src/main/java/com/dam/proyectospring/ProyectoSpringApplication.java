package com.dam.proyectospring;

import com.dam.proyectospring.modelos.Piloto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class ProyectoSpringApplication {
    public static void main(String[] args) {

        SpringApplication.run(ProyectoSpringApplication.class, args);
        WebClient client = WebClient.create("http://localhost:8080");
        Mono<Piloto> pilotoMono = client.get()
                .uri("/api/piloto/{id}", 1)
                .retrieve()
                .bodyToMono(Piloto.class);
        pilotoMono.subscribe(System.out::println);
    }

}