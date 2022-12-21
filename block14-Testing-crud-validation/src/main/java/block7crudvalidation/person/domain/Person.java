package block7crudvalidation.person.domain;

import block7crudvalidation.student.domain.Student;
import block7crudvalidation.teacher.domain.Teacher;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @Column(name="id_person")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_person;

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