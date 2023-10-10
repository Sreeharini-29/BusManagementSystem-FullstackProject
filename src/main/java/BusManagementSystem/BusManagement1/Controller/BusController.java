 package BusManagementSystem.BusManagement1.Controller;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import BusManagementSystem.BusManagement1.Model.Bus;
import BusManagementSystem.BusManagement1.Repository.AgencyRepository;
import BusManagementSystem.BusManagement1.Repository.BusRepository;
import BusManagementSystem.BusManagement1.ServiceImplementation.BusServiceImpl;

//it sends response for the request by the controller
@RestController
//used to map http request
@CrossOrigin
@RequestMapping("/busmanagement.com")
public class BusController {
	// automatic dependency injection
	@Autowired
	private AgencyRepository agencyRepository;
	
	
	@Autowired
	public BusServiceImpl busservice;

	public  BusController(BusServiceImpl busservice) {
		this.busservice = busservice;
	}

	// create bus in rest api
	@PostMapping("/savebus/{agency_id}")
	public ResponseEntity<Bus> saveBus(@PathVariable("agency_id") int agency_id,@RequestBody Bus busObj) {
		try {
			agencyRepository.findById(agency_id).map(travelAgency -> {
				busObj.setTravelAgency(travelAgency);	
			return new ResponseEntity<Bus>(busservice.saveBus(busObj), HttpStatus.CREATED);
			}).orElseThrow(() -> new Exception("Internal_Server_Error"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		}


	// to get bus by id in rest api
	@GetMapping("/getbus/{busId}")
	public ResponseEntity<Bus> getBusById(@PathVariable Integer busId) {
		try {
			
		
		//serv.method name 
		return new ResponseEntity<Bus>(busservice.getBusdetailsById(busId), HttpStatus.OK);
		}
		catch(Exception exc) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	// update bus  by rest api
			@PutMapping("/updatebus/{busId}")
			public ResponseEntity<Bus> updateBus(@PathVariable Integer busId, @RequestBody Bus busObj){
				try {
					return new ResponseEntity<>(busservice.updateBusdetailsById(busObj,busId), HttpStatus.OK);

				}
					catch(Exception exc) {
						return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
					}
				
				}

	//get all bus details
	@GetMapping("/buses")
	public ResponseEntity<List<Bus>> getAllbuses(@RequestParam(required = false) String busAgencyName) {
		try {
			List<Bus> buses = new ArrayList<Bus>();

			if (busAgencyName == null)
				busservice.fetchbusesFromDb().forEach(buses::add);
			else
		busservice.fetchACorNonACDetails(busAgencyName).forEach(buses::add);

			if (buses.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(buses, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//get busdetails by source and destination
	@GetMapping("/searchBuses")
	public ResponseEntity<List<Bus>> getBusbySourceandDestination(@RequestParam(required = true) String source,String destination){
		try {
			List<Bus> buses = busservice.fetchBySourceAndDestination(source,destination);

			if (buses.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(buses, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/sortByticketPrice/{direction}")
	public ResponseEntity<List<Bus>> getAllBusesByticketPriceSort(@PathVariable("direction") String direction, @RequestParam(required = true)String fieldName){
		try {
		List<Bus> busObj = new ArrayList<Bus>();
		busObj = busservice.sortByticketPrice(direction,fieldName);
		if(busObj.isEmpty()) 
			return new ResponseEntity<List<Bus>>(HttpStatus.NO_CONTENT);
		
	    return new ResponseEntity<List<Bus>>(busObj,HttpStatus.OK);
	    
	}
		catch(Exception exc) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping("/sortByrating/{direction}")
	public ResponseEntity<List<Bus>> getAllBusesByratingSort(@PathVariable("direction") String direction, @RequestParam(required = true)String fieldName){
		try {
		List<Bus> busObj = new ArrayList<Bus>();
		busObj = busservice.sortByrating(direction,fieldName);
		if(busObj.isEmpty()) 
			return new ResponseEntity<List<Bus>>(HttpStatus.NO_CONTENT);
		
		
	    return new ResponseEntity<List<Bus>>(busObj,HttpStatus.OK);
	    
	}
		catch(Exception exc) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

		

		// delete employee by rest api
		@DeleteMapping("/deleteBus/{busId}")
		public ResponseEntity<Bus> deleteBusbyId(@PathVariable Integer busId){
		Optional<Bus> busdata =busservice.deleteBusdetailsById(busId);
			try {
				if (busdata.isPresent()) {
				busservice.deleteBusdetailsById(busId);
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
//delete all details by rest api
		@DeleteMapping("/deletebuses")
		public ResponseEntity<Bus> deleteallBusdetails() {
			//return new ResponseEntity<>(busservice.deleteallBusdetails(),HttpStatus.OK);
			try {
				busservice.deleteallBusdetails();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	//api to get AC bus details 	
		@GetMapping("/buses/ACbus")
		public ResponseEntity<List<Bus>> forACBuses() {
			try {
				//call serv method
				List<Bus> buses = 	busservice.fetchACBus(true);

				if (buses.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(buses, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		//api to get non AC bus details
		@GetMapping("/buses/nonACbus")
		public ResponseEntity<List<Bus>> forNonACBuses() {
			try {
				//call serv
				//getallbusbyACbusdomain()
				List<Bus> buses= busservice.fetchNonACBus(false);

				if (buses.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(buses, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}
}
