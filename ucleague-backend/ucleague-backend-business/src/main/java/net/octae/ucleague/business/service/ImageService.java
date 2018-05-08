package net.octae.ucleague.business.service;

/**
 * The interface Image service.
 */
public interface ImageService {

    /**
     * Store image long.
     *
     * @param image the image
     * @return the long
     */
    Long storeImage(byte[] image);

    /**
     * Load image byte [ ].
     *
     * @param imageId the image id
     * @return the byte [ ]
     */
    byte[] loadImage(Long imageId);

}
