package BusManagementSystem.BusManagement1.ServiceImplementation;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BusManagementSystem.BusManagement1.Repository.BusRepository;
import BusManagementSystem.BusManagement1.Repository.RouteRepository;
import BusManagementSystem.BusManagement1.Service.RouteService;
import BusManagementSystem.BusManagement1.Model.Bus;
import BusManagementSystem.BusManagement1.Model.Route;
import BusManagementSystem.BusManagement1.Model.TravelAgency;
@Service
public class RouteServiceImpl implements RouteService{

	@Autowired
	private BusRepository busRepository;
	@Autowired
	private RouteRepository routeRepository;

	public RouteServiceImpl(RouteRepository routeRepository) {
		this.routeRepository = routeRepository ;	
	}
	@Override
	public Route saveBusRoute(Route route) throws Exception {
		Route newRoute = routeRepository.findByRouteFromAndRouteTo(route.getRouteFrom(), route.getRouteTo());

		if(newRoute != null) throw new Exception("Route :"+ newRoute.getRouteFrom() +" to "+ newRoute.getRouteTo()+ " is already present !");
		List<Bus> buses = new ArrayList<>();	
		buses=busRepository.findBySourceAndDestination(route.getRouteFrom(), route.getRouteTo());

		//route.setBus(buses);
		for(int ctr = 0; ctr < buses.size(); ctr++)
			if(buses.get(ctr)!=null) {
				buses.get(ctr).setRoute(route);
				
			}
		route.setBus(buses);
		return routeRepository.save(route);

	}

	@Override
	public Optional<Route> getBusRoutesByrouteId(int routeId) {
		Optional<Route> route = routeRepository.findById(routeId); 
		if(route.isPresent()) {
			return Optional.of(route.get());
		}
		else {
			return null;
		}
	}

	@Override
	public List<Route> getAllBusRouteDetails() throws Exception {
		List<Route> route=routeRepository.findAll();

		if(route.isEmpty())
			throw new Exception("No route available");
		else
			return route;             
	}
	@Override
	public Route updateBusRouteByrouteId(int routeId,Route routeObj) {
		Optional<Route> route =routeRepository.findById(routeId);
		if(route.isPresent()) {
			Route existingroute=route.get();
			
			existingroute.setDistance(routeObj.getDistance());
			existingroute.setBus(routeObj.getBus());
			routeRepository.save(existingroute);
			return existingroute;
		}
		else {
			return null;
		}
		}

		
	
		



	@Override
	public void deleteBusRoutesById(int routeId) {
		if(routeRepository.findById(routeId).get() != null) {

			routeRepository.deleteById(routeId);
		}
	}
}

