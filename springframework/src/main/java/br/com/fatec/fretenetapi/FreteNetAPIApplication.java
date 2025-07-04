package br.com.fatec.fretenetapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@EnableCaching
@SpringBootApplication
@EnableFeignClients(basePackages = "br.com.fatec.fretenetapi.integration.client")
public class FreteNetAPIApplication {
    public static void main(String[] args) {
        SpringApplication.run(FreteNetAPIApplication.class, args);
    }
}