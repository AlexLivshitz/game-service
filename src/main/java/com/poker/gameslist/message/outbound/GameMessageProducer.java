package com.poker.gameslist.message.outbound;

import com.poker.gameslist.message.outbound.events.OutBoundEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class GameMessageProducer {
    private final RabbitTemplate rabbitTemplate;
    private final TopicExchange topicExchange;

    public void sendMessage(OutBoundEvent event) {
        log.info("Sent event - {}, payload - id:{}", event.getClass().getSimpleName(), event.getId());
        rabbitTemplate.convertAndSend(topicExchange.getName(), event.getRoutingKey(), event.getId());
    }
}
