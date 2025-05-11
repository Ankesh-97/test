package groupId;

import groupId.config.KafkaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class Producer {
    public static void main(String[] args) {
        SpringApplication.run(Producer.class, args);
    }
}

@RestController
@RequestMapping(value = "/kafka")
class Controller{
    private final KafkaService kafkaService;

    public Controller(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @GetMapping("/publish/{message}")
    public void sendMessageToKafkaTopic(@PathVariable("message") String message) {
        this.kafkaService.sendMessage(message);
    }
}

