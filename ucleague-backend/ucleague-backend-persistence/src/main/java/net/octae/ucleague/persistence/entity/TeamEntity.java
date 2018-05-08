package net.octae.ucleague.persistence.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

import org.hibernate.annotations.Formula;

/**
 * The type Team entity.
 */
@Entity(name = "TEAM")
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 24)
    private String name;

    @ManyToOne(optional = false)
    private CountryEntity country;

    @Column
    private Long imageId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RIVAL_ID")
    private TeamEntity rival;

    @OneToMany(mappedBy = "winner", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChampionshipEntity> championships;

    //TO IMPROVE: poor performance
    @Formula("(select count(*) from CHAMPIONSHIP c where c.winner_id = id)")
    private Integer totalChampionships;

    /**
     * Instantiates a new Team entity.
     */
    public TeamEntity() {
    }

    /**
     * Instantiates a new Team entity.
     *
     * @param id the id
     */
    public TeamEntity(Long id) {
        this.id = id;
    }

    /**
     * Instantiates a new Team entity.
     *
     * @param name the name
     */
    public TeamEntity(String name) {
        this.name = name;
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
    public CountryEntity getCountry() {
        return country;
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
     * Gets rival.
     *
     * @return the rival
     */
    public TeamEntity getRival() {
        return rival;
    }

    /**
     * Sets rival.
     *
     * @param rival the rival
     */
    public void setRival(TeamEntity rival) {
        this.rival = rival;
    }

    /**
     * Sets country.
     *
     * @param country the country
     */
    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    /**
     * Gets championships.
     *
     * @return the championships
     */
    public List<ChampionshipEntity> getChampionships() {
        return championships;
    }

    /**
     * Sets championships.
     *
     * @param championships the championships
     */
    public void setChampionships(List<ChampionshipEntity> championships) {
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
