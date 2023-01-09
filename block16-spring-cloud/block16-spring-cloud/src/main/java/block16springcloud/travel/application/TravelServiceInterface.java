package block16springcloud.travel.application;

import block16springcloud.travel.domain.Travel;
import java.util.List;
import java.util.Optional;

public interface TravelServiceInterface {

    Travel addTravel(Travel travel) throws Exception;

    //This method add a new customer to database
    String addTravelCustomer( Long id1, Long id2) throws Exception;

    //This method get object from BB DD trow us id
    //Optional is for prevent error nullpointerexception
    Optional<Travel> getTravelById(Long id)throws  Exception;

    //this method is for get all customer from database
    List<Travel> getAllTravel()throws  Exception;

    //This method update the BB DD where id=id
    Travel updateTravel(Long id, Travel travel)throws  Exception;

    // This method delete Person where id=id
    boolean deleteTravel (Long id)throws  Exception;
    // this method is for change el status of travel
    Travel changeStatus (Long id, String status) throws Exception;

    //this method is for check status of travel
    String checkStatus (Long id) throws Exception;
}
