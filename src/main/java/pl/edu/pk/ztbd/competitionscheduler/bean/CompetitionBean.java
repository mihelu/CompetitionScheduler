package pl.edu.pk.ztbd.competitionscheduler.bean;

import pl.edu.pk.ztbd.competitionscheduler.utils.JDBCUtil;
import pl.edu.pk.ztbd.competitionscheduler.utils.JSFUtil;
import pl.edu.pk.ztbd.competitionscheduler.dao.CompetitionDAO;
import pl.edu.pk.ztbd.competitionscheduler.dao.CompetitionDAOImpl;
import pl.edu.pk.ztbd.competitionscheduler.dto.Competition;
import pl.edu.pk.ztbd.competitionscheduler.dto.Group;
import pl.edu.pk.ztbd.competitionscheduler.dto.Match;
import pl.edu.pk.ztbd.competitionscheduler.dto.Team;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mhl
 * Date: 19.01.13
 * Time: 21:22
 */
@ManagedBean(name = "competition")
@ViewScoped
public class CompetitionBean {

    public static final String PHOTOS_DIRECTORY = "../webapps/resources/images/";

    @ManagedProperty(value = "#{navigation}")
    private NavigationBean navigationBean;
    private List<Competition> competitionList;
    private Competition selectedCompetition;
    private List<Team> teamList;
    private int numberfGroups;
    private int numberOfTeamsInGroup;
    private int selectedGroupIndex;
    private Match selectedMatch = new Match();

    public CompetitionBean() {

    }

    public void navigateToAdd(ActionEvent event) {
        selectedCompetition = new Competition();
        CompetitionDAO dao = new CompetitionDAOImpl();
        teamList = dao.findAllTeams();
        numberfGroups = 0;
        numberOfTeamsInGroup = 0;
        selectedGroupIndex = 0;
        navigationBean.setPage("../competitionCreate");
    }

    public void navigateToModify(ActionEvent event) {
        CompetitionDAO dao = new CompetitionDAOImpl();
        //selectedCompetition = dao.get(selectedCompetition.getId());
        navigationBean.setPage("../competitionModify");
    }

    public void navigateToDetails(ActionEvent event) {
        CompetitionDAO dao = new CompetitionDAOImpl();
        Integer compId = JSFUtil.<Integer>getAttribute(event,"compId");
        selectedCompetition = dao.get(compId);
        navigationBean.setPage("../competitonDetails");
    }

    public void add(ActionEvent event) {
        CompetitionDAO dao = new CompetitionDAOImpl();
        for (Group group : selectedCompetition.getGroups()) {
            group.setMatches(createMatchesSchedule(group.getTeams()));
        }
        dao.add(selectedCompetition);
        navigationBean.setPage("../competitions");
    }

    public void remove(ActionEvent event) {
        CompetitionDAO dao = new CompetitionDAOImpl();
        dao.remove(selectedCompetition.getId());
    }

    public void modify(ActionEvent event) {
        CompetitionDAO dao = new CompetitionDAOImpl();
        dao.modify(selectedCompetition);
    }

    public void prepareModifyMatchResult(ActionEvent event) {
        selectedMatch = JSFUtil.<Match>getAttribute(event, "selectedMatch");
    }

    public void modifyMatchResult(ActionEvent event) {
        CompetitionDAO dao = new CompetitionDAOImpl();
        dao.modifyMatchResult(selectedMatch);
        selectedCompetition = dao.get(selectedCompetition.getId());
    }

    public void setGroupsList() {
        List<Group> temp = new ArrayList<Group>();
        for (int i = 0; i < numberfGroups; i++) {
            Group group = new Group();
            group.setName("Grupa " + i);
            group.setMatches(new ArrayList<Match>());
            group.setTeams(new ArrayList<Team>());
            temp.add(group);
        }
        selectedCompetition.setGroups(temp);
    }

    public void addTeamToGroup(ActionEvent event) {
        if (selectedCompetition.getGroups().get(selectedGroupIndex).getTeams().size() >= numberOfTeamsInGroup) {
            JSFUtil.addMessageError("Maksymalna ilość drużyn w grupie!", "groupsMessages");
            return;
        }
        Team team = JSFUtil.<Team>getAttribute(event, "team");

        selectedCompetition.getGroups().get(selectedGroupIndex).getTeams().add(team);
        teamList.remove(team);
    }

    public void removeTeamFromGroup(ActionEvent event) {
        Team team = JSFUtil.<Team>getAttribute(event, "teamAttr");

        selectedCompetition.getGroups().get(selectedGroupIndex).getTeams().remove(team);
        teamList.add(team);
    }

    private List<Match> createMatchesSchedule(List<Team> teams) {
        List<Match> result = new ArrayList<Match>();
        for (Team homeTeam : teams) {
            for (Team awayTeam : teams) {
                if (homeTeam.getId() == awayTeam.getId()) {
                    continue;
                }
                Match match = new Match();
                match.setHome(homeTeam);
                match.setAway(awayTeam);
                result.add(match);
            }
        }
        return result;
    }

    public List<Competition> getCompetitionList() {
        CompetitionDAO dao = new CompetitionDAOImpl();
        return dao.findAll();
    }

    public void setCompetitionList(List<Competition> competitionList) {
        this.competitionList = competitionList;
    }

    public Competition getSelectedCompetition() {
        return selectedCompetition;
    }

    public void setSelectedCompetition(Competition selectedCompetition) {
        this.selectedCompetition = selectedCompetition;
    }

    public NavigationBean getNavigationBean() {
        return navigationBean;
    }

    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    public int getNumberfGroups() {
        return numberfGroups;
    }

    public void setNumberfGroups(int numberfGroups) {
        this.numberfGroups = numberfGroups;
    }

    public int getNumberOfTeamsInGroup() {
        return numberOfTeamsInGroup;
    }

    public void setNumberOfTeamsInGroup(int numberOfTeamsInGroup) {
        this.numberOfTeamsInGroup = numberOfTeamsInGroup;
    }

    public int getSelectedGroupIndex() {
        return selectedGroupIndex;
    }

    public void setSelectedGroupIndex(int selectedGroupIndex) {
        this.selectedGroupIndex = selectedGroupIndex;
    }

    public Match getSelectedMatch() {
        return selectedMatch;
    }

    public void setSelectedMatch(Match selectedMatch) {
        this.selectedMatch = selectedMatch;
    }
}
