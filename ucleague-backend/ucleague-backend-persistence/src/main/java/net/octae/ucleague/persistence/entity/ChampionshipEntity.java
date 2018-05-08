package net.octae.ucleague.persistence.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "CHAMPIONSHIP")
public class ChampionshipEntity {

    @Id
    private Long year;

    @ManyToOne
    private TeamEntity winner;

    public ChampionshipEntity() {
    }

    public ChampionshipEntity(Long year) {
        this.year = year;
    }


    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public TeamEntity getWinner() {
        return winner;
    }

    public void setWinner(TeamEntity winner) {
        this.winner = winner;
    }
}
