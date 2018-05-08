package net.octae.ucleague.business.service;

public interface ImageService {

    Long storeImage(byte[] image);

    byte[] loadImage(Long imageId);

}
