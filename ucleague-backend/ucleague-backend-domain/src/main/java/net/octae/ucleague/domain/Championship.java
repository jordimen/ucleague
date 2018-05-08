package net.octae.ucleague.domain;

/**
 * The type Championship.
 */
public class Championship {

    private Long year;

    /**
     * Instantiates a new Championship.
     */
    public Championship() {
    }

    /**
     * Instantiates a new Championship.
     *
     * @param year the year
     */
    public Championship(Long year) {
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
}
