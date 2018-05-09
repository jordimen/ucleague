package net.octae.ucleague.business.service.impl;

import net.octae.ucleague.business.service.TeamService;
import net.octae.ucleague.business.service.util.EntityConverter;
import net.octae.ucleague.domain.Championship;
import net.octae.ucleague.domain.Team;
import net.octae.ucleague.domain.TeamInput;
import net.octae.ucleague.persistence.entity.ChampionshipEntity;
import net.octae.ucleague.persistence.entity.CountryEntity;
import net.octae.ucleague.persistence.entity.TeamEntity;
import net.octae.ucleague.persistence.repository.ChampionshipRepository;
import net.octae.ucleague.persistence.repository.TeamRepository;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
        TeamEntity newTeam = new TeamEntity(teamInput.getName());
        newTeam.setCountry(new CountryEntity(teamInput.getCountryCode()));
        newTeam.setRival(teamRepository.findById(teamInput.getRivalId()).get());
        return entityConverter.convert(teamRepository.save(newTeam), Team.class);
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

    @Override
    public void updateChampionships(Long teamId, List<Championship> championships) {

        // Gets the winner for the championships
        TeamEntity winner = teamRepository.findById(teamId).get();

        // New championships
        List<ChampionshipEntity> newChampionships = entityConverter.convert(championships, ChampionshipEntity.class);
        newChampionships.forEach(newChampionship -> {
            newChampionship.setWinner(winner);
        });

        // To delete
        Collection<ChampionshipEntity> toDelete = CollectionUtils.subtract(winner.getChampionships(), newChampionships);
        winner.getChampionships().removeAll(toDelete);

        // To mantain
        Collection<ChampionshipEntity> toMantain = CollectionUtils.intersection(winner.getChampionships(), newChampionships);

        // To add
        Collection<ChampionshipEntity> toAdd = CollectionUtils.subtract(newChampionships, toMantain);
        // Remove older championships
        toAdd.forEach(championshipEntity -> championshipRepository.removeChampionship(championshipEntity.getYear()));
        // Add to the winner
        winner.getChampionships().addAll(toAdd);
    }

}
