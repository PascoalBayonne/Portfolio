package ua.com.Web_Shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.Web_Shop.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

	User findByfirstName(String firstName);

	// @Query("SELECT CASE WHEN COUNT(u)> 0 THEN true ELSE false END FROM User u
	// WHERE ")

	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.firstName =:firstName")
	boolean userExistsByName(@Param("firstName") String firstName);

	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.email =:email")
	boolean userExistsByEmail(@Param("email") String email);

	@Query("select u from User u where u.uuid =:uuid")
	User findByUUID(@Param("uuid") String uuid);

	@Query("select u from User u left join fetch u.products where u.id =:id")
	User fetchuserWithProducts(@Param("id") int id);
}
