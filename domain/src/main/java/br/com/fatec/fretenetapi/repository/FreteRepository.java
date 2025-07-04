package br.com.fatec.fretenetapi.repository;

import br.com.fatec.fretenetapi.entity.Frete;

public interface FreteRepository {
    Frete save(Frete frete);

    Frete findById(String id);

    void delete(String id);
}
