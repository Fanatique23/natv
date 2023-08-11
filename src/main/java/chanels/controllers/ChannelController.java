package chanels.controllers;

import chanels.entities.Channel;
import chanels.services.ChannelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/channel")
public class ChannelController {
    private final ChannelService chanelService;

    public ChannelController(ChannelService chanelService) {
        this.chanelService = chanelService;
    }

    @GetMapping()
    public String getAllChannels(Model model) {
        List<Channel> channels = chanelService.getAllChannels();
        model.addAttribute("channels", channels);
        return "index";
    }

}
