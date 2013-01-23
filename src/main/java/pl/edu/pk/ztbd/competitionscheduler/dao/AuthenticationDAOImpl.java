package pl.edu.pk.ztbd.competitionscheduler.dao;

import org.jetbrains.annotations.NotNull;
import pl.edu.pk.ztbd.competitionscheduler.db.ConnectionResolver;
import pl.edu.pk.ztbd.competitionscheduler.dto.User;
import pl.edu.pk.ztbd.competitionscheduler.exceptions.AuthenticationException;
import pl.edu.pk.ztbd.competitionscheduler.exceptions.RegistrationException;
import pl.edu.pk.ztbd.competitionscheduler.exceptions.UserExistException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Created with IntelliJ IDEA.
 * User: mhl
 * Date: 20.01.13
 * Time: 13:32
 */
public class AuthenticationDAOImpl implements AuthenticationDAO {

    private static final String LOGIN = "{call PKG_AUTH.login(?,?,?)}";
    private static final String REGISTER = "{call PKG_AUTH.reg(?,?,?)}";

    @Override
    public User login(String email, String password) throws AuthenticationException {
        Connection connection = ConnectionResolver.getConnection();
        try {
            return login(email, password, connection);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AuthenticationException();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private User login(String email, String password, Connection connection) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall(LOGIN);
        callableStatement.setString(1, email);
        callableStatement.setString(2, password);
        callableStatement.registerOutParameter(3, Types.VARCHAR);
        callableStatement.execute();
        return new User(email, callableStatement.getString(3), password);
    }

    @Override
    public void register(@NotNull User user) throws UserExistException,RegistrationException {
        Connection connection = ConnectionResolver.getConnection();
        try {
            register(user, connection);
        } catch (SQLException e) {
            if(e.getErrorCode() == 20000) {
                throw new UserExistException();
            }
            throw new RegistrationException();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void register(User user, Connection connection) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall(REGISTER);
        callableStatement.setString(1, user.getEmail());
        callableStatement.setString(2, user.getUsername());
        callableStatement.setString(3, user.getPassword());
        callableStatement.execute();
    }
}
