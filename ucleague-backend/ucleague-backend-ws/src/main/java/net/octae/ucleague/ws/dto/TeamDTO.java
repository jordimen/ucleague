package net.octae.ucleague.ws.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class TeamDTO {

    private Long id;

    private String name;

    private CountryDTO country;

    private TeamDTO rival;

    private Long imageId;

    private List<ChampionshipDTO> championships;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    public TeamDTO getRival() {
        return rival;
    }

    public void setRival(TeamDTO rival) {
        this.rival = rival;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public List<ChampionshipDTO> getChampionships() {
        return championships;
    }

    public void setChampionships(List<ChampionshipDTO> championships) {
        this.championships = championships;
    }
}
