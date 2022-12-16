package block7crudvalidation.course.domain;

import block7crudvalidation.student.domain.Student;
import block7crudvalidation.teacher.domain.Teacher;
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
public class Course {

    @Id
    @Column(name="id_course")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_course;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;
    @Column
    private String course;
    @Column
    private String comments;
    @Column
    @NotNull
    private Date initial_date;
    @Column
    private Date finish_date;

   @ManyToMany(mappedBy = "courses")
   private List<Student> students;

}