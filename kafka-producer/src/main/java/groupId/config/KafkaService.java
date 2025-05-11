package groupId.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.network.Send;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, Greetings> kafkaTemplate;

    private String topicName = "baeldung";

    public void sendMessage(String msg) {
        CompletableFuture<SendResult<String,Greetings>> future = kafkaTemplate.send(topicName, new Greetings(msg, "Kafka"));
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Message sent successfully");
            } else {
               log.error("Unable to send message=[" + msg + "] due to : " + ex.getMessage());
            }
        });
    }

    @KafkaListener(topics = "baeldung", groupId = "consumer-group-1")
    public void listenGroupFoo(Greetings message) {
        System.out.println("Received Message in group foo: " + message.toString());
    }

//    @KafkaListener(topics = "baeldung2", groupId = "consumer-group-1")
//    public void listener(String message) {
//        System.out.println("Received Message in group foo: " + message);
//    }
}