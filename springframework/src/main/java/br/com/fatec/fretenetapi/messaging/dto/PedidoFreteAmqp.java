package br.com.fatec.fretenetapi.messaging.dto;

public record PedidoFreteAmqp(
        String idCliente,
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf
) {
}