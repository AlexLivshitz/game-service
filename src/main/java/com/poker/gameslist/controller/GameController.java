package com.poker.gameslist.controller;

import com.poker.gameslist.model.Game;
import com.poker.gameslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("games")
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping("")
    public List<Game> getAllGamesList() {
        return gameService.getAllGames();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Game getGame(@PathVariable String id) {
        return gameService.getGame(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Game addGame(@RequestBody Game game) {
        return gameService.addGame(game);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Game updateGame(@RequestBody Game game) {
        return gameService.updateGame(game);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteGame(@PathVariable String id) {
        gameService.deleteCame(id);
    }
}

