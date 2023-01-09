package block16springcloud.travel.infraestructure.repository;


import block16springcloud.travel.domain.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {


}
