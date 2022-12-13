package block12kafka_aplication1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class Controller {

    @Autowired
    private Producer  producer;

    @PostMapping
    public void messagetoTopic (@RequestParam("message")  String message){

        producer.sendMessage(message);
    }

}
