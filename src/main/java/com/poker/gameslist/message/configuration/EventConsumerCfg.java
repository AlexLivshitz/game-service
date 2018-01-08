package com.poker.gameslist.message.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.poker.gameslist.eventConsumer.*;

@Configuration
public class EventConsumerCfg {
    @Bean
    public TopicExchange consumerExchange() {
        return new TopicExchange("eventExchange");
    }

    @Bean
    public Queue queue() {
        return new Queue("userServiceQueue");
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange consumerExchange) {
        return BindingBuilder
                .bind(queue)
                .to(consumerExchange)
                .with("game.*");
    }

    @Bean
    public EventConsumer eventConsumer() {
        return new EventConsumer();
    }
}
