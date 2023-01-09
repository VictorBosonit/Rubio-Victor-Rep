package block16springcloud.customer.application;

import block16springcloud.customer.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerServiceInterface {

    //This method add a new customer to database
    Customer addCustomer(Customer customer) throws Exception;

    //This method get object from BB DD trow us id
    //Optional is for prevent error nullpointerexception
    Customer getCustomerById(Long id)throws  Exception;

    //this method is for get all customer from database
    List<Customer> getAllCustomer()throws  Exception;

    //This method update the BB DD where id=id
    Customer updateCustomer(Long id, Customer customer)throws  Exception;

    // This method delete Person where id=id
    boolean deleteCustomer (Long id)throws  Exception;

    Long countTravel (Long id) throws Exception;


}
