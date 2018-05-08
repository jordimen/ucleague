package net.octae.ucleague.ws.controller;

import net.octae.ucleague.business.service.ImageService;
import net.octae.ucleague.ws.dto.ImageDTO;
import net.octae.ucleague.ws.exception.StorageFileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * The type Image controller.
 */
@RestController
@RequestMapping(path = "/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    /**
     * Gets image.
     *
     * @param imageId the image id
     * @return the image
     */
    @GetMapping(path = "/{imageId}", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public Resource getImage(@PathVariable Long imageId) {
        return new ByteArrayResource(imageService.loadImage(imageId));
    }

    /**
     * Upload image image dto.
     *
     * @param file the file
     * @return the image dto
     * @throws IOException the io exception
     */
    @PostMapping
    public ImageDTO uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        Long imageId = imageService.storeImage(file.getBytes());
        return new ImageDTO(imageId);
    }

    /**
     * Handle storage file not found response entity.
     *
     * @param exc the exc
     * @return the response entity
     */
    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
