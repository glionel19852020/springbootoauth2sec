package oauth2.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import oauth2.model.User;
import oauth2.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userService = userService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
    
    

    @RequestMapping(value="/user", method = RequestMethod.GET)
    public List<User> listUser(){
        return userService.findAll();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User create(@RequestBody User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    	return userService.save(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") Long id){
        userService.delete(id);
        return "success";
    }
	
}
