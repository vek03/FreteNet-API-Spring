package br.com.fatec.fretenetapi.repository.orm;

import br.com.fatec.fretenetapi.entity.Estado;
import br.com.fatec.fretenetapi.entity.Status;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "fretes")
public record FreteOrm(
        @Id
        String id,
        String idCliente,
        String nomeCliente,
        String emailCliente,
        BigDecimal valorFrete,
        Status status,
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        Estado uf
) {
}
