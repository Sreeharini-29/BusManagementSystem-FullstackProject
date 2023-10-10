package BusManagementSystem.BusManagement1.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import BusManagementSystem.BusManagement1.Model.Feedback;
@Service
public interface FeedbackService {
public Feedback addFeedBack(Feedback feedBack,Integer bus_id, Integer userId) throws Exception;
	

	public Feedback deleteFeedBack(Integer feedbackId) throws Exception;

	public Feedback viewFeedback(Integer bus_id) throws Exception;

	public List<Feedback> viewFeedbackAll() throws Exception ;
	
}
