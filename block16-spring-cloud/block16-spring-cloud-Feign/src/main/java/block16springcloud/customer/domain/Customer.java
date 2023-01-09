package block16springcloud.customer.domain;

import block16springcloud.travel.domain.Travel;

import lombok.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {



    private long id;
    private String name;
    private String surname;
    private String age;
    private String email;
    private String phoneNumber;
    private Travel travel;

}
