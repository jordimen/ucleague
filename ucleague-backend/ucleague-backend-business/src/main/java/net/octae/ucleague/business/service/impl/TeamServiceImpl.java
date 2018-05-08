package net.octae.ucleague.business.service.impl;

import javax.transaction.Transactional;

import net.octae.ucleague.business.service.TeamService;
import net.octae.ucleague.business.service.util.EntityConverter;
import net.octae.ucleague.domain.Team;
import net.octae.ucleague.domain.TeamInput;
import net.octae.ucleague.persistence.entity.ChampionshipEntity;
import net.octae.ucleague.persistence.entity.CountryEntity;
import net.octae.ucleague.persistence.entity.TeamEntity;
import net.octae.ucleague.persistence.repository.ChampionshipRepository;
import net.octae.ucleague.persistence.repository.TeamRepository;
import org.apache.commons.lang3.StringUtils;
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
    public Page<Team> getTeams(String name, Pageable pageable) {

        Page<TeamEntity> teams;
        if (StringUtils.isBlank(name)) {
            teams = teamRepository.findAll(pageable);
        } else {
            teams = teamRepository.findByNameIgnoreCaseContaining(name, pageable);
        }
        return entityConverter.convert(teams, Team.class);
    }

    @Override
    public Team createTeam(TeamInput teamInput) {
        TeamEntity teamCreated = teamRepository.save(entityConverter.convert(teamInput, TeamEntity.class));
        return entityConverter.convert(teamCreated, Team.class);
    }

    @Override
    public Team updateTeam(Long teamId, TeamInput teamInput) {
        TeamEntity teamEntity = teamRepository.findById(teamId).get();
        teamEntity.setName(teamInput.getName());
        teamEntity.setCountry(teamInput.getCountryCode() != null ? new CountryEntity(teamInput.getCountryCode()) : null);
        teamEntity.setRival(teamInput.getRivalId() != null ? new TeamEntity(teamInput.getRivalId()) : null);
        TeamEntity teamUpdated = teamRepository.save(teamEntity);
        return entityConverter.convert(teamUpdated, Team.class);
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
