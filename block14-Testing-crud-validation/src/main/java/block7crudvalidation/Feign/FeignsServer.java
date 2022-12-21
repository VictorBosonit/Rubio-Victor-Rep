package block7crudvalidation.Feign;
import block7crudvalidation.teacher.domain.Teacher;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(name= "FeignsServer" , url= "http://localhost:8081")
public interface FeignsServer {
    @GetMapping("/teacher/{id}")
     ResponseEntity<Teacher> getTeacherById(@PathVariable("id") Long id) ;

}
