package pl.edu.pk.ztbd.competitionscheduler.dto;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mhl
 * Date: 12.01.13
 * Time: 18:24
 */
public class Team {

    private String name;
    private String image;
    private List<Player> players;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
