package net.octae.ucleague.persistence.repository;

import net.octae.ucleague.persistence.entity.TeamEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TeamRepository extends PagingAndSortingRepository<TeamEntity, Long> {

    Page<TeamEntity> findByNameIgnoreCaseContaining(String name, Pageable pageable);

}
