package BusManagementSystem.BusManagement1.Model;



import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class TravelAgency {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer agencyId;
@Column(length=20,nullable=false)
private String travelAgencyOwnername;
@Column(length=20,nullable=false)
private String travelAgencyName;
@Column(length=20,nullable=false,unique=true,updatable=true)
private String travelAgencyEmail;
@Column(nullable=true)
private Integer establishedyear;
public Integer getAgencyId() {
	return agencyId;
}
public void setAgency_id(Integer agencyId) {
	this.agencyId = agencyId;
}
public String getTravelAgencyOwnername() {
	return travelAgencyOwnername;
}
public void setTravelAgencyOwnername(String travelAgencyOwnername) {
	this.travelAgencyOwnername = travelAgencyOwnername;
}
public String getTravelAgencyName() {
	return travelAgencyName;
}
public void setTravelAgencyName(String travelAgencyName) {
	this.travelAgencyName = travelAgencyName;
}
public String getTravelAgencyEmail() {
	return travelAgencyEmail;
}
public void setTravelAgencyEmail(String travelAgencyEmail) {
	this.travelAgencyEmail = travelAgencyEmail;
}
public Integer getEstablishedyear() {
	return establishedyear;
}
public void setEstablishedyear(Integer establishedyear) {
	this.establishedyear = establishedyear;
}
@Override
public String toString() {
	return "TravelAgency [agencyId=" + agencyId + ", travelAgencyOwnername=" + travelAgencyOwnername
			+ ", travelAgencyName=" + travelAgencyName + ", travelAgencyEmail=" + travelAgencyEmail
			+ ", establishedyear=" + establishedyear + "]";
}
@JsonIgnore
@OneToMany(mappedBy = "travelAgency" ,cascade=CascadeType.ALL)
private List<Bus> bus = new ArrayList<>();

public List<Bus> getBus() {
	return bus;
}
public void setBus(List<Bus> bus) {
	this.bus = bus;
}
}

