package br.com.fatec.fretenetapi.messaging;

import br.com.fatec.fretenetapi.entity.Frete;
import br.com.fatec.fretenetapi.messaging.adapter.FreteConsumerAdapter;
import br.com.fatec.fretenetapi.messaging.dto.PedidoFreteAmqp;
import br.com.fatec.fretenetapi.service.FreteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class FreteConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(FreteConsumer.class);
    private static final String X_RETRIES_HEADER = "x-death";

    private final String parkingLot;
    private final RabbitTemplate rabbitTemplate;

    private final FreteService service;

    public FreteConsumer(
            RabbitTemplate rabbitTemplate,
            @Value("${spring.rabbitmq.request.parking-lot.producer}") String parkingLot,
            FreteService service
    ) {
        this.parkingLot = parkingLot;
        this.rabbitTemplate = rabbitTemplate;
        this.service = service;
    }

    @RabbitListener(
            queues = "${spring.rabbitmq.request.routing-key.producer}",
            containerFactory = "rabbitFactory")
    public void listener(@Payload PedidoFreteAmqp pedido, Message message, @Headers Map<String, Object> headers) {
        try {
            LOG.info("Pedido de frete: {}", pedido);

            Frete freteCriado = this.service.register(FreteConsumerAdapter.cast(pedido));

            LOG.info("Pedido de frete {} Criado!", freteCriado.id());
        } catch (Exception ex) {
            Long tentativas = getRetryCount(headers);

            LOG.warn("Erro ao criar Pedido de Frete");
            LOG.warn("Tentativas atuais: {}", tentativas);

            if (tentativas > 3) {
                LOG.warn("Enviando para a Fila de Erro...");
                rabbitTemplate.send(parkingLot, message);
                return;
            }

            throw new AmqpRejectAndDontRequeueException(ex);
        }
    }

    private Long getRetryCount(Map<String, Object> headers) {
        if (headers.containsKey(X_RETRIES_HEADER)) {
            List<Map<String, Object>> list = (List<Map<String, Object>>) headers.get(X_RETRIES_HEADER);
            if (!list.isEmpty()) {
                return (Long) list.get(0).get("count");
            }
        }
        return 0L;
    }
}