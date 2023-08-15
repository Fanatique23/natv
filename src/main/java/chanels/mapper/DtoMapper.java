package chanels.mapper;

import chanels.models.Channel;
import chanels.models.dtos.ChannelDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DtoMapper {
    private final ModelMapper modelMapper;

    public DtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ChannelDto convertToDto(Channel channel) {
        ChannelDto channelDto = modelMapper.map(channel, ChannelDto.class);
        channelDto.setChannel_id(channel.getId());
        channelDto.setChannel_name(channel.getName());
        channelDto.setImg_url(channel.getImageUrl());

        return channelDto;
    }

    public List<ChannelDto> convertToDtoList(List<Channel> channels) {
        return channels.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}


