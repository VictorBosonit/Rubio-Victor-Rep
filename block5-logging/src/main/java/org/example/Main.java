package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main  {

    //public static Logger logger = LoggerFactory.getLogger(Main.class);

    @RequestMapping("/")
    public static void main(String[] args) {
                    

        Logger log = LoggerFactory.getLogger(Main.class);

            log.trace("Mensaje a nivel de TRACE");
            log.debug("Mensaje a nivel de DEBUG");
            log.info("Mensaje a nivel de INFO");
            log.warn("Mensaje a nivel de WARNING");
            log.error("Mensaje a nivel de ERROR");

        }
    }


