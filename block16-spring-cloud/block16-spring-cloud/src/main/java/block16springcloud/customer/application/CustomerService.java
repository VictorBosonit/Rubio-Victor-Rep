package block16springcloud.customer.application;

import block16springcloud.customer.domain.Customer;
import block16springcloud.customer.infraestructure.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class CustomerService implements   CustomerServiceInterface{

    @Autowired
    CustomerRepository customerRepository;


    //with this method we created a new customer in database
    @Override
    public Customer addCustomer(Customer customer) throws Exception {
        return customerRepository.save(customer);
    }


    @Override
    public Customer getCustomerById(Long id) throws Exception {

        return customerRepository.findById(id).get();
    }

    @Override
    public List<Customer> getAllCustomer() throws Exception {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) throws Exception {

       Customer customerFind = customerRepository.findById(id).get();

        customerFind.setName(customer.getName());
        customerFind.setEmail(customer.getEmail());
        customerFind.setSurname(customer.getSurname());
        customerFind.setPhoneNumber(customer.getPhoneNumber());
        customerFind.setEmail(customer.getEmail());

        return customerRepository.save(customerFind);
    }

    @Override
    public boolean deleteCustomer(Long id) throws Exception {

         boolean returned  = false;

        if (customerRepository.findById(id).isPresent()){

            customerRepository.deleteById(id);
            returned = true;
        }
        return returned;
    }

    @Override
    public Long countTravel(Long id) throws Exception {

        List<Customer> customer1= customerRepository.findAll();

       Long travelSize = customer1.stream()
                .filter(customer -> customer.getTravel().getId()==id)
                .count();

        return travelSize;

    }
}
