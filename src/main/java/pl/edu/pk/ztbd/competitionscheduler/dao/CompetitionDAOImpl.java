package pl.edu.pk.ztbd.competitionscheduler.dao;

import org.jetbrains.annotations.NotNull;
import pl.edu.pk.ztbd.competitionscheduler.db.ConnectionResolver;
import pl.edu.pk.ztbd.competitionscheduler.dto.Competition;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mhl
 * Date: 20.01.13
 * Time: 12:35
 */
public class CompetitionDAOImpl implements CompetitionDAO {

    private static final String ADD = "{call PKG_COMP.add()}";
    private static final String REMOVE = "{call PKG_COMP.remove(?)}";
    private static final String MODIFY = "{call PKG_COMP.modify()}";
    private static final String GET = "{call PKG_COMP.get()}";
    private static final String FIND_ALL = "{call PKG_COMP.findAll()}";

    @Override
    public void add(@NotNull Competition competition) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void remove(int id) {
        Connection connection = ConnectionResolver.getConnection();
        try {
            remove(id, connection);
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

    @Override
    public void modify(@NotNull Competition competition) {
        //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public Competition get(int id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private void remove(int id, Connection connection) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall(REMOVE);
        callableStatement.setInt(1, id);
        callableStatement.execute();
    }



    @NotNull
    @Override
    public List<Competition> findAll() {
        return new ArrayList<Competition>();
    }
}
