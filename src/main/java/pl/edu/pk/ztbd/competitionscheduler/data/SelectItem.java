package pl.edu.pk.ztbd.competitionscheduler.data;

/**
 * Created with IntelliJ IDEA.
 * User: mhl
 * Date: 23.01.13
 * Time: 22:36
 */
public class SelectItem {

    private String code;
    private String value;

    public SelectItem(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
