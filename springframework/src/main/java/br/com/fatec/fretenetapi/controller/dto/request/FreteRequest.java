package br.com.fatec.fretenetapi.controller.dto.request;

public record FreteRequest(
        String idCliente,
        String nomeCliente,
        String emailCliente,
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf
) {
}
