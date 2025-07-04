package br.com.fatec.fretenetapi.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public record FreteRequest(
        @NotBlank(message = "O id do cliente não pode ser vazio")
        String idCliente,
        @NotBlank(message = "O nome do cliente não pode ser vazio")
        String nomeCliente,
        @NotBlank(message = "O email do cliente não pode ser vazio")
        String emailCliente,
        @NotBlank(message = "O CEP não pode ser vazio")
        String cep,
        @NotBlank(message = "O logradouro não pode ser vazio")
        String logradouro,
        @NotBlank(message = "O complemento não pode ser vazio")
        String complemento,
        @NotBlank(message = "O bairro não pode ser vazio")
        String bairro,
        @NotBlank(message = "A localidade não pode ser vazio")
        String localidade,
        @NotBlank(message = "O UF não pode ser vazio")
        String uf
) {
}
