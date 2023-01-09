package block16springcloud.travel.domain;

import block16springcloud.customer.domain.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Travel")
public class Travel {

    @Id
    @Column(name="id_travel")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String origin;

    private String destination;

    private Date departureDate;

    private Date arrivalDate;

    private String status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "travel", cascade = CascadeType.ALL)
    private List<Customer>passenger;

}
