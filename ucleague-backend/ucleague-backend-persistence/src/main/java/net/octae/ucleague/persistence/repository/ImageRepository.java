package net.octae.ucleague.persistence.repository;

import net.octae.ucleague.persistence.entity.ImageEntity;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<ImageEntity, Long> {
}
