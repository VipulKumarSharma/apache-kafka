package io.exploretheweb.kafkaconsumer.listener;

import io.exploretheweb.kafkaconsumer.respository.UserRepository;
import io.exploretheweb.kafkaproducer.model.User;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumer {

    @Autowired
    private UserRepository userRepository;

    @Getter
    private List<String> messages = new ArrayList<>();

    @KafkaListener(groupId = "Kafka_Group", topics = "Kafka_Topic", containerFactory = "kafkaListenerContainerFactory")
    public void getMessageFromTopic(@Payload String data, @Headers MessageHeaders headers) {
        System.out.println("Received message from producer : "+data);
        messages.add(data);
    }

    @KafkaListener(groupId = "Kafka_User_Group", topics = "User_Topic", containerFactory = "userKafkaListenerContainerFactory")
    public void getUserDataFromTopic(@Payload User data, @Headers MessageHeaders headers) {
        /*headers.keySet().forEach(key -> System.out.println("{"+key+"}: {"+headers.get(key)+"}"));*/

        System.out.println("Received User data from producer : "+data);
        userRepository.save(data);
    }

}
