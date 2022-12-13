package block12kafka_aplication1;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener (topics = "test_topic_2", groupId = "group_id")
    public void consumerMessage(String message){
        System.out.println();
        System.out.println(message);
    }

}
