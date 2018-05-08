package net.octae.ucleague.ws.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * The type Team dto.
 */
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

    private Integer totalChampionships;

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
    public CountryDTO getCountry() {
        return country;
    }

    /**
     * Sets country.
     *
     * @param country the country
     */
    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    /**
     * Gets rival.
     *
     * @return the rival
     */
    public TeamDTO getRival() {
        return rival;
    }

    /**
     * Sets rival.
     *
     * @param rival the rival
     */
    public void setRival(TeamDTO rival) {
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
    public List<ChampionshipDTO> getChampionships() {
        return championships;
    }

    /**
     * Sets championships.
     *
     * @param championships the championships
     */
    public void setChampionships(List<ChampionshipDTO> championships) {
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
