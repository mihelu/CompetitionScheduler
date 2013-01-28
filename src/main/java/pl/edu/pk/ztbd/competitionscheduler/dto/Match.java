package pl.edu.pk.ztbd.competitionscheduler.dto;

/**
 * Created with IntelliJ IDEA.
 * User: mhl
 * Date: 12.01.13
 * Time: 18:55
 */
public class Match {

    private int id;
    private Team home;
    private Team away;
    private Long homeScore;
    private Long awayScore;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Team getHome() {
        return home;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
    }

    public Long getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(Long homeScore) {
        this.homeScore = homeScore;
    }

    public Long getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(Long awayScore) {
        this.awayScore = awayScore;
    }
}
