package com.poker.gameslist.repository;

import com.poker.gameslist.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, String> {
}
