package pl.edu.pk.ztbd.competitionscheduler.bean;

import org.primefaces.context.RequestContext;
import pl.edu.pk.ztbd.competitionscheduler.dto.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: mhl
 * Date: 12.01.13
 * Time: 17:59
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name = "authorization")
@SessionScoped
public class AuthorizationBean implements Serializable {

    private User user;
    private String email;
    private String password;

    public void login(ActionEvent event) {
        user = new User();
        user.setEmail(email);
        user.setPassword(password);
        RequestContext context = RequestContext.getCurrentInstance();
        context.addCallbackParam("success", authorized());
    }

    public void logout(ActionEvent event) {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    public boolean authorized() {
        return user != null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
