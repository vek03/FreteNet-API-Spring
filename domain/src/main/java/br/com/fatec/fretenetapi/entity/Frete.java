package br.com.fatec.fretenetapi.entity;

import java.math.BigDecimal;

public record Frete(
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
