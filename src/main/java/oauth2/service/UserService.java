package oauth2.service;

import java.util.List;

import oauth2.model.User;

public interface UserService {
	
	User save(User user);
    List<User> findAll();
    void delete(long id);

}
