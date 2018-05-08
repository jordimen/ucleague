package net.octae.ucleague.ws.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class TeamInputDTO {

    @NotEmpty
    @Size(min=4, max=24)
    private String name;

    @NotEmpty
    private String countryCode;

    private Long rivalId;

    private Long imageId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Long getRivalId() {
        return rivalId;
    }

    public void setRivalId(Long rivalId) {
        this.rivalId = rivalId;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }
}
