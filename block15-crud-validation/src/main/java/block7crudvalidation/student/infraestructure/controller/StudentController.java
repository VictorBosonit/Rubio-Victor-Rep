package block7crudvalidation.student.infraestructure.controller;

import block7crudvalidation.person.application.ServicePerson;
import block7crudvalidation.person.domain.Person;
import block7crudvalidation.person.infraestructure.controller.dto.input.InputPersonDto;
import block7crudvalidation.student.application.ServiceStudent;
import block7crudvalidation.student.domain.Student;
import block7crudvalidation.student.infraestructure.controller.dto.input.InputStudentDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    @Autowired
    private final ServiceStudent serviceStudent;

    //with @Postmaping we can introduce dates in BB DD
    @PostMapping
    public ResponseEntity addPerson (@RequestBody InputStudentDto studentDto) throws Exception {

        return new ResponseEntity<>(serviceStudent.addStudent(studentDto), HttpStatus.CREATED);
    }


    //with @Getmaping, we can get dates in BB DD in this case we use the "id"
    @GetMapping("/{id}")

    public ResponseEntity getStudent (@PathVariable("id") Long id, @RequestParam(defaultValue ="simple") Optional<String> outputType) throws Exception {

        try {
            if (outputType.equals("simple") ) {

                return new ResponseEntity(serviceStudent.getStudent(id), HttpStatus.OK);

            }else {return new ResponseEntity(serviceStudent.getStudentFull(id), HttpStatus.OK);}

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por faavor vuelva a intentar.\"}");
        }
    }


    //with @Getmaping, we can get dates in BB DD in this case we use the "users" and we can get all dates from database
    @GetMapping("/students")
    public ResponseEntity getAllStudent() {
        try {
            return new ResponseEntity(serviceStudent.getAllStudents(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por faavor vuelva a intentar.\"}");
        }
    }
    // with @Putmaping, we can update dates in BB DD in this case we use the "id"
    @PutMapping ("/{id}")
    public ResponseEntity updateStudent(@PathVariable("id")Long id, @RequestBody InputStudentDto studentDto) throws Exception {
        return new ResponseEntity(serviceStudent.updateStudent(id,studentDto), HttpStatus.OK);}

    // with @Deletemaping, we can delete dates in BB DD in this case we use the "id"
    @DeleteMapping ("/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id")Long id){

        boolean response = serviceStudent.deleteStudent(id);

        if(response==true) {return ResponseEntity.status(HttpStatus.OK).body("{\"Borrado\":}");

        } else {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, id no encontrada, por faavor vuelva a intentar.\"}");}
    }
// witch method I can update the courses of a student
    @PutMapping ("/course/{id}")
    public ResponseEntity updateCourses(@PathVariable("id")Long id, @RequestBody InputStudentDto studentDto) throws Exception {
        return new ResponseEntity(serviceStudent.updateStudent(id,studentDto), HttpStatus.OK);}
}






