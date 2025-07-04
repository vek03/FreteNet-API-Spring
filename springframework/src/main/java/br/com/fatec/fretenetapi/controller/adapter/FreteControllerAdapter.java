package br.com.fatec.fretenetapi.controller.adapter;

import br.com.fatec.fretenetapi.controller.dto.request.FreteRequest;
import br.com.fatec.fretenetapi.controller.dto.response.FreteCompleteResponse;
import br.com.fatec.fretenetapi.controller.dto.response.FreteResponse;
import br.com.fatec.fretenetapi.controller.dto.response.HowMuchResponse;
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
                frete.nomeCliente(),
                frete.valorFrete()
        );
    }

    public static FreteCompleteResponse castComplete(Frete frete) {
        return new FreteCompleteResponse(
                frete.id(),
                frete.idCliente(),
                frete.nomeCliente(),
                frete.emailCliente(),
                frete.valorFrete(),
                frete.status().getDescricao(),
                frete.cep(),
                frete.logradouro(),
                frete.complemento(),
                frete.bairro(),
                frete.localidade(),
                frete.uf().getUf()
        );
    }

    public static Frete cast(FreteRequest request) {
        return new Frete(
                UUID.randomUUID().toString(),
                request.idCliente(),
                request.nomeCliente(),
                request.emailCliente(),
                BigDecimal.ZERO,
                Status.PROCESSANDO,
                request.cep(),
                request.logradouro(),
                request.complemento(),
                request.bairro(),
                request.localidade(),
                Estado.porUf(request.uf())
        );
    }

    public static HowMuchResponse cast(BigDecimal valorFrete){
        return new HowMuchResponse(
                valorFrete
        );
    }

    public static BigDecimal cast(HowMuchResponse response){
        return response.valorFrete();
    }
}
