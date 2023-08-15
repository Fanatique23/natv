package chanels.services;

import chanels.mapper.DtoMapper;
import chanels.models.Channel;
import chanels.models.dtos.ChannelDto;
import chanels.repositories.ChannelRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {
    private final ChannelRepository channelRepository;
    private final DtoMapper dtoMapper;

    public ChannelService(ChannelRepository channelRepository, DtoMapper dtoMapper) {
        this.channelRepository = channelRepository;
        this.dtoMapper = dtoMapper;
    }

    public List<ChannelDto> getAllChannelDtos(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Channel> channelPage = channelRepository.findAll(pageable);
        List<Channel> channels = channelPage.getContent();
        return dtoMapper.convertToDtoList(channels);
    }

    public List<ChannelDto> getActiveChannelsWithSortingAndPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<Channel> channels = channelRepository.findActiveChannels(pageable);
        return dtoMapper.convertToDtoList(channels);
    }
}
