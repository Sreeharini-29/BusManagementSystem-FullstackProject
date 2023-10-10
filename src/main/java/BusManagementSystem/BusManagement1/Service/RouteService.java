package BusManagementSystem.BusManagement1.Service;

import java.util.List;
import java.util.Optional;

import BusManagementSystem.BusManagement1.Model.Route;

public interface RouteService {
	
	Route saveBusRoute(Route route) throws Exception;
	Optional<Route> getBusRoutesByrouteId(int routeId);
	void deleteBusRoutesById(int routeId);
	List<Route> getAllBusRouteDetails() throws Exception;
	Route updateBusRouteByrouteId(int routeId,Route busdetails);
}

