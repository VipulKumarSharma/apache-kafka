package io.exploretheweb.kafkaconsumer.resource;

import io.exploretheweb.kafkaconsumer.listener.KafkaConsumer;
import io.exploretheweb.kafkaconsumer.respository.UserRepository;
import io.exploretheweb.kafkaproducer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kafka")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    KafkaConsumer kafkaConsumer;

    @GetMapping("/consume/string")
    public List<String> getStringMessage() {
        return kafkaConsumer.getMessages();
    }

    @GetMapping("/consume/user")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

}
