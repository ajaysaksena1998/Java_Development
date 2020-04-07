package com.Ajay.flightReservation.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Ajay.flightReservation.Repo.UserRepository;
import com.Ajay.flightReservation.models.Users;
import com.Ajay.flightReservation.services.SecurityService;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private SecurityService securityService;
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("/showReg")
	public String registerUser() {
		LOGGER.info("Inside showReg() method");
		return "login/registerUser";
	}
	
	@RequestMapping("/showLogin")
	public String LoginUser() {
		LOGGER.info("Inside showLogin() method");
		return "login/login";
	}
	
	@RequestMapping(value= "/login", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") Users user) {
		LOGGER.info("Inside register() method. Registering user "+user);
		user.setPassword(encoder.encode(user.getPassword()));
		userRepo.save(user);
		return "login/login";
	}
	
	@RequestMapping(value= "/logres", method= RequestMethod.POST)
	public String userLogin(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelMap) {
		
		LOGGER.info("Logging in user with email id "+email);
		boolean result = securityService.login(email, password);
		if(result) {
			LOGGER.info("{} successfully logged in",email);
			return "findFlights";
		}
		else {
			modelMap.addAttribute("msg","Invalid Username And Password");
		}
		LOGGER.info("{} failed to log in",email);
		return "login/login";
	}
}
