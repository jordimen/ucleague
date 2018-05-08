package net.octae.ucleague.persistence.entity;

import javax.persistence.*;
import java.util.List;

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

    @OneToOne
    private TeamEntity rival;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "winner")
    private List<ChampionshipEntity> championships;

    public TeamEntity() {
    }

    public TeamEntity(Long id) {
        this.id = id;
    }

    public TeamEntity(String name) {
        this.name = name;
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

    public CountryEntity getCountry() {
        return country;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public TeamEntity getRival() {
        return rival;
    }

    public void setRival(TeamEntity rival) {
        this.rival = rival;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    public List<ChampionshipEntity> getChampionships() {
        return championships;
    }

    public void setChampionships(List<ChampionshipEntity> championships) {
        this.championships = championships;
    }
}
