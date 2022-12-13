package block7crudvalidation.teacher.domain;

import block7crudvalidation.person.domain.Person;
import block7crudvalidation.student.domain.Student;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @Column(name="id_teacher")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_teacher;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona")
    Person person;

    @Column
    private String comments;

    @Column
    @NotNull
    private String branch;


}