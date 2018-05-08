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

@RestController
@RequestMapping(path = "/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping(path = "/{imageId}", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public Resource getImage(@PathVariable Long imageId) {
        return new ByteArrayResource(imageService.loadImage(imageId));
    }

    @PostMapping
    public ImageDTO uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        Long imageId = imageService.storeImage(file.getBytes());
        return new ImageDTO(imageId);
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
