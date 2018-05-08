package net.octae.ucleague.persistence.entity;

import javax.persistence.*;

@Entity(name = "COUNTRY")
public class CountryEntity {

    @Id
    private String code;

    @Column(nullable = false)
    private String name;

    public CountryEntity() {
    }

    public CountryEntity(String code) {
        this.code = code;
    }

    public CountryEntity(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
