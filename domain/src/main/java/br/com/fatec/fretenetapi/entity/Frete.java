package br.com.fatec.fretenetapi.entity;

import java.math.BigDecimal;

public record Frete(
        String id,
        String idCliente,
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
