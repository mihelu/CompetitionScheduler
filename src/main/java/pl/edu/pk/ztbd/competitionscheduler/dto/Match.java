package pl.edu.pk.ztbd.competitionscheduler.dto;

/**
 * Created with IntelliJ IDEA.
 * User: mhl
 * Date: 12.01.13
 * Time: 18:55
 * To change this template use File | Settings | File Templates.
 */
public class Match {

    public Team home;
    public Team away;

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
}
