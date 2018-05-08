package net.octae.ucleague.business.service;

import net.octae.ucleague.domain.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeamService {

    Team getTeam(Long teamId);

    Page<Team> getTeams(Pageable pageable);

    Page<Team> getTeamsByName(String name, Pageable pageable);

    Team createOrUpdateTeam(Team team);

    void deleteTeam(Long teamId);

    void addChampionship(Long teamId, Long year);

}
