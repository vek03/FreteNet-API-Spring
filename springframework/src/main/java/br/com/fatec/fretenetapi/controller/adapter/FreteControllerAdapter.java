package br.com.fatec.fretenetapi.controller.adapter;

import br.com.fatec.fretenetapi.controller.dto.request.FreteRequest;
import br.com.fatec.fretenetapi.controller.dto.response.FreteCompleteResponse;
import br.com.fatec.fretenetapi.controller.dto.response.FreteResponse;
import br.com.fatec.fretenetapi.controller.dto.response.HowMuchResponse;
import br.com.fatec.fretenetapi.entity.Endereco;
import br.com.fatec.fretenetapi.entity.Estado;
import br.com.fatec.fretenetapi.entity.Frete;
import br.com.fatec.fretenetapi.entity.Status;
import java.math.BigDecimal;
import java.util.UUID;

public class FreteControllerAdapter {
    private FreteControllerAdapter() {
    }

    public static FreteResponse cast(Frete frete) {
        return new FreteResponse(
                frete.id(),
                frete.idCliente(),
                frete.valorFrete()
        );
    }

    public static FreteCompleteResponse castComplete(Frete frete) {
        return new FreteCompleteResponse(
                frete.id(),
                frete.idCliente(),
                frete.valorFrete(),
                frete.status().getDescricao(),
                frete.endereco()
        );
    }

    public static Frete cast(FreteRequest request) {
        return new Frete(
                UUID.randomUUID().toString(),
                request.idCliente(),
                BigDecimal.ZERO,
                Status.PROCESSANDO,
                new Endereco(
                    request.cep(),
                    request.logradouro(),
                    request.complemento(),
                    request.bairro(),
                    request.localidade(),
                    Estado.porUf(request.uf())
                )
        );
    }

    public static HowMuchResponse cast(BigDecimal valorFrete){
        return new HowMuchResponse(
                valorFrete
        );
    }
}
