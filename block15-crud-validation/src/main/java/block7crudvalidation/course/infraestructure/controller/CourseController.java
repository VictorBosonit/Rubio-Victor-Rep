package block7crudvalidation.course.infraestructure.controller;

import block7crudvalidation.course.application.ServiceCourse;
import block7crudvalidation.course.domain.Course;
import block7crudvalidation.course.infraestructure.controller.dto.inputDto.InputCourseDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/course")
@AllArgsConstructor
public class CourseController {


@Autowired
ServiceCourse servicecourse;
    //with @Postmaping we can introduce dates in BB DD
    @PostMapping
    public ResponseEntity addCourse (@RequestBody InputCourseDto courseDto) throws Exception {
        return new ResponseEntity<>(servicecourse.addCourse(courseDto), HttpStatus.CREATED);
    }
    //with @Getmaping, we can get dates in BB DD in this case we use the "id"
    @GetMapping("/{id}")
    public ResponseEntity getCourse (@PathVariable("id") Long id, Course course) throws Exception {
        return new ResponseEntity(servicecourse.getCourse(id), HttpStatus.OK);
    }

    //with @Getmaping, we can get dates in BB DD in this case we use the "users" and we can get all dates from database
    @GetMapping("/courses")
    public ResponseEntity getAllCourse() {
        try {
            return new ResponseEntity(servicecourse.getAllCourse(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por faavor vuelva a intentar.\"}");
        }
    }
    // with @Putmaping, we can update dates in BB DD in this case we use the "id"
    @PutMapping ("/{id}")
    public ResponseEntity updateCourse(@PathVariable("id")Long id, @RequestBody InputCourseDto courseDto) throws Exception {
        return new ResponseEntity(servicecourse.updateCourse(id,courseDto), HttpStatus.OK);}

    // with @Deletemaping, we can delete dates in BB DD in this case we use the "id"
    @DeleteMapping ("/{id}")
    public ResponseEntity deleteCourse(@PathVariable("id")Long id){

        boolean response = servicecourse.deleteCourse(id);

        if(response==true) {return ResponseEntity.status(HttpStatus.OK).body("{\"Borrado\":}");

        } else {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, id no encontrada, por faavor vuelva a intentar.\"}");}
    }

    @GetMapping("/student/{id}")
    public ResponseEntity getAllCourses (@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity(servicecourse.getAllCourses(id), HttpStatus.OK);
    }


}
