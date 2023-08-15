package chanels.repositories;

import chanels.models.Channel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {
    @Override
    @EntityGraph(attributePaths = {"discounts", "prices"})
    List<Channel> findAll();

    @Override
    Page<Channel> findAll(Pageable pageable);

    List<Channel> findByCreatedDateBeforeAndEndDateAfter(Date endDate, Date createdDate, Pageable pageable);

    @Query("SELECT c FROM Channel c WHERE c.createdDate < CURRENT_TIMESTAMP")
    List<Channel> findActiveChannels(Pageable pageable);
}
