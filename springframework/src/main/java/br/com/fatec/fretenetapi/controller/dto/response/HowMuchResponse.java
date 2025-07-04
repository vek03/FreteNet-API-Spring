package br.com.fatec.fretenetapi.controller.dto.response;

import java.math.BigDecimal;

public record HowMuchResponse(
        BigDecimal valorFrete
) {
}
