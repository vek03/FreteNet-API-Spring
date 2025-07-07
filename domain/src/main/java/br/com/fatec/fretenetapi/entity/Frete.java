package br.com.fatec.fretenetapi.entity;

import java.math.BigDecimal;

public record Frete(
        String id,
        String idCliente,
        BigDecimal valorFrete,
        Status status,
        Endereco endereco
) {
}
