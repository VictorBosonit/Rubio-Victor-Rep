package block16springcloud.ticket.infraestructure.repository;

import block16springcloud.ticket.domain.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository <Ticket, Long>{
}
