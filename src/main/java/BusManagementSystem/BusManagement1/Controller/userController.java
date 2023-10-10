package BusManagementSystem.BusManagement1.Controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import BusManagementSystem.BusManagement1.Model.Feedback;
import BusManagementSystem.BusManagement1.Model.User;
import BusManagementSystem.BusManagement1.ServiceImplementation.userServiceImpl;
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/busmanagement.com")
public class userController {
	@Autowired
	private userServiceImpl userService;

	@GetMapping("/login")
	public ResponseEntity<Map<String,String>> login(@RequestParam("email") String email,@RequestParam("password") String password)
	{
		Optional<User> existingUser=this.userService.getUserByEmail(email);
		Map<String,String> response=new HashMap<String,String>();
		if(existingUser.isPresent())
		{
			if(existingUser.get().getUserPassword().equals(password))
			{
				response.put("status", "success");
				response.put("message", "User authenticated");
				response.put("userId",String.valueOf( existingUser.get().getUserId()) );
				response.put("userRole", existingUser.get().getRole());
				response.put("userName", existingUser.get().getUserName());
				return new ResponseEntity<Map<String,String>>(response,HttpStatus.OK);
			}
			else
			{
				response.put("status", "Failed");
				response.put("message", "User password inncorrect");
				return new ResponseEntity<Map<String,String>>(response,HttpStatus.NOT_FOUND);
			}
		}		
		else
		{
			response.put("status", "Failed");
			response.put("message", "User email does not exist");
			return new ResponseEntity<Map<String,String>>(response,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/signup")
	public ResponseEntity<Map<String,String>> signup(@RequestBody User user)
	{
		this.userService.addUser(user);
		Map<String,String> response=new HashMap<String,String>();
		response.put("status", "success");
		response.put("message", "User registered!!");
		
		return new ResponseEntity<Map<String,String>>(response,HttpStatus.CREATED);
	}
	@GetMapping("/getalluserdetails")
	public List<User> readAllUsers(){
		
		return userService.getAllUser();
		
	}
	@GetMapping("/getUserdetailsById/{userId}")
public ResponseEntity<User> viewUser(@PathVariable("userId") Integer userId) {
		
		User user = userService.viewUser(userId);
		
		return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
		
	}

}
