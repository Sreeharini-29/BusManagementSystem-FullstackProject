package BusManagementSystem.BusManagement1.ServiceImplementation;

//import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BusManagementSystem.BusManagement1.Model.Bus;
import BusManagementSystem.BusManagement1.Model.Feedback;
import BusManagementSystem.BusManagement1.Model.User;
import BusManagementSystem.BusManagement1.Repository.BusRepository;
import BusManagementSystem.BusManagement1.Repository.FeedbackRepository;
import BusManagementSystem.BusManagement1.Repository.userRepository;
@Service
public class FeedbackServiceImpl {
	@Autowired
	private FeedbackRepository feedbackRepo;
	@Autowired
	private BusRepository busRepository;
	@Autowired
	private userRepository userRepository;
	
	public Feedback addFeedBack(Feedback feedBack, Integer busId,Integer userId) throws Exception {
		
		Optional<Bus> busObj = busRepository.findById(busId);
		if (busObj.isEmpty()) {
			throw new Exception("Bus is not present with Id: "+ busId);
		}
		Optional<User> user = userRepository.findById(userId);//.orElseThrow(()-> new UserException("User not found!"));
		if (user.isEmpty()) {
			throw new Exception("User is not present with Id: "+ userId);
		}

		feedBack.setBusObj(busObj.get());
		feedBack.setUser(user.get());
		
		Feedback savedFeedback = feedbackRepo.save(feedBack);

		return savedFeedback;
	}

	public Feedback deleteFeedBack(Integer feedbackId) {
		Optional<Feedback>feedback  = feedbackRepo.findById(feedbackId);  
		if(feedback.isPresent()) {
			feedbackRepo.deleteById(feedbackId);
			
		}
		return null;
		}
	
	public Feedback viewFeedback(Integer feedbackId ) {
		Optional<Feedback> feedback =  feedbackRepo.findById(feedbackId);  //null , or it can 5tg person rec
		if(feedback.isPresent()) {
			return feedback.get();
		}
		else {
			return null;
		}
	}
	public List<Feedback> viewFeedbackAll() {
		return feedbackRepo.findAll();  
		
	}
}
