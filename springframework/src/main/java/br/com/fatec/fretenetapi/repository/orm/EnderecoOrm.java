package br.com.fatec.fretenetapi.repository.orm;

import br.com.fatec.fretenetapi.entity.Estado;
import org.springframework.data.mongodb.core.index.Indexed;

public record EnderecoOrm(
        @Indexed
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        Estado uf
) {
}
