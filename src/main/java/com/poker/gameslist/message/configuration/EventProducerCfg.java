package com.poker.gameslist.message.configuration;


import com.poker.gameslist.message.outbound.GameMessageProducer;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventProducerCfg {
    @Bean
    public TopicExchange producerExchange() {
        return new TopicExchange("eventExchange");
    }

    @Bean
    GameMessageProducer gameMessageProducer(RabbitTemplate rabbitTemplate, TopicExchange producerExchange) {
        return new GameMessageProducer(rabbitTemplate, producerExchange);
    }
}
