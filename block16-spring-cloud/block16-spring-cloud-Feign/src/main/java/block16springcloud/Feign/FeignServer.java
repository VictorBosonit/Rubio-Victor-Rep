package block16springcloud.Feign;


import block16springcloud.customer.domain.Customer;
import block16springcloud.travel.domain.Travel;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(value= "FeignsServer" , url= "http://localhost:8080/")
public interface FeignServer {
    @GetMapping("/travel/{id}")
    ResponseEntity<Travel> getTravelById(@PathVariable Long id);
    @GetMapping("/customer/{id}")
    ResponseEntity<Customer> getCustomerById(@PathVariable Long id) ;


}
