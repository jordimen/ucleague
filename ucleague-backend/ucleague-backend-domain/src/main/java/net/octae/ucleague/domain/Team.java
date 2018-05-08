package net.octae.ucleague.domain;

import java.util.List;

public class Team {

    private Long id;

    private String name;

    private Country country;

    private Team rival;

    private Long imageId;

    private List<Championship> championships;

    public Team() {
    }

    public Team(Long id) {
        this.id = id;
    }

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Team getRival() {
        return rival;
    }

    public void setRival(Team rival) {
        this.rival = rival;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public List<Championship> getChampionships() {
        return championships;
    }

    public void setChampionships(List<Championship> championships) {
        this.championships = championships;
    }
}
