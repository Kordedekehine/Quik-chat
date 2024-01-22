package Clique.cliche.consumers;

import Clique.cliche.constants.KafkaConstants;
import Clique.cliche.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageListeners {

    @Autowired
    SimpMessagingTemplate template;

    @KafkaListener(
            topics = KafkaConstants.KAFKA_TOPIC,
            groupId = KafkaConstants.GROUP_ID
    )
    public void listen(ChatMessage chatMessage) {
        System.out.println("sending via kafka listener..");
        template.convertAndSend("/topic/public", chatMessage);
    }
}
