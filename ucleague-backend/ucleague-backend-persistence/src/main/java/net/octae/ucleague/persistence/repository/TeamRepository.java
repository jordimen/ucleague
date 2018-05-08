package net.octae.ucleague.persistence.repository;

import net.octae.ucleague.persistence.entity.TeamEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * The interface Team repository.
 */
public interface TeamRepository extends PagingAndSortingRepository<TeamEntity, Long> {

    /**
     * Find by name ignore case containing page.
     *
     * @param name     the name
     * @param pageable the pageable
     * @return the page
     */
    Page<TeamEntity> findByNameIgnoreCaseContaining(String name, Pageable pageable);

    /**
     * Remove rival.
     *
     * @param teamId the team id
     */
    @Modifying
    @Query("update TEAM team set team.rival = null where team.rival.id = ?1")
    void removeRival(Long teamId);

}
