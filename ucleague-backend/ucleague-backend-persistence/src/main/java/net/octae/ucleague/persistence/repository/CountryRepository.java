package net.octae.ucleague.persistence.repository;

import net.octae.ucleague.persistence.entity.CountryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<CountryEntity, Long> {

    List<CountryEntity> findAllByOrderByNameAsc();

}
