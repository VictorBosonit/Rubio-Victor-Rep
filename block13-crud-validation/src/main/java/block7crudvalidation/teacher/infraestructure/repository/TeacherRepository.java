package block7crudvalidation.teacher.infraestructure.repository;


import block7crudvalidation.teacher.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {


}
