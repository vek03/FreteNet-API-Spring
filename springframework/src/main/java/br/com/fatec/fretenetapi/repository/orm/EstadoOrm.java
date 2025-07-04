package br.com.fatec.fretenetapi.repository.orm;

import org.springframework.data.mongodb.core.index.Indexed;

import java.math.BigDecimal;

public record EstadoOrm(
        @Indexed
        int codigo,
        String uf,
        String nome,
        BigDecimal valorFrete,
        Boolean temFrete
) {
}
