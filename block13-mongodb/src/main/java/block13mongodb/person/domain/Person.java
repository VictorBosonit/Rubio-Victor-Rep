package block13mongodb.person.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "person")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {


    private String name;
    private String surname;
    private int age;
    private String city;


}
