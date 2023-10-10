package BusManagementSystem.BusManagement1.ServiceImplementation;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BusManagementSystem.BusManagement1.Model.Feedback;
import BusManagementSystem.BusManagement1.Model.User;
import BusManagementSystem.BusManagement1.Repository.userRepository;
@Service
public class userServiceImpl {
	@Autowired
	private userRepository userRepository;
	

	public void addUser(User user) {
		
		this.userRepository.save(user);
		
	}

	public Optional<User> getUserByEmail(String email) {
		
		return this.userRepository.findByuserEmail(email);
		
	}
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	public User viewUser(Integer userId ) {
		Optional<User> user =  userRepository.findById(userId);  //null , or it can 5tg person rec
		if(user.isPresent()) {
			return user.get();
		}
		else {
			return null;
		}
	}
}
