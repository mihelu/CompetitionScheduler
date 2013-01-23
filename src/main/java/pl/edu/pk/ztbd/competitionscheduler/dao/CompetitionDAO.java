package pl.edu.pk.ztbd.competitionscheduler.dao;

import org.jetbrains.annotations.NotNull;
import pl.edu.pk.ztbd.competitionscheduler.dto.Competition;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mhl
 * Date: 20.01.13
 * Time: 12:31
 */
public interface CompetitionDAO {

    void add(@NotNull Competition competition);

    void remove(int id);

    void modify(@NotNull Competition competition);

    Competition get(int id);

    @NotNull
    List<Competition> findAll();
}
