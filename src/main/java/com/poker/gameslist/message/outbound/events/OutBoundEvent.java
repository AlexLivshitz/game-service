package com.poker.gameslist.message.outbound.events;

import java.io.Serializable;

/**
 * Created by Alex on 1/7/18.
 */
public interface OutBoundEvent extends Serializable {
    String getId();
    String getRoutingKey();
}
 