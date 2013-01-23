package pl.edu.pk.ztbd.competitionscheduler.dao;

import org.jetbrains.annotations.NotNull;
import pl.edu.pk.ztbd.competitionscheduler.dto.User;
import pl.edu.pk.ztbd.competitionscheduler.exceptions.AuthenticationException;
import pl.edu.pk.ztbd.competitionscheduler.exceptions.RegistrationException;
import pl.edu.pk.ztbd.competitionscheduler.exceptions.UserExistException;

/**
 * Created with IntelliJ IDEA.
 * User: mhl
 * Date: 20.01.13
 * Time: 13:26
 */
public interface AuthenticationDAO {

    User login(String email, String password) throws AuthenticationException;

    void register(@NotNull User user) throws RegistrationException, UserExistException;

}
