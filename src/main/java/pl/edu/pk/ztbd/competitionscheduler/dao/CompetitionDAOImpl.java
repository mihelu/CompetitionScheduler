package pl.edu.pk.ztbd.competitionscheduler.dao;

import oracle.jdbc.OracleTypes;
import org.jetbrains.annotations.NotNull;
import pl.edu.pk.ztbd.competitionscheduler.db.ConnectionResolver;
import pl.edu.pk.ztbd.competitionscheduler.dto.Competition;
import pl.edu.pk.ztbd.competitionscheduler.dto.Group;
import pl.edu.pk.ztbd.competitionscheduler.dto.Match;
import pl.edu.pk.ztbd.competitionscheduler.dto.Team;
import pl.edu.pk.ztbd.competitionscheduler.utils.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mhl
 * Date: 20.01.13
 * Time: 12:35
 */
public class CompetitionDAOImpl implements CompetitionDAO {

    private static final String ADD = "{call PKG_COMP.add(?,?,?,?,?,?)}";
    private static final String ADD_GROUP = "{call PKG_COMP.addGroup(?,?,?)}";
    private static final String ADD_GROUP_TEAM = "{call PKG_COMP.addGroupTeam(?,?)}";
    private static final String ADD_MATCH = "{call PKG_COMP.addMatch(?,?,?)}";
    private static final String ADD_GROUP_MATCH = "{call PKG_COMP.addGroupMatch(?,?)}";
    private static final String REMOVE = "{call PKG_COMP.remove(?)}";
    private static final String MODIFY = "{call PKG_COMP.modify()}";
    private static final String GET = "{call PKG_COMP.get(?,?,?)}";
    private static final String FIND_ALL = "{call PKG_COMP.findAll(?)}";
    private static final String SET_MATCH = "{call PKG_COMP.modifyMatch(?,?,?)";
    private static final String FIND_ALL_TEAMS = "{call PKG_COMP.findAllTeams(?)}";

    @Override
    public void add(@NotNull Competition competition) {
        int compId = addCompetition(competition);
        for (Group group : competition.getGroups()) {
            int groupId = addGroup(group, compId);
            for(Match match : group.getMatches()) {
                int matchId = addMatch(match);
                addGroupMatch(groupId,matchId);
            }
            for(Team team : group.getTeams()) {
                addGroupTeam(groupId,team.getId());
            }
        }
    }

