package pl.edu.pk.ztbd.competitionscheduler.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created with IntelliJ IDEA.
 * User: mhl
 * Date: 13.01.13
 * Time: 14:53
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name = "navigation")
@SessionScoped
public class NavigationBean {

    private String page = "../empty";

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
