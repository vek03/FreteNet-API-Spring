package br.com.fatec.fretenetapi.repository.orm;

import org.springframework.data.mongodb.core.index.Indexed;

public record StatusOrm(
        @Indexed
        String descricao
) {
}
