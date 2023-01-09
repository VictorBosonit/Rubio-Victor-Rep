package block16springcloud.travel.application;

import block16springcloud.customer.domain.Customer;
import block16springcloud.customer.infraestructure.repository.CustomerRepository;
import block16springcloud.travel.domain.Travel;
import block16springcloud.travel.infraestructure.repository.TravelRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class TravelService implements TravelServiceInterface{

    @Autowired
    TravelRepository travelRepository;
    @Autowired
    CustomerRepository customerRepository;


    //this method is for add new travel to bbdd
    @Override
    public Travel addTravel(Travel travel) throws Exception {

        return travelRepository.save(travel);
    }

    @Override
    public String addTravelCustomer(Long id1, Long id2) throws Exception {

        String mensaje ;
       Travel travel = travelRepository.findById(id1).get();
       Customer customer =customerRepository.findById(id2).get();

        customer.setTravel(travel);
        customerRepository.save(customer);

        if (customer.getTravel()!=null){
            mensaje="Viaje añadido con exito";
        }else {mensaje="Viaje no ha sido añadido con exito";}


        return mensaje;
    }



    // this method is for get travel in function of parameter id
    @Override
    public Optional<Travel> getTravelById(Long id) throws Exception {
        return travelRepository.findById(id);
    }
    // this method is for get all travel
    @Override
    public List<Travel> getAllTravel() throws Exception {
        return travelRepository.findAll();
    }
    // this method is fpr update travel in function of parameter id
    @Override
    public Travel updateTravel(Long id, Travel travel) throws Exception {

        Travel travelFinded = travelRepository.findById(id).get();

        travelFinded.setOrigin(travel.getOrigin());
        travelFinded.setPassenger(travel.getPassenger());
        travelFinded.setStatus(travel.getStatus());
        travelFinded.setDestination(travel.getDestination());
        travelFinded.setArrivalDate(travel.getArrivalDate());
        travelFinded.setDepartureDate(travel.getDepartureDate());

        return travelRepository.save(travelFinded);
    }

    //this method is for delete travel in function of parameter id
    @Override
    public boolean deleteTravel(Long id) throws Exception {

        boolean returned = false;

        if (travelRepository.findById(id).isPresent()){
            travelRepository.deleteById(id);
            returned= true;
        }
        return returned;
    }

    @Override
    public Travel changeStatus(Long id, String status) throws Exception {

        Travel travel = travelRepository.findById(id).get();
        travel.setStatus(status);

        return travel;
    }

    @Override
    public String checkStatus(Long id) throws Exception {
        Travel travel = travelRepository.findById(id).get();

        return "El estado del viaje es: " + travel.getStatus();
    }


}
