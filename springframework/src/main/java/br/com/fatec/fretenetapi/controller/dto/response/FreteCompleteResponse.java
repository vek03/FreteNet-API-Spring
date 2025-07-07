package br.com.fatec.fretenetapi.controller.dto.response;

import br.com.fatec.fretenetapi.entity.Estado;

import java.math.BigDecimal;

public record FreteCompleteResponse(
        String id,
        String idCliente,
        BigDecimal valorFrete,
        String status,
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf
) {
}
