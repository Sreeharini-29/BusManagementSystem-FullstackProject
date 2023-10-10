package BusManagementSystem.BusManagement1.Model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//this is the blueprint of  class
//table used to specify name of the table in the database
@Entity
@Table(name = "BusManagement_table")
//used to change the table name in database
@DynamicUpdate
//ensures that hibernate uses modified columns in database
public class Bus {
	@Id
	// acts as primary key in database
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// will generate something generally used in combination
	private Integer busId;

	private String source;
	private String drivername;

	private Integer totalnumberofseats;
	private Integer availableseats;

	private String destination;
	private String busnumber;
	@Column(name = "Agency_name")
	// used to change column name in database
	private String busAgencyName;
	private Boolean isACbus;

	private Integer rating;
	private Integer ticketPrice;

	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", source=" + source + ", drivername=" + drivername + ", totalnumberofseats="
				+ totalnumberofseats + ", availableseats=" + availableseats + ", destination=" + destination
				+ ", busnumber=" + busnumber + ", busAgencyName=" + busAgencyName + ", isACbus=" + isACbus + ", rating="
				+ rating + ", ticketPrice=" + ticketPrice + ", travelAgency=" + travelAgency + ", route=" + route + "]";
	}

	public Integer getBusId() {
		return busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	public String getDrivername() {
		return drivername;
	}

	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}

	public Integer getTotalnumberofseats() {
		return totalnumberofseats;
	}

	public void setTotalnumberofseats(Integer totalnumberofseats) {
		this.totalnumberofseats = totalnumberofseats;
	}

	public Integer getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(Integer ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public Integer getAvailableseats() {
		return availableseats;
	}

	public void setAvailableseats(Integer availableseats) {
		this.availableseats = availableseats;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getBusnumber() {
		return busnumber;
	}

	public void setBusnumber(String busnumber) {
		this.busnumber = busnumber;
	}

	public String getBusAgencyName() {
		return busAgencyName;
	}

	public void setBusAgencyName(String busAgencyName) {
		this.busAgencyName = busAgencyName;
	}

	public Boolean getIsACbus() {
		return isACbus;
	}

	public void setIsACbus(Boolean isACbus) {
		this.isACbus = isACbus;
	}

	@JoinColumn(name = "agencyId")
	@ManyToOne
	private TravelAgency travelAgency;

	public TravelAgency getTravelAgency() {
		return travelAgency;
	}

	public void setTravelAgency(TravelAgency travelAgency) {
		this.travelAgency = travelAgency;
	}

	// @JsonBackReference
	// @JsonIgnore
	@JoinColumn(name = "routeId")
	@ManyToOne
	private Route route;

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	// @JsonIgnore
	@OneToMany(mappedBy = "busObj", cascade = CascadeType.ALL)
	private List<Feedback> feedback = new ArrayList<>();

	
	public List<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}

	@OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
	private List<Booking> booking = new ArrayList<>();

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

}


