package br.com.fatec.fretenetapi.entity;

public record Endereco(
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        Estado uf
) {
}
