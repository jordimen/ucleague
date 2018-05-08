package net.octae.ucleague.business.service.impl;

import net.octae.ucleague.business.service.TeamService;
import net.octae.ucleague.business.service.util.EntityConverter;
import net.octae.ucleague.domain.Team;
import net.octae.ucleague.persistence.entity.ChampionshipEntity;
import net.octae.ucleague.persistence.entity.TeamEntity;
import net.octae.ucleague.persistence.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private EntityConverter entityConverter;

    @Autowired
    private TeamRepository teamRepository;

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
        teamRepository.deleteById(teamId);
    }

    @Override
    public void addChampionship(Long teamId, Long year) {
        Optional<TeamEntity> teamEntityOptional = teamRepository.findById(teamId);
        if (teamEntityOptional.isPresent()) {
            TeamEntity teamEntity = teamEntityOptional.get();
            teamEntity.getChampionships().add(new ChampionshipEntity(year));
            teamRepository.save(teamEntity);
        }
    }

}
