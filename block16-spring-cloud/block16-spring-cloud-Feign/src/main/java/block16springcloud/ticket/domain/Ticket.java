package block16springcloud.ticket.domain;

import block16springcloud.customer.domain.Customer;
import block16springcloud.travel.domain.Travel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Ticket")

public class Ticket {
    @Id
    @Column(name="id_ticket")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Long passengerId;
    private String passengerName;
    private String passengerLastname;
    private String passengerEmail;
    private String tripOrigin;
    private String tripDestination;
    private Date departureDate;
    private Date arrivalDate;

}
