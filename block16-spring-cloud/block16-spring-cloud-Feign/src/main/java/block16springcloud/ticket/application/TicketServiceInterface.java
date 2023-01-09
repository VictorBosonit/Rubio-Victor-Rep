package block16springcloud.ticket.application;

import block16springcloud.ticket.domain.Ticket;

public interface TicketServiceInterface {

    Ticket addTicket ( Long idCustomer, Long idTravel) throws Exception;
}
