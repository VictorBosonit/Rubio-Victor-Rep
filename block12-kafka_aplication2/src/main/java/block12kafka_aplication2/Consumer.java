package block12kafka_aplication2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @Autowired
    Producer producer;

    @KafkaListener(topics = "test_topic_1", groupId = "group_id")
    public void consumerMessage(String message){

        String messageForConsumer1="Aplication2-->Aplication1-->Mensaje recibido ";

        producer.sendMessage(messageForConsumer1);
        System.out.println();
        System.out.println(message);

    }
}
