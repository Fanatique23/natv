package chanels.controllers;

import chanels.dtos.ChannelDto;
import chanels.dtos.DiscountDto;
import chanels.entities.Channel;
import chanels.entities.Discount;
import chanels.services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//@Controller
//@RequestMapping("/channel")
//public class ChannelController {
//    private final ChannelService chanelService;
//
//    public ChannelController(ChannelService chanelService) {
//        this.chanelService = chanelService;
//    }
//
//    @GetMapping()
//    public String getAllChannels(Model model) {
//        List<Channel> channels = chanelService.getAllChannels();
//        model.addAttribute("channels", channels);
//        return "index";
//    }
//
//}
//@RestController
//@RequestMapping("/api/v1/channel")
//public class ChannelController {
//    @Autowired
//    private ChannelService channelService;
//
//    @GetMapping("/list")
//    public ResponseEntity<List<Channel>> getChannels(@RequestParam(defaultValue = "1") int pageNo,
//                                                     @RequestParam(defaultValue = "10") int pageSize) {
//        List<Channel> channels = channelService.getAllChannels(pageNo - 1, pageSize);
//        return ResponseEntity.ok(channels);
//    }
//}
@RestController
@RequestMapping("/api/v1/channel")
public class ChannelController {
    @Autowired
    private ChannelService channelService;

    @GetMapping("/list")
    public ResponseEntity<List<ChannelDto>> getChannels(@RequestParam(defaultValue = "1") int pageNo,
                                                        @RequestParam(defaultValue = "10") int pageSize) {
        List<Channel> channels = channelService.getAllChannels(pageNo - 1, pageSize);

        List<ChannelDto> channelDTOs = new ArrayList<>();
        for (Channel channel : channels) {
            ChannelDto channelDTO = new ChannelDto();
            channelDTO.setChannel_id(channel.getId());
            channelDTO.setChannel_name(channel.getName());
            channelDTO.setImg_url(channel.getImageUrl());

            List<DiscountDto> discountDTOs = new ArrayList<>();
            for (Discount discount : channel.getDiscounts()) {
                DiscountDto discountDTO = new DiscountDto();
                discountDTO.setFrom_days_count(discount.getCountDays());
                discountDTO.setDiscount(discount.getDiscount());
                discountDTOs.add(discountDTO);
            }

            channelDTO.setDiscounts(discountDTOs);
            channelDTOs.add(channelDTO);
        }

        return ResponseEntity.ok(channelDTOs);
    }
}

