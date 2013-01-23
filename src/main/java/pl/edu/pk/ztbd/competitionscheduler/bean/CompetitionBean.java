package pl.edu.pk.ztbd.competitionscheduler.bean;

import pl.edu.pk.ztbd.competitionscheduler.dao.CompetitionDAO;
import pl.edu.pk.ztbd.competitionscheduler.dao.CompetitionDAOImpl;
import pl.edu.pk.ztbd.competitionscheduler.dto.Competition;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
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

    @ManagedProperty(value = "#{navigation}")
    private NavigationBean navigationBean;
    private List<Competition> competitionList;
    private Competition selectedCompetition;

    public CompetitionBean() {
        CompetitionDAO dao = new CompetitionDAOImpl();
        //competitionList = dao.findAll();
        Competition temp = new Competition();
        temp.setId(1);
        temp.setName("test");
        temp.setDescription("TESTTEST");
        Competition temp2 = new Competition();
        temp2.setId(2);
        temp2.setName("test2");
        temp2.setDescription("TESTTEST2");
        competitionList = new ArrayList<Competition>(Arrays.asList(temp,temp2));
    }

    public void navigateToAdd(ActionEvent event) {
        selectedCompetition = new Competition();
        navigationBean.setPage("../competitionCreate");
    }

    public void navigateToModify(ActionEvent event) {
        CompetitionDAO dao = new CompetitionDAOImpl();
        //selectedCompetition = dao.get(selectedCompetition.getId());
        navigationBean.setPage("../competitionModify");
    }

    public void navigateToDetails(ActionEvent event) {
        CompetitionDAO dao = new CompetitionDAOImpl();
        //selectedCompetition = dao.get(selectedCompetition.getId());
        navigationBean.setPage("../competitonDetails");
    }

    public void add(ActionEvent event) {
        CompetitionDAO dao = new CompetitionDAOImpl();
        dao.add(selectedCompetition);
    }

    public void remove(ActionEvent event) {
        CompetitionDAO dao = new CompetitionDAOImpl();
        dao.remove(selectedCompetition.getId());
    }

    public void modify(ActionEvent event) {
        CompetitionDAO dao = new CompetitionDAOImpl();
        dao.modify(selectedCompetition);
    }

    public List<Competition> getCompetitionList() {
        return competitionList;
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
}
