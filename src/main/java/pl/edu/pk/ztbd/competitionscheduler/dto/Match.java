package pl.edu.pk.ztbd.competitionscheduler.dto;

/**
 * Created with IntelliJ IDEA.
 * User: mhl
 * Date: 12.01.13
 * Time: 18:55
 */
public class Match {

    private Team home;
    private Team away;
    private int homeScore;
    private int awayScore;

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

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }
}
