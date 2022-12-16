package block13mongodb.person.infraestructure.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // the @Configuration is for declare been that I can use from outside to this class
public class Mapper {

        //it`s not necessary instance more times

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    // This is a singleton and I can use while the application is running
}
