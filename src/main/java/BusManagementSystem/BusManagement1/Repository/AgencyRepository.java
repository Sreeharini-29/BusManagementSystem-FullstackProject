package BusManagementSystem.BusManagement1.Repository;




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import BusManagementSystem.BusManagement1.Model.TravelAgency;
@Repository
public interface AgencyRepository extends JpaRepository<TravelAgency,Integer>{

Optional<TravelAgency> findById(int agencyId);

}
