package BusManagementSystem.BusManagement1.Controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import BusManagementSystem.BusManagement1.Model.Bus;
import BusManagementSystem.BusManagement1.Model.Route;
import BusManagementSystem.BusManagement1.Model.TravelAgency;
import BusManagementSystem.BusManagement1.Repository.BusRepository;
import BusManagementSystem.BusManagement1.Repository.RouteRepository;
import BusManagementSystem.BusManagement1.ServiceImplementation.RouteServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/BusBooking.com")
public class RouteController {
	@Autowired
	private BusRepository busRepository;

	@Autowired
	private RouteServiceImpl routeService;
	public  RouteController(RouteServiceImpl routeService) {
		this.routeService =routeService;
	}

	@PostMapping("/saveBusRouteDetails")
	public ResponseEntity<Route>saveBusRouteDetails(@RequestBody Route route) {

		try {
			return  new ResponseEntity<>(routeService.saveBusRoute(route), HttpStatus.CREATED);
		}

		catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getAllBusRouteDetails")
	public ResponseEntity<List<Route>> getAllBusRouteDetails(){
		try {
			return new ResponseEntity<>(routeService.getAllBusRouteDetails(),HttpStatus.OK);
		}
		catch(Exception exc) {

			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}
	@GetMapping("/getBusRoutesByrouteId/{routeId}")
	public ResponseEntity<Route>getBusRoutesBybusId(@PathVariable int routeId) {
		Optional<Route> route = routeService.getBusRoutesByrouteId(routeId);
		try {
			if (route.isPresent()) {  //bus
				return new ResponseEntity<>(route.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/updateBusRoutebyId/{routeId}")
	public ResponseEntity updateBus(@PathVariable Integer routeId, @RequestBody Route routeObj){

		try {
			return new ResponseEntity<Route>(routeService.updateBusRouteByrouteId(routeId,routeObj),HttpStatus.OK);
		}
		catch(Exception exc) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/deleteBusByrouteId/{routeId}")
	public void deleteBusRoutesById(@PathVariable("routeId")int routeId) {
		try {	
			routeService.deleteBusRoutesById(routeId);
		}
		catch(Exception exc) {
			System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	}






