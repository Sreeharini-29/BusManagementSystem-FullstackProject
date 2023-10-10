package BusManagementSystem.BusManagement1.Controller;

import java.util.List;

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

import BusManagementSystem.BusManagement1.Model.TravelAgency;
import BusManagementSystem.BusManagement1.ServiceImplementation.TravelAgencyServiceImpl;



@CrossOrigin
@RestController
@RequestMapping("/AgencyServ")
public class TravelAgencyController {
	@Autowired
	private TravelAgencyServiceImpl agencyService;
	
	public TravelAgencyController(TravelAgencyServiceImpl agencyService) {
		this.agencyService = agencyService;
	}
	
	@PostMapping("/saveAgency")
	public ResponseEntity<TravelAgency> saveBus(@RequestBody TravelAgency travelAgencyObj){
		try {
			return new ResponseEntity<TravelAgency>(agencyService.saveTravelAgency(travelAgencyObj), HttpStatus.CREATED);
		}
		catch(Exception exc) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/updateAgency/{agencyId}")
	public ResponseEntity<TravelAgency> updateBus(@PathVariable("agencyId") Integer agencyId ,
			@RequestBody TravelAgency travelAgencyObj){
		try {
			return new ResponseEntity<TravelAgency>(agencyService.updateAgencydetailsById(travelAgencyObj, agencyId), HttpStatus.OK);
		}
		catch(Exception exc) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/readAllAgencyDetail")
	public ResponseEntity<List<TravelAgency>> getAllbuses(@RequestParam(required = false) String travelAgencyName){
		try {
			return new ResponseEntity<>(agencyService.getAgencyDetailsFromDB(travelAgencyName), HttpStatus.OK);
		} 

		catch (Exception exc) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/readAgency/{agencyId}")
	public ResponseEntity<TravelAgency>  getBusById(@PathVariable("agencyId") Integer agencyId ){
		try {
			return new ResponseEntity<TravelAgency>(agencyService.getAgencyDetailsById(agencyId), HttpStatus.OK);
		}
		catch(Exception exc) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deleteAgency/{agencyId}")
	public void deleteBusbyId(@PathVariable("agencyId") Integer agencyId) {
		try {
			agencyService.deleteAgencyDetailById(agencyId);
		}
		catch(Exception exc) {
			System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("deleteAllAgency")
	public void deleteallBusdetails() {
		try {
			agencyService.deleteAllAgencyDetails();
		}
		catch(Exception exc) {
			System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
	



