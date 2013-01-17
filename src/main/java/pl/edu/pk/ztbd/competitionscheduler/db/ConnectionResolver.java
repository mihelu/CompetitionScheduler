package pl.edu.pk.ztbd.competitionscheduler.db;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: mhl
 * Date: 12.01.13
 * Time: 17:24
 * To change this template use File | Settings | File Templates.
 */
public class ConnectionResolver {

    private static final String DATASOURCE = "java:comp/env/jdbc/competitionscheduler";

    public static Connection getConnection() {
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup(DATASOURCE);
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        } catch (NamingException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }
}
