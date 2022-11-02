package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@SpringBootApplication

public class Block5_Profiles implements CommandLineRunner {


    //you have to introduce de next commands for that the aplication run:
    // - Dspring.profiles.active= local ----> Profile = Local
    // - Dspring.profiles.active= int ----> Profile = INTEGRATION
    // - Dspring.profiles.active= pro ----> Profile = PRODUCTION

    // this comands are in RUN / Edit Configurations


    public static void main(String[] args) {
        new SpringApplicationBuilder(Block5_Profiles.class).run(args);
        //SpringApplication.run(Block5_Profiles.class, args);
    }

    @Autowired
    private Environment environment;

    @Value("${spring.profiles.active}")
    String activeProfile;

    @Value("${bd.url}")
    String url;


    @Override
    public void run(String... args) throws Exception {

        System.out.println(activeProfile);
        System.out.println(url);
        System.out.println(Arrays.toString(environment.getActiveProfiles()));
    }
}