package net.octae.ucleague.ws.controller;

import net.octae.ucleague.business.service.TeamService;
import net.octae.ucleague.business.service.util.EntityConverter;
import net.octae.ucleague.domain.Country;
import net.octae.ucleague.domain.Team;
import net.octae.ucleague.ws.dto.ChampionshipDTO;
import net.octae.ucleague.ws.dto.TeamDTO;
import net.octae.ucleague.ws.dto.TeamInputDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/team")
public class TeamController {

    @Autowired
    private EntityConverter entityConverter;

    @Autowired
    private TeamService teamService;

    @GetMapping
    public Page<TeamDTO> getTeams(@RequestParam(required = false) String name, Pageable pageable) {

        Page<Team> tasks;
        if (StringUtils.isBlank(name)) {
            tasks = teamService.getTeams(pageable);
        } else {
            tasks = teamService.getTeamsByName(name, pageable);
        }

        return entityConverter.convert(tasks, TeamDTO.class);
    }

    @GetMapping(path = "/{teamId}")
    public TeamDTO getTeam(@PathVariable Long teamId) {
        return entityConverter.convert(teamService.getTeam(teamId), TeamDTO.class);
    }

    @PostMapping
    public TeamDTO createTeam(@Valid @RequestBody TeamInputDTO teamInputDTO) {

        Team team = new Team();
        team.setName(teamInputDTO.getName());
        team.setCountry(new Country(teamInputDTO.getCountryCode()));
        team.setImageId(teamInputDTO.getImageId());
        if (teamInputDTO.getRivalId() != null) {
            team.setRival(new Team(teamInputDTO.getRivalId()));
        }

        return entityConverter.convert(teamService.createOrUpdateTeam(team), TeamDTO.class);
    }

    @PutMapping(path = "/{teamId}")
    public void updateTeam(@PathVariable Long teamId, @Valid @RequestBody TeamInputDTO teamInputDTO) {
        Team team = new Team();
        team.setId(teamId);
        team.setName(teamInputDTO.getName());
        team.setCountry(new Country(teamInputDTO.getCountryCode()));
        team.setImageId(teamInputDTO.getImageId());
        if (teamInputDTO.getRivalId() != null) {
            team.setRival(new Team(teamInputDTO.getRivalId()));
        }
        teamService.createOrUpdateTeam(team);
    }

    @GetMapping(path = "/{teamId}/championship")
    public List<ChampionshipDTO> getChampionships(@PathVariable Long teamId) {
        Team team = teamService.getTeam(teamId);
        return entityConverter.convert(team.getChampionships(), ChampionshipDTO.class);
    }

    @PostMapping(path = "/{teamId}/championship/{year}")
    public void addChampionship(@PathVariable Long teamId, @PathVariable Long year) {
        teamService.addChampionship(teamId, year);
    }

    @DeleteMapping(path = "/{teamId}")
    public void deleteTeam(@PathVariable Long teamId) {
        teamService.deleteTeam(teamId);
    }
}
