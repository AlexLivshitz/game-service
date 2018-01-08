package com.poker.gameslist.eventConsumer;


import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.joran.spi.ConsoleTarget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;




/**
 * Created by Alex on 1/3/18.
 */
public class EventConsumer {
    private Logger logger = LoggerFactory.getLogger(EventConsumer.class);

    @RabbitListener(queues="userServiceQueue")
    public void receive(String message) {
        logger.info("Received message - {} ", message);
    }
}
