package block7crudvalidation.teacher.infraestructure.controller;

import block7crudvalidation.person.application.ServicePerson;
import block7crudvalidation.person.domain.Person;
import block7crudvalidation.person.infraestructure.controller.dto.input.InputPersonDto;
import block7crudvalidation.teacher.application.ServiceTeacher;
import block7crudvalidation.teacher.domain.Teacher;
import block7crudvalidation.teacher.infraestructure.controller.dto.inputDto.InputTeacherDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
@AllArgsConstructor


public class TeacherController {

    @Autowired
    private  ServiceTeacher serviceTeacher;

    //with @Postmaping we can introduce dates in BB DD
    @PostMapping
    public ResponseEntity addTeacher (@RequestBody InputTeacherDto teacherDto) throws Exception {
        return new ResponseEntity<>(serviceTeacher.addTeacher(teacherDto), HttpStatus.CREATED);
    }


    //with @Getmaping, we can get dates in BB DD in this case we use the "id"
    @GetMapping("/{id}")
    public ResponseEntity getTeacher (@PathVariable("id") Long id, Teacher teacher) throws Exception {
        return new ResponseEntity(serviceTeacher.getTeacher(id), HttpStatus.OK);
    }




    //with @Getmaping, we can get dates in BB DD in this case we use the "users" and we can get all dates from database
    @GetMapping("/teachers")
    public ResponseEntity getAllTeacher() {
        try {
            return new ResponseEntity(serviceTeacher.getAllTeacher(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por faavor vuelva a intentar.\"}");
        }
    }
    // with @Putmaping, we can update dates in BB DD in this case we use the "id"
    @PutMapping("/{id}")
    public ResponseEntity updateTeacher(@PathVariable("id")Long id, @RequestBody InputTeacherDto teacherDto) throws Exception {
        return new ResponseEntity(serviceTeacher.updateTeacher(id,teacherDto), HttpStatus.OK);}

    // with @Deletemaping, we can delete dates in BB DD in this case we use the "id"
    @DeleteMapping ("/{id}")
    public ResponseEntity deleteTeacher(@PathVariable("id")Long id){

        boolean response = serviceTeacher.deleteTeacher(id);

        if(response==true) {return ResponseEntity.status(HttpStatus.OK).body("{\"Borrado\":}");

        } else {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, id no encontrada, por faavor vuelva a intentar.\"}");}
    }
}

