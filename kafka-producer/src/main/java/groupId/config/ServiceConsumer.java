package groupId.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ServiceConsumer {

//    @KafkaListener(topics = "baeldung", groupId = "consumer-group-1")
//    public void listenGroupFoo(String message) {
//
//        System.out.println("Received Message in group foo: " + message);
//    }
}
