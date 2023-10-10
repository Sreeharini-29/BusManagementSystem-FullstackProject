package BusManagementSystem.BusManagement1.Model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table
@DynamicUpdate
public class Booking {
	@Id
	//acts as primary key in database
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;

	private String source;
	private Integer booked_seats;
	 private String destination;
	 private LocalDate journeyDate;
	 private LocalDate bookingDate;
	 private Integer totalBookingCost;
	 //@JsonIgnore
	
	 @ManyToOne
		private User user;
	 @JsonIgnore
	 @ManyToOne
		private Bus bus;
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public String getSource() {
		return source;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", source=" + source + ", booked_seats=" + booked_seats
				+ ", destination=" + destination + ", totalBookingCost=" + totalBookingCost + "]";
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Integer getBooked_seats() {
		return booked_seats;
	}
	public void setBooked_seats(Integer booked_seats) {
		this.booked_seats = booked_seats;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public LocalDate getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate localDate) {
		this.bookingDate = localDate;
	}
	
	public Integer getTotalBookingCost() {
		return totalBookingCost;
	}
	public void setTotalBookingCost(Integer totalBookingCost) {
		this.totalBookingCost = totalBookingCost;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}

	
	
	
}
