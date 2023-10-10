package BusManagementSystem.BusManagement1.Service;

import java.util.List;
import java.util.Optional;

import BusManagementSystem.BusManagement1.Model.Booking;


public interface BookingService {
	Booking addBookingById(Booking booking1,Integer bus_id, Integer userId);
	void getbookingdetailsBybookingId(int bookingId);
	void getbookingdetailsByuserId(int userId);
	List<Booking> getAllBookingDetails();
	void deleteBookingdetailsById(int bookingId);
}
