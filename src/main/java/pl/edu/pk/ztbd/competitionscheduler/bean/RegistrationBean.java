package pl.edu.pk.ztbd.competitionscheduler.bean;

import org.primefaces.context.RequestContext;
import pl.edu.pk.ztbd.competitionscheduler.JSFUtil;
import pl.edu.pk.ztbd.competitionscheduler.dao.AuthenticationDAO;
import pl.edu.pk.ztbd.competitionscheduler.dao.AuthenticationDAOImpl;
import pl.edu.pk.ztbd.competitionscheduler.dto.User;
import pl.edu.pk.ztbd.competitionscheduler.exceptions.RegistrationException;
import pl.edu.pk.ztbd.competitionscheduler.exceptions.UserExistException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

/**
 * Created with IntelliJ IDEA.
 * User: mhl
 * Date: 20.01.13
 * Time: 14:09
 */
@ManagedBean(name = "registration")
@ViewScoped
public class RegistrationBean {

    private static final String REGISTER_MESSAGES = "registerMessages";
    private User user = new User();

    public void register(ActionEvent event) {
        AuthenticationDAO dao = new AuthenticationDAOImpl();
        boolean success = true;
        try {
            dao.register(user);
        } catch (UserExistException uee) {
            JSFUtil.addMessageError("Email zajęty", REGISTER_MESSAGES);
            success = false;
        } catch (RegistrationException e) {
            JSFUtil.addMessageError("Błąd rejestracji", REGISTER_MESSAGES);
            success = false;
        } finally {
            if(success) {
                user = new User();
            }
            RequestContext context = RequestContext.getCurrentInstance();
            context.addCallbackParam("success", success);
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
