package net.octae.ucleague.ws.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * The type Team input dto.
 */
public class TeamInputDTO {

    @NotEmpty
    @Size(min=4, max=24)
    private String name;

    @NotEmpty
    private String countryCode;

    private Long rivalId;

    private Long imageId;

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
     * Gets country code.
     *
     * @return the country code
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets country code.
     *
     * @param countryCode the country code
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Gets rival id.
     *
     * @return the rival id
     */
    public Long getRivalId() {
        return rivalId;
    }

    /**
     * Sets rival id.
     *
     * @param rivalId the rival id
     */
    public void setRivalId(Long rivalId) {
        this.rivalId = rivalId;
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
}
