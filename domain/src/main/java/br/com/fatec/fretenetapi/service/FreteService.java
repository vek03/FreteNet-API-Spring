package br.com.fatec.fretenetapi.service;

import br.com.fatec.fretenetapi.entity.Estado;
import br.com.fatec.fretenetapi.entity.Frete;
import br.com.fatec.fretenetapi.exception.InternalServerException;
import br.com.fatec.fretenetapi.exception.NotFoundException;
import br.com.fatec.fretenetapi.exception.UnprocessableEntityException;
import br.com.fatec.fretenetapi.repository.FreteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FreteService {

    private static final Logger LOG = LoggerFactory.getLogger(FreteService.class);

    private final FreteRepository repository;

    public FreteService(
            FreteRepository repository) {
        this.repository = repository;
    }

    public Frete register(Frete frete) {
        try {
            Frete updateFrete = repository.findById(frete.id());
            return save(updateFrete.id(), frete);
        } catch (NotFoundException ex) {
            return save(frete);
        }
    }

    private Frete save(Frete frete) {
        return save(frete.id(), frete);
    }

    private Frete save(final String id, Frete frete) {
        try {
            return repository.save(new Frete(
                    id,
                    frete.idCliente(),
                    valorFrete(frete.endereco().uf()),
                    frete.status(),
                    frete.endereco()
            ));
        } catch (UnprocessableEntityException ex) {
            throw ex;
        } catch (Exception ex) {
            LOG.error("Erro na regra de negocio ao salvar: {} na data/hora: {}",
                    ex.getMessage(), LocalDateTime.now());
            throw new InternalServerException(ex);
        }
    }

    public BigDecimal howMuch(String uf){
        return valorFrete(Estado.porUf(uf));
    }

    private BigDecimal valorFrete(Estado uf){
        if(!uf.getTemFrete()){
            throw new UnprocessableEntityException("Não realizamos frete para este Estado!");
        }

        return uf.getValorFrete();
    }
}