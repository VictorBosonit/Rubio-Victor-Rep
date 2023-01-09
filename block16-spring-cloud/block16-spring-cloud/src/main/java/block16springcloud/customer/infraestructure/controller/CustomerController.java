package block16springcloud.customer.infraestructure.controller;

import block16springcloud.customer.application.CustomerService;
import block16springcloud.customer.domain.Customer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //with @Postmaping we can introduce dates in BB DD
    @PostMapping
    public ResponseEntity addCustomer(@RequestBody Customer customer) throws Exception {
        return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
    }

    //with @Getmaping, we can get dates in BB DD in this case we use the "id"
    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity getCustomerById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    //with @Getmaping, we can get dates in BB DD in this case we use the "users" and we can get all dates from database
    @GetMapping("/all")
    public ResponseEntity getCustomers() throws Exception{
        try {
            return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.FOUND);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // with @Putmaping, we can update dates in BB DD in this case we use the "id"
    @PutMapping("/{id}")
    public ResponseEntity updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) throws Exception {
        return new ResponseEntity(customerService.updateCustomer(id, customer), HttpStatus.ACCEPTED);
    }

    // with @Deletemaping, we can delete dates in BB DD in this case we use the "id"
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable("id") Long id) throws Exception {

        boolean response = customerService.deleteCustomer(id);

        if (response == true) {
            return ResponseEntity.status(HttpStatus.OK).body("{\"Borrado\":}");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, id no encontrada, por favor vuelva a intentar.\"}");
        }
    }

    @GetMapping("/count/{tripId}")
    public ResponseEntity getCountTravel(@PathVariable("tripId") Long id) throws Exception {
        return new ResponseEntity("El viaje tiene "+customerService.countTravel(id) + " plazas ", HttpStatus.ACCEPTED);
    }
}
