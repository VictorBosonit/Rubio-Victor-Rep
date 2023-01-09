package block16springcloud.travel.infraestructure.controller;

import block16springcloud.customer.application.CustomerService;
import block16springcloud.customer.domain.Customer;
import block16springcloud.travel.application.TravelService;
import block16springcloud.travel.domain.Travel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/travel")
@AllArgsConstructor
public class TravelController {



        @Autowired
        private TravelService travelService;
        //with @Postmaping we can introduce dates in BB DD
        @PostMapping
        public ResponseEntity addTravel(@RequestBody Travel travel) throws Exception {
            return new ResponseEntity<>(travelService.addTravel(travel), HttpStatus.CREATED);
        }

        //with @Postmaping we can introduce dates in BB DD
        @PostMapping("/{id1}/{id2}")
        public ResponseEntity addTravelCustomer(@PathVariable Long id1,
                                        @PathVariable Long id2) throws Exception {
            return new ResponseEntity<>(travelService.addTravelCustomer( id1, id2), HttpStatus.CREATED);
        }

        //with @Getmaping, we can get dates in BB DD in this case we use the "id"
        @GetMapping("/{id}")
        @ResponseStatus(value = HttpStatus.OK)
        public ResponseEntity getTravelById(@PathVariable Long id) throws Exception {
            return new ResponseEntity<>(travelService.getTravelById(id), HttpStatus.OK);
        }

        //with @Getmaping, we can get dates in BB DD in this case we use the "users" and we can get all dates from database
        @GetMapping("/all")
        public ResponseEntity getTreavel() throws Exception{
            try {
                return new ResponseEntity<>(travelService.getAllTravel(), HttpStatus.FOUND);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        // with @Putmaping, we can update dates in BB DD in this case we use the "id"
        @PutMapping("/{id}")
        public ResponseEntity updateTravel(@PathVariable("id") Long id, @RequestBody Travel travel) throws Exception {
            return new ResponseEntity(travelService.updateTravel(id, travel), HttpStatus.ACCEPTED);
        }

        // with @Deletemaping, we can delete dates in BB DD in this case we use the "id"
        @DeleteMapping("/{id}")
        public ResponseEntity deleteTravel(@PathVariable("id") Long id) throws Exception {

            boolean response = travelService.deleteTravel(id);

            if (response == true) {
                return ResponseEntity.status(HttpStatus.OK).body("{\"Borrado\":}");

            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, id no encontrada, por favor vuelva a intentar.\"}");
            }
        }

    @PutMapping("/{id}/{status}")
    public ResponseEntity changeStatus(@PathVariable("id") Long id,
                                       @PathVariable("status")String status) throws Exception {
        return new ResponseEntity(travelService.changeStatus(id, status), HttpStatus.ACCEPTED);
    }
    }

