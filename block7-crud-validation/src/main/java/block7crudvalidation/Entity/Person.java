package block7crudvalidation.Entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @Column(name="person_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String users;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String company_email;

    @Column
    private String personal_email;

    @Column
    private String city;

    @Column
    private Boolean active;

    @Column
    private Date created_date;

    @Column
    private String imagen_url;

    @Column
    private Date termination_date;
}