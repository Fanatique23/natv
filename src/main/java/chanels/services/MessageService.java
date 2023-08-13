package chanels.services;

import chanels.models.Channel;
import chanels.models.MessageEntity;
import chanels.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public MessageEntity saveMessage(String content, Channel chan) {
        MessageEntity message = new MessageEntity();
        message.setContent(content);
        return messageRepository.save(message);
    }
}
