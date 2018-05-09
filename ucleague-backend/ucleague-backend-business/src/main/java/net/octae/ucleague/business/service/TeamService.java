package net.octae.ucleague.business.service;

import net.octae.ucleague.domain.Championship;
import net.octae.ucleague.domain.Team;
import net.octae.ucleague.domain.TeamInput;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * The interface Team service.
 */
public interface TeamService {

    /**
     * Gets team.
     *
     * @param teamId the team id
     * @return the team
     */
    Team getTeam(Long teamId);

    /**
     * Gets teams.
     *
     * @param name     the name
     * @param pageable the pageable
     * @return the teams
     */
    Page<Team> getTeams(String name, Pageable pageable);

    /**
     * Create or update team.
     *
     * @param teamInput the team input
     * @return the team
     */
    Team createTeam(TeamInput teamInput);

    /**
     * Update a team.
     *
     * @param teamId the team identifier
     * @param teamInput the team data
     * @return
     */
    Team updateTeam(Long teamId, TeamInput teamInput);

    /**
     * Delete team.
     *
     * @param teamId the team id
     */
    void deleteTeam(Long teamId);

    /**
     * Add championship.
     *
     * @param teamId the team id
     * @param year   the year
     */
    void addChampionship(Long teamId, Long year);

    /**
     * Delete championship.
     *
     * @param teamId the team id
     * @param year   the year
     */
    void deleteChampionship(Long teamId, Long year);

    /**
     * Update championships.
     *
     * @param teamId the team id
     * @param championships the championships
     */
    void updateChampionships(Long teamId, List<Championship> championships);

}
