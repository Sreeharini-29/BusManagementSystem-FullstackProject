package BusManagementSystem.BusManagement1.Model;

import java.util.List;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
@Entity
@Table(name="route_table")
@DynamicUpdate
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int routeId;
	@NotNull(message = "Start point cannot be null !")
	@NotBlank(message = "Start point cannot be blank !")
	@NotEmpty(message = "Start point cannot be empty !")
	private String routeFrom;
	@NotNull(message = "Start point cannot be null !")
	@NotBlank(message = "Start point cannot be blank !")
	@NotEmpty(message = "Start point cannot be empty !")
	private String routeTo;
	private String distance;
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public String getRouteFrom() {
		return routeFrom;
	}
	public void setRouteFrom(String routeFrom) {
		this.routeFrom = routeFrom;
	}
	public String getRouteTo() {
		return routeTo;
	}
	public void setRouteTo(String routeTo) {
		this.routeTo = routeTo;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", routeFrom=" + routeFrom + ", routeTo=" + routeTo + ", distance="
				+ distance + "]";
	}
	
	//@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy = "route" ,cascade=CascadeType.ALL)
	private List<Bus> bus = new ArrayList<>();
	
	public List<Bus> getBus() {
		return bus;
	}
	public void setBus(List<Bus> bus) {
		this.bus = bus;
}
}