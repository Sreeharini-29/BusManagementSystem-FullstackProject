package BusManagementSystem.BusManagement1.ServiceImplementation;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BusManagementSystem.BusManagement1.Model.Bus;
import BusManagementSystem.BusManagement1.Repository.BusRepository;
import BusManagementSystem.BusManagement1.Service.BusService;
import org.springframework.data.domain.Sort;

//service annotation used as class provides some business functionalities
/*this is an interface interacting with other interface*/
@Service
public class BusServiceImpl implements BusService{

	@Autowired
	private BusRepository busRepository;

	public BusServiceImpl(BusRepository busRepository) {
		this.busRepository = busRepository;
	}
	//save bus details	
	public Bus saveBus(Bus busObj) {
		return  busRepository.save(busObj);
	}
	//get all bus details

	@Override
	public List<Bus> fetchbusesFromDb() {

		return busRepository.findAll();  
	}
	//get bus details by source and destination
	public List<Bus> fetchBySourceAndDestination(String source,String destination){
		List<Bus> buses = new ArrayList<Bus>();
		busRepository.findBySourceAndDestination(source, destination).forEach(buses::add);
		return buses;
	}
	private Sort.Direction getSortDirection(String direction) {
	    if (direction.equalsIgnoreCase("asc")) {
	      return Sort.Direction.ASC;
	    } else if (direction.equalsIgnoreCase("desc")) {
	      return Sort.Direction.DESC;
	    }

	    return Sort.Direction.ASC;
	  }
	
	
	public  List<Bus> sortByticketPrice(String direction, String fieldName) {
		
		List<Bus> busObj= new ArrayList<Bus>();
		busObj = busRepository.findAll(Sort.by(getSortDirection(direction), fieldName));
		return busObj;
	}

	private Sort.Direction getSortByDirection(String direction) {
	    if (direction.equalsIgnoreCase("asc")) {
	      return Sort.Direction.ASC;
	    } else if (direction.equalsIgnoreCase("desc")) {
	      return Sort.Direction.DESC;
	    }

	    return Sort.Direction.ASC;
	  }
	public  List<Bus> sortByrating(String direction, String fieldName) {
		
		List<Bus> busObj= new ArrayList<Bus>();
		busObj = busRepository.findAll(Sort.by(getSortByDirection(direction), fieldName));
		return busObj;
	}
	//get bus details by id
	@Override//5
	public Bus getBusdetailsById(int busId) { //23
		Optional<Bus> busObj =  busRepository.findById(busId);  //null , or it can 5tg person rec
		if(busObj.isPresent()) {
			return busObj.get();
		}
		else {
			return null;
		}
	}
	//update bus details by id
	public Bus updateBusdetailsById(Bus busdetails,int busId) {
		Optional<Bus>bus=busRepository.findById(busId);
		if(bus.isPresent()) {
			Bus existingbus=bus.get();
			existingbus.setTotalnumberofseats(busdetails.getTotalnumberofseats());
			existingbus.setDrivername(busdetails.getDrivername());
			existingbus.setAvailableseats(busdetails.getAvailableseats());
			
			existingbus.setRating(busdetails.getRating());
			existingbus.setBusnumber(busdetails.getBusnumber());
			existingbus.setIsACbus(busdetails.getIsACbus());
			existingbus.setBusAgencyName(busdetails.getBusAgencyName());
			existingbus.setTicketPrice((busdetails.getTicketPrice()));
			existingbus.setRating((busdetails.getRating()));
			busRepository.save(existingbus);
			return existingbus;
		}
		else {
			return null;

		}

	}

	//delete bus details by id
	@Override
	public Optional<Bus> deleteBusdetailsById(int busId) {
		Optional<Bus> busObj = busRepository.findById(busId);  
		if(busObj.isPresent()) {
			busRepository.deleteById(busId);
			{
				return busObj;
			}	
		}
		return null;
		}
	//delete all bus details
	@Override
	public void deleteallBusdetails() {
		 busRepository.deleteAll();
		 System.out.println("all bus are deleted");
	}	
	//get details by ac bus
	public List<Bus> fetchACBus(boolean booleanObj) {
		List<Bus> busObj = busRepository.findByIsACbus(true);
		return busObj;
	}
	//get details by nonac bus
	public List<Bus> fetchNonACBus(boolean booleanObj) {
		List<Bus> busObj = busRepository.findByIsACbus(false);
		return busObj;
	}
	//get details by agency name
	public List<Bus> fetchACorNonACDetails(String busAgencyName){
		return busRepository.findByBusAgencyNameContainingIgnoreCase(busAgencyName);
	}


}


