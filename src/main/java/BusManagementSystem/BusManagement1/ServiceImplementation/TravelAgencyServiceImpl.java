package BusManagementSystem.BusManagement1.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BusManagementSystem.BusManagement1.Model.TravelAgency;
import BusManagementSystem.BusManagement1.Repository.AgencyRepository;
@Service
public class TravelAgencyServiceImpl {
	@Autowired
	private AgencyRepository travelAgencyRepository;

	public TravelAgencyServiceImpl(AgencyRepository travelAgencyRepository) {
		this. travelAgencyRepository=  travelAgencyRepository;
	}
	public TravelAgency saveTravelAgency(TravelAgency travelAgencyObj) {
		
			return   travelAgencyRepository.save(travelAgencyObj);
		
	}

	public TravelAgency updateAgencydetailsById(TravelAgency travelAgencyObj, Integer agencyId) {
		Optional<TravelAgency>travelAgency=travelAgencyRepository.findById(agencyId);
		if(travelAgency.isPresent()) {
			TravelAgency existingtravelAgency=travelAgency.get();
			existingtravelAgency.setTravelAgencyOwnername( travelAgencyObj.getTravelAgencyOwnername());
			existingtravelAgency.setTravelAgencyName(travelAgencyObj.getTravelAgencyName());
			existingtravelAgency.setTravelAgencyEmail(travelAgencyObj.getTravelAgencyEmail());
			existingtravelAgency.setEstablishedyear(travelAgencyObj.getEstablishedyear());
			
			travelAgencyRepository.save(existingtravelAgency);
			return existingtravelAgency;
		}
		else {
			return null;
		}
		}
		

	public List<TravelAgency> getAgencyDetailsFromDB(String travelAgencyName) {
		return travelAgencyRepository.findAll();  
	}

	public TravelAgency getAgencyDetailsById(Integer agencyId) {
		Optional<TravelAgency> travelAgency = travelAgencyRepository.findById(agencyId);  //null , or it can 5tg person rec
		if(travelAgency.isPresent()) {
			return travelAgency.get();
		}
		else {
			return null;
		}
	}

	public Optional<TravelAgency>  deleteAgencyDetailById(Integer agencyId) {
		Optional<TravelAgency> travelAgency =travelAgencyRepository.findById(agencyId);  
		if(travelAgency.isPresent()) {
			travelAgencyRepository.deleteById(agencyId);
			{
				return travelAgency;
			}
		}
		return null;
	}
		
	
	public void deleteAllAgencyDetails() {
		
	travelAgencyRepository.deleteAll();
	 System.out.println("all agency are deleted");
}	
	

}
