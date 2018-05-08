package net.octae.ucleague.business.service;

import net.octae.ucleague.domain.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
     * @param pageable the pageable
     * @return the teams
     */
    Page<Team> getTeams(Pageable pageable);

    /**
     * Gets teams by name.
     *
     * @param name     the name
     * @param pageable the pageable
     * @return the teams by name
     */
    Page<Team> getTeamsByName(String name, Pageable pageable);

    /**
     * Create or update team team.
     *
     * @param team the team
     * @return the team
     */
    Team createOrUpdateTeam(Team team);

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

}
