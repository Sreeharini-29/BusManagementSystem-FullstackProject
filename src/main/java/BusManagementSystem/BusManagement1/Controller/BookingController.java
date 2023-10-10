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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BusManagementSystem.BusManagement1.Model.Booking;
import BusManagementSystem.BusManagement1.Model.Bus;
import BusManagementSystem.BusManagement1.Model.Feedback;
import BusManagementSystem.BusManagement1.Model.Route;
import BusManagementSystem.BusManagement1.Repository.BusRepository;
import BusManagementSystem.BusManagement1.Repository.userRepository;
import BusManagementSystem.BusManagement1.ServiceImplementation.BookingServiceImpl;
import jakarta.validation.Valid;
@RestController
//used to map http request
@CrossOrigin
@RequestMapping("/busBooking.com")

public class BookingController {
	@Autowired
	public BusRepository busRepository;
	@Autowired
	public userRepository userrepository;
	@Autowired
	public BookingServiceImpl bookingservice;

	public  BookingController(BookingServiceImpl bookingservice) {
		this.bookingservice = bookingservice;
	}
	@PostMapping("bookingticket/{userId}/{busId}")
	public ResponseEntity<Booking>addBooking(@Valid @RequestBody Booking booking1,@PathVariable("userId") Integer userId,@PathVariable("busId") Integer busId)throws Exception{
		
		
		Booking booking=bookingservice.addBooking(booking1, userId, busId);
		return  new ResponseEntity<Booking>(booking,HttpStatus.ACCEPTED);
		
		
		
		
	}
	@GetMapping("/getbooking/{bookingId}")
	public ResponseEntity<Booking> getBookingBybookingId(@PathVariable Integer bookingId) {
		try {
			
		
		//serv.method name 
		return new ResponseEntity<Booking>(bookingservice.getbookingdetailsBybookingId(bookingId), HttpStatus.OK);
		}
		catch(Exception exc) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@DeleteMapping("/deleteBookingbybookingId/{bookingId}")
	public ResponseEntity<Booking> deleteBookingById(@PathVariable("bookingId")int bookingId) {
//			bookingservice.deleteBookingById(bookingId);
//			return new ResponseEntity<Booking>("Booking successfully cancelled!!",HttpStatus.OK);
			try {
				
				
				//serv.method name 
				return new ResponseEntity<Booking>(bookingservice.deleteBookingById(bookingId), HttpStatus.OK);
				}
				catch(Exception exc) {
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
				
			}		
	
//	@DeleteMapping("/deleteBooking/{bookingId}")
//	public ResponseEntity<Booking> deleteBookingbyId(@PathVariable Integer bookingId){
//	Optional<Booking> booking =bookingservice.deleteBookingById(bookingId);
//		try {
//			if (booking.isPresent()) {
//			bookingservice.deleteBookingById(bookingId);
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			}
//			else {
//				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			}
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//
//	
	@GetMapping("/getAllBookings")
	public ResponseEntity<List<Booking>> getAllBookingDetails(){
		try {
			return new ResponseEntity<>(bookingservice.getAllBookingDetails(),HttpStatus.OK);
		}
		catch(Exception exc) {
			
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}
		
	@GetMapping("/getbooking/user/{userId}")
	public List<Booking> getBookingByuserId(@PathVariable Long userId) {
		
			
		
		//serv.method name 
		return bookingservice.getbookingdetailsByuserId(userId);
		
		
	}
	
}
