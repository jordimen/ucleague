package net.octae.ucleague.domain;

/**
 * The type Country.
 */
public class Country {

    private String code;

    private String name;

    /**
     * Instantiates a new Country.
     */
    public Country() {
    }

    /**
     * Instantiates a new Country.
     *
     * @param code the code
     */
    public Country(String code) {
        this.code = code;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(String code) {
        this.code = code;
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

}
