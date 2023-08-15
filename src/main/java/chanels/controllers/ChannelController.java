package chanels.controllers;

import chanels.models.dtos.ChannelDto;
import chanels.services.ChannelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/channel")
public class ChannelController {
    private final ChannelService channelService;

    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

//    @GetMapping("/list")
//    public ResponseEntity<List<ChannelDto>> getChannels(@RequestParam(defaultValue = "1") int pageNo,
//                                                        @RequestParam(defaultValue = "10") int pageSize) {
//        List<ChannelDto> channelDtos = channelService.getActiveChannelsWithSortingAndPagination(pageNo - 1, pageSize);
//        return ResponseEntity.ok(channelDtos);
//    }

    @GetMapping("/list")
    public ResponseEntity<List<ChannelDto>> getChannels(@RequestParam(defaultValue = "1") int pageNo,
                                                        @RequestParam(defaultValue = "10") int pageSize) {
        List<ChannelDto> channelDtos = channelService.getAllChannelDtos(pageNo - 1, pageSize);
        return ResponseEntity.ok(channelDtos);
    }
}


