package net.octae.ucleague.persistence.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

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
     * Instantiates a new Championship entity.
     *
     * @param winner
     * @param year
     */
    public ChampionshipEntity(TeamEntity winner, Long year) {
        this.winner = winner;
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

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof ChampionshipEntity)) return false;
        ChampionshipEntity that = (ChampionshipEntity) o;
        return Objects.equals(year, that.year) &&
                Objects.equals(winner, that.winner);
    }

    @Override
    public int hashCode() {

        return Objects.hash(year, winner);
    }
}
