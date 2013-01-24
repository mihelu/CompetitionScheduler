package pl.edu.pk.ztbd.competitionscheduler.cache;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import pl.edu.pk.ztbd.competitionscheduler.data.SelectItem;
import pl.edu.pk.ztbd.competitionscheduler.db.ConnectionResolver;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mhl
 * Date: 23.01.13
 * Time: 22:34
 */
@ManagedBean(eager = true,name = "countriesCache")
@ApplicationScoped
public class CountriesCache {

    private static final String COUNTRIES = "{call PKG_DICT.getCountries(?)}";
    private static List<SelectItem> countriesList;

    public CountriesCache() {
        countriesList = new ArrayList<SelectItem>();
        countriesList.add(new SelectItem("", ""));
        Connection connection = ConnectionResolver.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(COUNTRIES);
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.execute();
            ResultSet rs = ((ResultSet) callableStatement.getObject(1));
            while (rs.next()) {
                countriesList.add(new SelectItem(rs.getString("CODE"), rs.getString("NAME")));
            }
            rs.close();
            callableStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<SelectItem> getCounties() {
        return countriesList;
    }
}
