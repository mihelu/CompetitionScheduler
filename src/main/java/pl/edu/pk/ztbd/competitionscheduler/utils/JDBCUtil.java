package pl.edu.pk.ztbd.competitionscheduler.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: mhl
 * Date: 28.01.13
 * Time: 15:21
 */
public class JDBCUtil {

    static public Long getLong(ResultSet rs, String strColName) throws SQLException {
        long nValue = rs.getLong(strColName);
        if (rs.wasNull()) return null;
        return new Long(nValue);
    }
}
