#!/usr/bin/env bash
docker run --name gameslist_db_1 -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=poker -d mysql