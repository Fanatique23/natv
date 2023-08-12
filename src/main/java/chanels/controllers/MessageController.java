package chanels.controllers;


import chanels.services.ChannelService;
import chanels.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private ChannelService chanelService;

//    @GetMapping("/")
//    public String showIndex(Model model) {
//        model.addAttribute("message", new MessageEntity());
//        model.addAttribute("calculated", false);
//        List<Channel> channels = chanelService.getAllChannels();
//        model.addAttribute("channels", channels);
//        return "index";
//    }
//
//    @PostMapping("/calculate")
//    public String calculateCharacters(@ModelAttribute MessageEntity message, Model model) {
//        int characterCount = message.getContent().length();
//        model.addAttribute("message", message);
//        model.addAttribute("characterCount", characterCount);
//        List<Channel> channels = chanelService.getAllChannels();
//        model.addAttribute("channels", channels);
//        model.addAttribute("calculated", true);
//        return "index";
//    }


}

