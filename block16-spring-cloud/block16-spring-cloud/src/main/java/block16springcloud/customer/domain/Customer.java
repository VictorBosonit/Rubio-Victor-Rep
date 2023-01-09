package block16springcloud.customer.domain;

import block16springcloud.travel.domain.Travel;
import jakarta.persistence.*;
import lombok.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Customer")

public class Customer {


    @Id
    @Column(name="id_customer")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String surname;

    private String age;

    private String email;

    private String phoneNumber;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_travel")
    private Travel travel;

}
