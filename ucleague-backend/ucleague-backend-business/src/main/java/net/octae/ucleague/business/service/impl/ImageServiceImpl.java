package net.octae.ucleague.business.service.impl;

import net.octae.ucleague.business.service.ImageService;
import net.octae.ucleague.persistence.entity.ImageEntity;
import net.octae.ucleague.persistence.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Image service.
 */
@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Long storeImage(byte[] image) {
        return imageRepository.save(new ImageEntity(image)).getId();
    }

    @Override
    public byte[] loadImage(Long imageId) {
        return imageRepository.findById(imageId).get().getData();
    }
}
