package ua.com.Web_Shop.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.Web_Shop.dao.UserDao;
import ua.com.Web_Shop.entity.User;

@Component("userValidator")
public class UserValidator implements Validator{

	@Autowired
	private UserDao userdao;
	
	public void validator(Object object) throws Exception {
		User user = (User) object;
		
		if(user.getFirstName().isEmpty()){
			throw new UserValidatorException(UserValidationMessages.EMPTY_USERNAME_FIELD);
		}
		if(userdao.findByfirstName(user.getFirstName()) != null){
			throw new UserValidatorException(UserValidationMessages.NAME_ALREADY_EXIST);
		}
		if(userdao.userExistsByEmail(user.getEmail())){
			throw new UserValidatorException(UserValidationMessages.EMAIL_ALREADY_EXIST);
		}
		if(user.getEmail().isEmpty()){
			throw new UserValidatorException(UserValidationMessages.EMPTY_EMAIl_FIELD);
		}
		if(user.getPassword().isEmpty()){
			throw new UserValidatorException(UserValidationMessages.EMPTY_PASSWORD_FIELD);
		}
		if(user.getContacts().isEmpty()){
			throw new UserValidatorException(UserValidationMessages.EMPTY_PHONE_FIELD);
		}
		

	}

}
