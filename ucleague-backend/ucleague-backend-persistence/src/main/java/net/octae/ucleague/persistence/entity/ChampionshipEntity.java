package net.octae.ucleague.persistence.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * The type Championship entity.
 */
@Entity(name = "CHAMPIONSHIP")
public class ChampionshipEntity {

    @Id
    private Long year;

    @ManyToOne
    @JoinColumn(name="WINNER_ID")
    private TeamEntity winner;

    /**
     * Instantiates a new Championship entity.
     */
    public ChampionshipEntity() {
    }

    /**
     * Instantiates a new Championship entity.
     *
     * @param year the year
     */
    public ChampionshipEntity(Long year) {
        this.year = year;
    }

    /**
     * Gets year.
     *
     * @return the year
     */
    public Long getYear() {
        return year;
    }

    /**
     * Sets year.
     *
     * @param year the year
     */
    public void setYear(Long year) {
        this.year = year;
    }

    /**
     * Gets winner.
     *
     * @return the winner
     */
    public TeamEntity getWinner() {
        return winner;
    }

    /**
     * Sets winner.
     *
     * @param winner the winner
     */
    public void setWinner(TeamEntity winner) {
        this.winner = winner;
    }
}
