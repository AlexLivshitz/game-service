package com.poker.gameslist.message.outbound.events;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GameCreatedEvent implements OutBoundEvent {
    private static final String ROUTING_KEY = "game.created";
    private String id;

    @Override
    public String getRoutingKey() {
        return ROUTING_KEY;
    }
}
