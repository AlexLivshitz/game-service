#!/usr/bin/env bash
# single run
# docker run -p 8085:8085 --rm --link poker_mysql:localhost games-list:latest

#linked run
docker run -p 8085:8085 --name games-list --link gameslist_db_1:mysql -d games-list