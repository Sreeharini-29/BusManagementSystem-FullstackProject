package BusManagementSystem.BusManagement1.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import BusManagementSystem.BusManagement1.Model.Bus;

//service interface is created
@Service
public interface BusService {
		Bus saveBus(Bus busObj);
		List<Bus>fetchbusesFromDb();
		Bus getBusdetailsById(int busId);
		Bus updateBusdetailsById(Bus busObj, int busId);
		Optional<Bus> deleteBusdetailsById(int busId);
		void deleteallBusdetails();
		
	}

