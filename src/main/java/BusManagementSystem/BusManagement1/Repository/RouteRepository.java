package BusManagementSystem.BusManagement1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import BusManagementSystem.BusManagement1.Model.Route;
@Repository
public interface RouteRepository extends JpaRepository<Route,Integer> {
	public Route findByRouteFromAndRouteTo(String routeFrom, String routeTo);
}
