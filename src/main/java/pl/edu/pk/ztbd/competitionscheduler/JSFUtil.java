package pl.edu.pk.ztbd.competitionscheduler;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 * Created with IntelliJ IDEA.
 * User: mhl
 * Date: 20.01.13
 * Time: 14:05
 */
public class JSFUtil {

    public static <T> T getAttribute(ActionEvent event,String attrName) {
        return (T)event.getComponent().getAttributes().get(attrName);
    }

    public static void addMessageError(String message, String clientId) {
        FacesMessage resultMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null);
        FacesContext.getCurrentInstance().addMessage(clientId, resultMessage);
    }

    public static void addMessageWarning(String message, String clientId) {
        FacesMessage resultMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, message, null);
        FacesContext.getCurrentInstance().addMessage(clientId, resultMessage);
    }

    public static void addMessageInfo(String message, String clientId) {
        FacesMessage resultMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, message, null);
        FacesContext.getCurrentInstance().addMessage(clientId, resultMessage);
    }

    public static void addMessageError(String message) {
        addMessageError(message, null);
    }

    public static void addMessageWarning(String message) {
        addMessageWarning(message, null);
    }

    public static void addMessageInfo(String message) {
        addMessageInfo(message, null);
    }
}
