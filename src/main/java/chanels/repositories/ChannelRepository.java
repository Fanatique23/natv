package chanels.repositories;

import chanels.entities.Channel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {
    @Override
    List<Channel> findAll();

    @Override
    Page<Channel> findAll(Pageable pageable);
}
