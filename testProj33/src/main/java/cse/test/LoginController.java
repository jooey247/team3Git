package cse.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	@Autowired
	private UserReposit userRepository;

	@RequestMapping(value="/login/{id}")
	public @ResponseBody User login(@PathVariable String id)
	{
		if(userRepository.findOne(id) != null)
		{
			System.out.println("==============login success==============");			
		}
		else
		{
			System.out.println("==============login fail==============");
		}
		return userRepository.findOne(id);
			
	}
}
