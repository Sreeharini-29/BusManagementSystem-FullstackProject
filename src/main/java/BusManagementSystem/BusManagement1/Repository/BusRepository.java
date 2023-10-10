package BusManagementSystem.BusManagement1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import BusManagementSystem.BusManagement1.Model.Bus;

//repository interface is created
// It is used to indicate that the class provides the methods for storage, retrieval, search, update and delete operation on objects
@Repository
public interface BusRepository extends JpaRepository<Bus,Integer>{
	
	List<Bus> findByIsACbus(Boolean booleanObj);
	List<Bus>findBySourceAndDestination(String source,String destination);	
	List<Bus> findByBusAgencyNameContainingIgnoreCase(String busAgencyName);
}
