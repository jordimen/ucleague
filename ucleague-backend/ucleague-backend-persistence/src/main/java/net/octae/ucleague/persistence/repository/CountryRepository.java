package net.octae.ucleague.persistence.repository;

import net.octae.ucleague.persistence.entity.CountryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The interface Country repository.
 */
public interface CountryRepository extends CrudRepository<CountryEntity, Long> {

    /**
     * Find all by order by name asc list.
     *
     * @return the list
     */
    List<CountryEntity> findAllByOrderByNameAsc();

}
