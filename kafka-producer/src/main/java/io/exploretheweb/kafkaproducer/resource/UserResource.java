package io.exploretheweb.kafkaproducer.resource;

import io.exploretheweb.kafkaproducer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/kafka")
public class UserResource {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${kafka.producer.topic.generic}")
    private String genericTopic;
    @Value("${kafka.producer.topic.user}")
    private String userTopic;

    @GetMapping("/publish/{userName}")
    public String publishMessage(@PathVariable final String userName) {
        String stringMessage = "Hi "+userName+", your message has been published successfully.";
        Message<String> message = MessageBuilder.withPayload(stringMessage).setHeader(KafkaHeaders.TOPIC, genericTopic).build();
        kafkaTemplate.send(message);

        System.out.println("Producing some message : "+stringMessage);
        return stringMessage;
    }

    @PostMapping("/publish/user")
    public User publishUserData(@RequestBody User user) {
        // User user = new User(new Random().nextInt(100), "Vipul", new String[] {"India", "IN", "New Delhi"});
        Message<User> message = MessageBuilder.withPayload(user).setHeader(KafkaHeaders.TOPIC, userTopic).build();
        kafkaTemplate.send(message);

        System.out.println("Producing user data : "+user);
        return user;
    }

}
