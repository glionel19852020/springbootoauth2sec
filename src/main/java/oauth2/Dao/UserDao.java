package oauth2.Dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import oauth2.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {

	User findByUsername(String userId);
}
