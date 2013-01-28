package pl.edu.pk.ztbd.competitionscheduler.dto;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mhl
 * Date: 12.01.13
 * Time: 18:24
 */
public class Team {

    private int id;
    private String name;
    private String image;
    private Long points;
    private List<Player> players;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (id != team.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
