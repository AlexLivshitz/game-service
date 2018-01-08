package com.poker.gameslist.service;

import com.poker.gameslist.message.outbound.GameMessageProducer;
import com.poker.gameslist.message.outbound.events.GameCreatedEvent;
import com.poker.gameslist.repository.GameRepository;
import com.poker.gameslist.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepo;

    @Autowired
    private GameMessageProducer gameMessageProducer;

    public List<Game> getAllGames() {
      return gameRepo.findAll();
    }

    public Game getGame(String id) {
        return gameRepo.findOne(id);
    }

    public Game addGame(Game game) {
        gameRepo.save(game);
        GameCreatedEvent gameCreatedEvent = new GameCreatedEvent(game.getId().toString());
        gameMessageProducer.sendMessage(gameCreatedEvent);
        return game;
    }

    public Game updateGame(Game game) {
        return gameRepo.save(game);
    }

    public void deleteCame(String id) {
        gameRepo.delete(id);
    }
}
