package pl.edu.pk.ztbd.competitionscheduler.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 * Created with IntelliJ IDEA.
 * User: mhl
 * Date: 13.01.13
 * Time: 14:53
 */
@ManagedBean(name = "navigation")
@SessionScoped
public class NavigationBean {

    private String page = "../competitions";
    private String prevPage = "../competitions";

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        prevPage = this.page;
        this.page = page;
    }

    public void navigateToPrev(ActionEvent event) {
        this.page = this.prevPage;
    }
}
