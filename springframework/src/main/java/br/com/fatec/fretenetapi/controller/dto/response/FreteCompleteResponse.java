package br.com.fatec.fretenetapi.controller.dto.response;

import br.com.fatec.fretenetapi.entity.Endereco;

import java.math.BigDecimal;

public record FreteCompleteResponse(
        String id,
        String idCliente,
        BigDecimal valorFrete,
        String status,
        Endereco endereco
) {
}
