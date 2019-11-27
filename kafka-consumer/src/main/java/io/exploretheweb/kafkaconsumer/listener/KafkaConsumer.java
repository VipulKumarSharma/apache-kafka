package io.exploretheweb.kafkaconsumer.listener;

import io.exploretheweb.kafkaproducer.model.User;
import lombok.Getter;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumer {

    @Getter
    private List<String> messages = new ArrayList<>();

    @Getter
    private List<User> users = new ArrayList<>();

    @KafkaListener(groupId = "Kafka_Group", topics = "Kafka_Topic", containerFactory = "kafkaListenerContainerFactory")
    public void getMessageFromTopic(@Payload String data, @Headers MessageHeaders headers) {
        System.out.println("Received message from producer : "+data);
        messages.add(data);
    }

    @KafkaListener(groupId = "Kafka_User_Group", topics = "User_Topic", containerFactory = "userKafkaListenerContainerFactory")
    public void getUserDataFromTopic(@Payload User data, @Headers MessageHeaders headers) {
        System.out.println("Received User data from producer : "+data);
        users.add(data);
        // headers.keySet().forEach(key -> System.out.println("{"+key+"}: {"+headers.get(key)+"}"));
    }

}
