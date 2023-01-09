package block16springcloud.customer.infraestructure.repository;

import block16springcloud.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public  interface CustomerRepository extends JpaRepository <Customer, Long> {


}
