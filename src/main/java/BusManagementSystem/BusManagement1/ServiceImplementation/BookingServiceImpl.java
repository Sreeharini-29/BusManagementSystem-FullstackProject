package BusManagementSystem.BusManagement1.ServiceImplementation;

import BusManagementSystem.BusManagement1.exceptions.AppException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BusManagementSystem.BusManagement1.Model.Booking;
import BusManagementSystem.BusManagement1.Model.Bus;
import BusManagementSystem.BusManagement1.Model.Feedback;
import BusManagementSystem.BusManagement1.Model.Route;
import BusManagementSystem.BusManagement1.Model.User;
import BusManagementSystem.BusManagement1.Repository.BookingRepository;
import BusManagementSystem.BusManagement1.Repository.BusRepository;
import BusManagementSystem.BusManagement1.Repository.userRepository;

@Service
public class BookingServiceImpl {
	@Autowired
	private EmailService emailService;
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private BusRepository busRepository;
	@Autowired
	private userRepository userRepository;

	public BookingServiceImpl(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}

	public Booking addBooking(Booking booking1, Integer userId, Integer busId) throws Exception {

		User user = userRepository.findById((Integer) userId).get();
//		if (user.isEmpty()) {
//			throw new Exception("User is not present with Id: "+ userId);
//		}
		Bus busObj = busRepository.findById(busId).get();
//	if (busObj.isEmpty()) {
//		throw new Exception("Bus is not present with Id: "+ busId);
//	}
		List<Bus> bus = busRepository.findBySourceAndDestination(booking1.getSource(), booking1.getDestination());
		if (busObj.getAvailableseats() <= booking1.getBooked_seats()) {
			throw new AppException("seats unavailable", "booking.failed");
		}
		if (booking1.getJourneyDate().isBefore(LocalDate.now())) {
			throw new AppException("Invalid journey date", "booking.failed");
		}
		// if(busObj.getAvailableseats()>=booking1.getBooked_seats()&&booking1.getJourneyDate().isAfter(LocalDate.now()))
		// {
		int confirmedSeats = booking1.getBooked_seats();
		int presentAvailableSeats = busObj.getAvailableseats() - booking1.getBooked_seats();
		busObj.setAvailableseats(presentAvailableSeats); // 176
		Booking confirmedBooking = new Booking();
		confirmedBooking.setTotalBookingCost(busObj.getTicketPrice() * booking1.getBooked_seats());// 4500*3
		confirmedBooking.setBus(busObj);
		confirmedBooking.setUser(user);
		confirmedBooking.setBooked_seats(confirmedSeats);
		confirmedBooking.setBookingDate(LocalDate.now());
		confirmedBooking.setSource(busObj.getSource());
		confirmedBooking.setDestination(busObj.getDestination());
		confirmedBooking.setJourneyDate(booking1.getJourneyDate());
		//emailService.sendEmail(user.getUserEmail(),);
		String content = "Bus Details : " + confirmedBooking.getBus();
		emailService.sendEmail(user.getUserEmail(), "Your Booking Is Confirmed!!!", content);
		
		return bookingRepository.save(confirmedBooking);
		

	}
//	public Optional<Booking> deleteBookingdetailsById(int bookingId) {
//		Optional<Booking> booking = bookingRepository.findById(bookingId);  
//		if(booking.isPresent()) {
//			busRepository.deleteById(bookingId);
//			{
//				return booking;
//			}	
//		}
//		return null;
//		}
	public Booking deleteBookingById(int bookingId) {
		if(bookingRepository.findById(bookingId).get() != null) {

			bookingRepository.deleteById(bookingId);
		}
		return null;
	}
	public List<Booking> getAllBookingDetails()  {
//		List<Booking> booking=
		return bookingRepository.findAll();
		
		            
	}
	public Booking getbookingdetailsBybookingId(Integer bookingId) { // 23
		Booking booking = bookingRepository.findByBookingId(bookingId); // null , or it can 5tg person rec
		return booking;
	}

	public List<Booking> getbookingdetailsByuserId(Long userId) { // 23
		List<Booking> booking = bookingRepository.findByUserId(userId); // null , or it can 5tg person rec
		return  booking;
	}
}
