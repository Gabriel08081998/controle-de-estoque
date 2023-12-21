package com.controle.de.estoque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class GerenciadorEstoqueAplication {
    public static void main(String[] args) {
        SpringApplication.run(GerenciadorEstoqueAplication.class, args);
    }
}


