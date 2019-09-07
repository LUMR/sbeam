package com.lumr.sbeam.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lumr on 2017/5/11.
 */
public class BuyCar {
    private UserVO user;
    private double total;
    private List<Game> games;

    public BuyCar(UserVO user) {
        this.user = user;
        this.games = new ArrayList<>();
    }

    private void sum() {
        total = 0;
        for (Game game : games) {
            total += game.getPrice();
        }
    }

    private boolean checkGame(Game game) {
        for (Game game1 : games) {
            if (game1.getId().equals(game.getId()))
                return true;
        }
        return false;
    }

    public int addGame(Game game) {
        if (!checkGame(game)) {
            games.add(game);
            sum();
            return games.size();
        }
        return 0;
    }

    public int deleteGame(int id) {
        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).getId() == id) {
                games.remove(i);
                sum();
                return 1;
            }
        }
        return 0;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
