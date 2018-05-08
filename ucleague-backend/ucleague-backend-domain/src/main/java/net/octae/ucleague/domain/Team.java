package net.octae.ucleague.domain;

import java.util.List;

/**
 * The type Team.
 */
public class Team {

    private Long id;

    private String name;

    private Country country;

    private Team rival;

    private Long imageId;

    private List<Championship> championships;

    private Integer totalChampionships;

    /**
     * Instantiates a new Team.
     */
    public Team() {
    }

    /**
     * Instantiates a new Team.
     *
     * @param id the id
     */
    public Team(Long id) {
        this.id = id;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets country.
     *
     * @return the country
     */
    public Country getCountry() {
        return country;
    }

    /**
     * Sets country.
     *
     * @param country the country
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     * Gets rival.
     *
     * @return the rival
     */
    public Team getRival() {
        return rival;
    }

    /**
     * Sets rival.
     *
     * @param rival the rival
     */
    public void setRival(Team rival) {
        this.rival = rival;
    }

    /**
     * Gets image id.
     *
     * @return the image id
     */
    public Long getImageId() {
        return imageId;
    }

    /**
     * Sets image id.
     *
     * @param imageId the image id
     */
    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    /**
     * Gets championships.
     *
     * @return the championships
     */
    public List<Championship> getChampionships() {
        return championships;
    }

    /**
     * Sets championships.
     *
     * @param championships the championships
     */
    public void setChampionships(List<Championship> championships) {
        this.championships = championships;
    }

    /**
     * Gets total championships.
     *
     * @return the total championships
     */
    public Integer getTotalChampionships() {
        return totalChampionships;
    }

    /**
     * Sets total championships.
     *
     * @param totalChampionships the total championships
     */
    public void setTotalChampionships(Integer totalChampionships) {
        this.totalChampionships = totalChampionships;
    }
}
