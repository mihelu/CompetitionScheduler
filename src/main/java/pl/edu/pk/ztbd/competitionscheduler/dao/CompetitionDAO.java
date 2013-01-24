package pl.edu.pk.ztbd.competitionscheduler.dao;

import org.jetbrains.annotations.NotNull;
import pl.edu.pk.ztbd.competitionscheduler.dto.Competition;
import pl.edu.pk.ztbd.competitionscheduler.dto.Match;
import pl.edu.pk.ztbd.competitionscheduler.dto.Team;

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

    void modifyMatchResult(Match match);

    @NotNull
    List<Competition> findAll();

   @NotNull
    List<Team> findAllTeams();
}
