package BusManagementSystem.BusManagement1.Controller;
import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import BusManagementSystem.BusManagement1.Model.Feedback;
import BusManagementSystem.BusManagement1.ServiceImplementation.FeedbackServiceImpl;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/busmanagement.com")

public class FeedbackController {
	@Autowired
	private FeedbackServiceImpl feedbackService;
	
	@PostMapping("/add/{busId}/{userId}")
	public ResponseEntity<Feedback> addFeedback(@Valid @RequestBody Feedback feedback,
												@PathVariable("busId") Integer busId,@PathVariable("userId") Integer userId) throws Exception {
		
		Feedback feedback2 = feedbackService.addFeedBack(feedback,busId,userId);
		
		return new ResponseEntity<Feedback>(feedback2,HttpStatus.ACCEPTED);
		
	}
@DeleteMapping("feedback/delete/{feedbackId}")
	public ResponseEntity<Feedback> deleteFeedback(@PathVariable("feedbackId") Integer feedbackId){
		Feedback feedback2 = feedbackService.deleteFeedBack(feedbackId);
		
		return new ResponseEntity<Feedback>(feedback2,HttpStatus.ACCEPTED);
		
	}
//	viewFeedback
	
	@GetMapping("/feedback/{feedbackId}")
	public ResponseEntity<Feedback> viewFeedback(@PathVariable("feedbackId") Integer feedbackId) {
		
		Feedback feedback2 = feedbackService.viewFeedback(feedbackId);
		
		return new ResponseEntity<Feedback>(feedback2,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/feedback/all")
	public ResponseEntity<List<Feedback>> viewFeedbackAll()  {
		
		List<Feedback> feedback2 =  feedbackService.viewFeedbackAll();
		
		return new ResponseEntity<List<Feedback>>(feedback2,HttpStatus.ACCEPTED);
		
	}
	
}
