package ua.com.Web_Shop.dto;

import java.util.ArrayList;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;

import ua.com.Web_Shop.entity.User;

public class DTOUtilMapper {
	public static List<UserDTO> userToUserDTO(List<User>users){
		
		List<UserDTO> userDTOs = new ArrayList<>();
		
		for (User user : users) {
			UserDTO userDTO = new UserDTO();
			userDTO.setFirstName(user.getFirstName());
			userDTO.setLastName(user.getLastName());
			userDTO.setEmail(user.getEmail());
			userDTO.setId(user.getId());
			
			userDTOs.add(userDTO);
		}
		return userDTOs;
	}
	

}
