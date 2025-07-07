package br.com.fatec.fretenetapi.repository.orm;

import br.com.fatec.fretenetapi.entity.Status;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "fretes")
public record FreteOrm(
        @Id
        String id,
        String idCliente,
        BigDecimal valorFrete,
        Status status,
        EnderecoOrm endereco
) {
}
