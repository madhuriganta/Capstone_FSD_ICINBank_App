package com.madhuri.icinbank.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.madhuri.icinbank.model.Admin;
import com.madhuri.icinbank.model.User;
import com.madhuri.icinbank.service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;

	
	@PostMapping("/registerUser")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmail =user.getEmail();
		if(tempEmail != null && !"".equals(tempEmail)) {
			User userObj=userService.fetchUserByEmail(tempEmail);
			if(userObj!=null) {
				throw new Exception("user with "+ tempEmail + " is already exist");
			}
		}  
		User userObj =null;
		System.out.println("user added properly!");
		userObj=userService.saveUser(user);
		return userObj;
		
	}
	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception
	{
		String tempUser=user.getUsername();
		String temppass=user.getPassword();
		User userObj=null;
		if(tempUser != null && temppass != null)
		{
			userObj=userService.fetchUserByUsernameAndPassword(tempUser, temppass);
			
		}
		if(userObj==null) {
			throw new Exception("Bad credentials");
		}
		return userObj;
	}
	@PostMapping("/admin/login")
	public void doAdminLogin(@RequestBody Admin admin) throws Exception
	{
		String adminUsername = admin.getUsername();
		String adminPassword = admin.getPassword();
		
		if(adminUsername.equals("admin") && adminPassword.equals("admin"))
		{
			System.out.println("admin successfully login");
		}
		else
		{
			throw new Exception("credentials are wrong");
		}
		
		
	}
	
	@GetMapping("/getuser/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) throws Exception{
		
//			return new ResponseEntity<>(userService.fetchUserById(id),HttpStatus.OK);
		try {
			return new ResponseEntity<>(userService.fetchUserById(id),HttpStatus.OK);
		}catch(Exception ex)
		{
			throw new Exception("user not found for "+id);
		}
		
	}
	
	
	
	
//	@PostMapping("/home" )
//	public List<Object> getHome(@RequestBody String email) {
//		List<Object> accounts = new ArrayList<Object>();
//		 User user1 = userService.fetchUserByEmail(email);
//		System.out.println(user1);
//        //model.addAttribute("savingsAccount", savingsAccount);
//		PrimaryAccount primaryAccount = user1.getPrimaryAccount();
//	    SavingsAccount savingsAccount = user1.getSavingsAccount();
//	    //System.out.println(savingsAccount);
//	    accounts.add(savingsAccount);
//	    accounts.add(primaryAccount);
//	    return accounts;
//    }


}
