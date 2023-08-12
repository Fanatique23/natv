package chanels.services;

import chanels.entities.Channel;
import chanels.repositories.ChannelRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {
    private final ChannelRepository channelRepository;

    public ChannelService(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    //    public List<Channel> getAllChannels() {
//        return channelRepository.findAll();
//    }
    public List<Channel> getAllChannels(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return channelRepository.findAll(pageable).getContent();
    }

}
