package block16springcloud.ticket.infraestructure.controller;


import block16springcloud.ticket.application.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
@AllArgsConstructor
public class TicketController {

    @Autowired
    TicketService ticketService;

    //with @Getmaping, we can get dates in BB DD in this case we use the "users" and we can get all dates from database
    @PostMapping("/{userId}/{tripId}")
    public ResponseEntity getTicket(@PathVariable(name = "userId") Long idTravel,
                                    @PathVariable(name = "tripId") Long idCustomer) throws Exception {
        return new ResponseEntity<>(ticketService.addTicket(idTravel, idCustomer), HttpStatus.FOUND);
    }
}
