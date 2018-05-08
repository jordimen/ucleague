package net.octae.ucleague.persistence.entity;

import javax.persistence.*;

/**
 * The type Country entity.
 */
@Entity(name = "COUNTRY")
public class CountryEntity {

    @Id
    private String code;

    @Column(nullable = false)
    private String name;

    /**
     * Instantiates a new Country entity.
     */
    public CountryEntity() {
    }

    /**
     * Instantiates a new Country entity.
     *
     * @param code the code
     */
    public CountryEntity(String code) {
        this.code = code;
    }

    /**
     * Instantiates a new Country entity.
     *
     * @param code the code
     * @param name the name
     */
    public CountryEntity(String code, String name) {
        this.code = code;
        this.name = name;
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
