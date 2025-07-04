package br.com.fatec.fretenetapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class FreteNetAPIApplication {
    public static void main(String[] args) {
        SpringApplication.run(FreteNetAPIApplication.class, args);
    }
}