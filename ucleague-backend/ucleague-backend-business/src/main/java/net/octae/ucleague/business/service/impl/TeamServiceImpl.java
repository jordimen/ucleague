package net.octae.ucleague.business.service.impl;

import javax.transaction.Transactional;

import net.octae.ucleague.business.service.TeamService;
import net.octae.ucleague.business.service.util.EntityConverter;
import net.octae.ucleague.domain.Team;
import net.octae.ucleague.persistence.entity.ChampionshipEntity;
import net.octae.ucleague.persistence.entity.TeamEntity;
import net.octae.ucleague.persistence.repository.ChampionshipRepository;
import net.octae.ucleague.persistence.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * The type Team service.
 */
@Service
@Transactional
public class TeamServiceImpl implements TeamService {

    @Autowired
    private EntityConverter entityConverter;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private ChampionshipRepository championshipRepository;

    @Override
    public Team getTeam(Long teamId) {
        return entityConverter.convert(teamRepository.findById(teamId).get(), Team.class);
    }

    @Override
    public Page<Team> getTeams(Pageable pageable) {
        return entityConverter.convert(teamRepository.findAll(pageable), Team.class);
    }

    @Override
    public Page<Team> getTeamsByName(String name, Pageable pageable) {
        return entityConverter.convert(teamRepository.findByNameIgnoreCaseContaining(name, pageable), Team.class);
    }

    @Override
    public Team createOrUpdateTeam(Team team) {
        TeamEntity teamCreated = teamRepository.save(entityConverter.convert(team, TeamEntity.class));
        return entityConverter.convert(teamCreated, Team.class);
    }

    @Override
    public void deleteTeam(Long teamId) {
        teamRepository.removeRival(teamId);
        teamRepository.deleteById(teamId);
    }

    @Override
    public void addChampionship(Long teamId, Long year) {
        // remove previos winner if exists
        championshipRepository.removeChampionship(year);
        // create the new championship for the given year
        ChampionshipEntity championshipEntity = new ChampionshipEntity(year);
        championshipEntity.setWinner(new TeamEntity(teamId));
        championshipRepository.save(championshipEntity);
    }

    @Override
    public void deleteChampionship(Long teamId, Long year) {
        // remove championship for a given team
        championshipRepository.removeTeamChampionship(teamId, year);
    }

}
