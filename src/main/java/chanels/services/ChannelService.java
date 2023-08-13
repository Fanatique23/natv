package chanels.services;

import chanels.mapper.DtoMapper;
import chanels.models.Channel;
import chanels.models.dtos.ChannelDto;
import chanels.repositories.ChannelRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

//@Service
//public class ChannelService {
//    private final ChannelRepository channelRepository;
//
//    public ChannelService(ChannelRepository channelRepository) {
//        this.channelRepository = channelRepository;
//    }
//
//    //    public List<Channel> getAllChannels() {
////        return channelRepository.findAll();
////    }
//    public List<Channel> getAllChannels(int pageNo, int pageSize) {
//        Pageable pageable = PageRequest.of(pageNo, pageSize);
//        return channelRepository.findAll(pageable).getContent();
//    }
//
//
//
//}
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
        List<Channel> channels = channelRepository.findAll(pageable).getContent();
        return dtoMapper.convertToDtoList(channels);
    }

    public List<ChannelDto> getActiveChannelsWithSortingAndPagination(int pageNo, int pageSize) {
        Date currentDate = new Date();
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<Channel> channels = channelRepository.findActiveChannels(pageable);
        return dtoMapper.convertToDtoList(channels);
    }
}
