package br.com.fatec.fretenetapi.messaging.adapter;

import br.com.fatec.fretenetapi.entity.Endereco;
import br.com.fatec.fretenetapi.entity.Estado;
import br.com.fatec.fretenetapi.entity.Frete;
import br.com.fatec.fretenetapi.entity.Status;
import br.com.fatec.fretenetapi.messaging.dto.PedidoFreteAmqp;

import java.math.BigDecimal;
import java.util.UUID;

public class FreteConsumerAdapter {
    private FreteConsumerAdapter(){
    }

    public static Frete cast(PedidoFreteAmqp pedido){
        return new Frete(
                UUID.randomUUID().toString(),
                pedido.idCliente(),
                BigDecimal.ZERO,
                Status.PROCESSANDO,
                new Endereco(
                        pedido.cep(),
                        pedido.logradouro(),
                        pedido.complemento(),
                        pedido.bairro(),
                        pedido.localidade(),
                        Estado.porUf(pedido.uf())
                )
        );
    }
}
