package pl.edu.pk.ztbd.competitionscheduler.dto;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mhl
 * Date: 23.01.13
 * Time: 20:00
 */
public class Group {

    private String name;
    private List<Team> teams;

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
}
