package block7crudvalidation.student.domain;

import block7crudvalidation.person.domain.Person;
import block7crudvalidation.course.domain.Course;
import block7crudvalidation.teacher.domain.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @Column(name="id_student")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="sequenciaDePrueba",sequenceName="DB_SEQUENCIA", allocationSize=1)
    private Long id_student;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_person")
    private Person person;

    @Column
    private int num_hours_week;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;

    @Column
    private String comments;


    @Column
    private String branch;

    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinTable(
            name= "Student_Course",
            joinColumns=@JoinColumn(name = "id_student", referencedColumnName = "id_student"),
            inverseJoinColumns = @JoinColumn(name = "id_course", referencedColumnName = "id_course")
    )
        List<Course> courses ;

}