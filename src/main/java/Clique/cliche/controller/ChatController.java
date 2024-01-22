package Clique.cliche.controller;

import Clique.cliche.constants.KafkaConstants;
import Clique.cliche.model.ChatMessage;
import org.apache.kafka.common.protocol.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;

@Controller
public class ChatController {

    @Autowired
    private KafkaTemplate<String, ChatMessage> kafkaTemplate;


    @PostMapping(value = "/api/send", consumes = "application/json", produces = "application/json")
    public void sendKafkaMessage(@RequestBody ChatMessage chatMessage) {
        chatMessage.setTimeStamp(LocalDateTime.now().toString());
        try {

            kafkaTemplate.send(KafkaConstants.KAFKA_TOPIC, chatMessage).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }


    @MessageMapping("/chat.register") //direction
    @SendTo("/topic/public")
    public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {

        return chatMessage;
    }

}