package br.com.fatec.fretenetapi.controller.dto.response;

import java.math.BigDecimal;

public record FreteResponse(
        String id,
        String idCliente,
        BigDecimal valorFrete
) {
}
