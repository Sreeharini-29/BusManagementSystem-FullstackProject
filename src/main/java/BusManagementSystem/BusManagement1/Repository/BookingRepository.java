package BusManagementSystem.BusManagement1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import BusManagementSystem.BusManagement1.Model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
	@Query("SELECT a FROM Booking a WHERE a.bookingId=:bookingId")
	public Booking findByBookingId(@Param("bookingId") Integer bookingId);
	@Query("SELECT a FROM Booking a WHERE a.user.userId=:userId")
	List<Booking> findByUserId(@Param("userId") Long userId);

}
