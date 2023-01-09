package block16springcloud.ticket.application;

import block16springcloud.Feign.FeignServer;
import block16springcloud.customer.domain.Customer;
import block16springcloud.ticket.domain.Ticket;
import block16springcloud.ticket.infraestructure.repository.TicketRepository;
import block16springcloud.travel.domain.Travel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TicketService implements TicketServiceInterface {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    FeignServer feignServer;

    @Override
    public Ticket addTicket( Long idCustomer, Long idTravel) throws Exception {

        Ticket ticket = new Ticket();

        Travel travel = feignServer.getTravelById(idTravel).getBody();


        ticket.setTripOrigin(travel.getOrigin());
        ticket.setTripDestination(travel.getDestination());
        ticket.setDepartureDate(travel.getDepartureDate());
        ticket.setArrivalDate(travel.getArrivalDate());


        Customer customer = feignServer.getCustomerById(idCustomer).getBody();

        ticket.setPassengerId(customer.getId());
        ticket.setPassengerName(customer.getName());
        ticket.setPassengerLastname(customer.getSurname());
        ticket.setPassengerEmail(customer.getEmail());






        return  ticketRepository.save(ticket);
    }



}
