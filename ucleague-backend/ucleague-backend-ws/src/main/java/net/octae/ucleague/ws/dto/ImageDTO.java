package net.octae.ucleague.ws.dto;

/**
 * The type Image dto.
 */
public class ImageDTO {

    private Long id;

    /**
     * Instantiates a new Image dto.
     */
    public ImageDTO() {
    }

    /**
     * Instantiates a new Image dto.
     *
     * @param id the id
     */
    public ImageDTO(Long id) {
        this.id = id;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }
}
