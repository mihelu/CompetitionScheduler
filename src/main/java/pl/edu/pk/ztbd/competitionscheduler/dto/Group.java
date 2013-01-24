package pl.edu.pk.ztbd.competitionscheduler.dto;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mhl
 * Date: 23.01.13
 * Time: 20:00
 */
public class Group {

    private int id;
    private String name;
    private List<Team> teams;
    private List<Match> matches;

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

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}
