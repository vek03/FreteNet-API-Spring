package br.com.fatec.fretenetapi.configuration.service;

import br.com.fatec.fretenetapi.repository.FreteRepository;
import br.com.fatec.fretenetapi.service.FreteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FreteServiceConfig {

    @Bean
    public FreteService freteService(
            FreteRepository repository) {
        return new FreteService(repository);
    }

}