    private Integer addCompetition(Competition competition) {
        Connection connection = ConnectionResolver.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(ADD);
            callableStatement.setString(1, competition.getName());
            callableStatement.setString(2, competition.getDescription());
            callableStatement.setTimestamp(3, new Timestamp(competition.getDateFrom().getTime()));
            callableStatement.setTimestamp(4, new Timestamp(competition.getDateTo().getTime()));
            callableStatement.setString(5, competition.getImage());
            callableStatement.registerOutParameter(6, OracleTypes.INTEGER);
            callableStatement.execute();
            return callableStatement.getInt(6);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private Integer addGroup(Group group, int compId) {
        Connection connection = ConnectionResolver.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(ADD_GROUP);
            callableStatement.setString(1, group.getName());
            callableStatement.setInt(2, compId);
            callableStatement.registerOutParameter(3, OracleTypes.INTEGER);
            callableStatement.execute();
            return callableStatement.getInt(3);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void addGroupTeam(int groupId, int teamId) {
        Connection connection = ConnectionResolver.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(ADD_GROUP_TEAM);
            callableStatement.setInt(1, groupId);
            callableStatement.setInt(2, teamId);
            callableStatement.execute();
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

    private Integer addMatch(Match match) {
        Connection connection = ConnectionResolver.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(ADD_MATCH);
            callableStatement.setInt(1, match.getHome().getId());
            callableStatement.setInt(2, match.getAway().getId());
            callableStatement.registerOutParameter(3, OracleTypes.INTEGER);
            callableStatement.execute();
            return callableStatement.getInt(3);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void addGroupMatch(int groupId, int matchId) {
        Connection connection = ConnectionResolver.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(ADD_GROUP_MATCH);
            callableStatement.setInt(1, groupId);
            callableStatement.setInt(2, matchId);
            callableStatement.execute();
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
        Connection connection = ConnectionResolver.getConnection();
        try {
            return get(id, connection);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void modifyMatchResult(Match match) {
        Connection connection = ConnectionResolver.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(SET_MATCH);
            callableStatement.setInt(1, match.getId());
            callableStatement.setLong(2, match.getHomeScore());
            callableStatement.setLong(3, match.getAwayScore());
            callableStatement.execute();
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


    private void remove(int id, Connection connection) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall(REMOVE);
        callableStatement.setInt(1, id);
        callableStatement.execute();
    }

    private Competition get(int id, Connection connection) throws SQLException {
        Competition result = new Competition();
        CallableStatement callableStatement = connection.prepareCall(GET);
        callableStatement.setInt(1, id);
        callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
        callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
        callableStatement.execute();
        ResultSet rs = (ResultSet)callableStatement.getObject(2);
        while (rs.next()) {
            result.setId(id);
            result.setName(rs.getString("NAME"));
            result.setImage(rs.getString("DESCRIPTION"));
            result.setDateFrom(rs.getDate("DATE_FROM"));
            result.setDateTo(rs.getDate("DATE_TO"));
            result.setImage(rs.getString("IMAGE"));
        }

        List<Group> groupList = new ArrayList<Group>();
        ResultSet rsGroups = (ResultSet) callableStatement.getObject(3);
        while(rsGroups.next()) {

            Group group = new Group();
            group.setId(rsGroups.getInt("ID"));
            group.setName(rsGroups.getString("NAME"));
            ResultSet groupTeams = (ResultSet)rsGroups.getObject("TEAMS");
            List<Team> teamList = new ArrayList<Team>();
            while(groupTeams.next()) {
                Team team = new Team();
                team.setId(groupTeams.getInt("ID"));
                team.setName(groupTeams.getString("NAME"));
                team.setImage(groupTeams.getString("IMAGE"));
                team.setPoints(groupTeams.getLong("POINTS"));
                teamList.add(team);
            }
            group.setTeams(teamList);

            ResultSet groupMatches = (ResultSet)rsGroups.getObject("MATCHES");
            List<Match> matchList = new ArrayList<Match>();
            while(groupMatches.next()) {
                Match match = new Match();
                match.setId(groupMatches.getInt("ID"));
                Team team = new Team();
                team.setName(groupMatches.getString("HOME_TEAM"));
                match.setHome(team);
                team = new Team();
                team.setName(groupMatches.getString("AWAY_TEAM"));
                match.setAway(team);
                match.setHomeScore(JDBCUtil.getLong(groupMatches, "HOME_SCORE"));
                match.setAwayScore(JDBCUtil.getLong(groupMatches, "AWAY_SCORE"));
                matchList.add(match);
            }
            group.setMatches(matchList);
            groupList.add(group);
        }

        result.setGroups(groupList);
        return result;
    }

    @NotNull
    @Override
    public List<Competition> findAll() {
        Connection connection = ConnectionResolver.getConnection();
        try {
            return findAll(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @NotNull
    @Override
    public List<Team> findAllTeams() {
        Connection connection = ConnectionResolver.getConnection();
        try {
            return findAllTeams(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private List<Competition> findAll(Connection connection) throws SQLException {
        List<Competition> competitionList = new ArrayList<Competition>();

        CallableStatement callableStatement = connection.prepareCall(FIND_ALL);
        callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
        callableStatement.execute();
        ResultSet rs = ((ResultSet) callableStatement.getObject(1));
        while (rs.next()) {
            Competition competition = new Competition();
            competition.setId(rs.getInt("ID"));
            competition.setName(rs.getString("NAME"));
            competition.setImage(rs.getString("IMAGE"));
            competition.setDateFrom(rs.getDate("DATE_FROM"));
            competition.setDateTo(rs.getDate("DATE_TO"));
            competitionList.add(competition);
        }
        rs.close();
        callableStatement.close();
        return competitionList;
    }

    private List<Team> findAllTeams(Connection connection) throws SQLException {
        List<Team> teamList = new ArrayList<Team>();

        CallableStatement callableStatement = connection.prepareCall(FIND_ALL_TEAMS);
        callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
        callableStatement.execute();
        ResultSet rs = ((ResultSet) callableStatement.getObject(1));
        while (rs.next()) {
            Team team = new Team();
            team.setId(rs.getInt("ID"));
            team.setName(rs.getString("NAME"));
            team.setImage(rs.getString("IMAGE"));
            teamList.add(team);
        }
        rs.close();
        callableStatement.close();
        return teamList;
    }
}
