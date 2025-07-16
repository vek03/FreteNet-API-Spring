package br.com.fatec.fretenetapi.controller;

import br.com.fatec.fretenetapi.controller.adapter.FreteControllerAdapter;
import br.com.fatec.fretenetapi.controller.dto.request.FreteRequest;
import br.com.fatec.fretenetapi.controller.dto.response.FreteCompleteResponse;
import br.com.fatec.fretenetapi.controller.dto.response.FreteResponse;
import br.com.fatec.fretenetapi.controller.dto.response.HowMuchResponse;
import br.com.fatec.fretenetapi.entity.Frete;
import br.com.fatec.fretenetapi.repository.FreteRepository;
import br.com.fatec.fretenetapi.service.FreteService;
import jakarta.validation.Valid;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fretenet/v1")
public class FreteController {
    private final FreteRepository repository;
    private final FreteService service;

    public FreteController(FreteRepository repository, FreteService service) {
        this.repository = repository;
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/order")
    public FreteResponse save(@Valid @RequestBody FreteRequest request) {
        Frete frete = FreteControllerAdapter.cast(request);
        return FreteControllerAdapter.cast(service.register(frete));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/order/{id}")
    public FreteCompleteResponse getById(@PathVariable("id") String id) {
        return FreteControllerAdapter.castComplete(repository.findById(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/order/how-much/{uf}")
    @Cacheable(value = "frete-cache", key = "#uf")
    public HowMuchResponse howMuch(@PathVariable("uf") String uf) {
        return FreteControllerAdapter.cast(service.howMuch(uf));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/order/{id}")
    public void delete(@PathVariable("id") String id) {
        repository.delete(id);
    }

}
