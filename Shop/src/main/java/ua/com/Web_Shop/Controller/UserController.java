package ua.com.Web_Shop.Controller;

import java.security.Principal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ua.com.Web_Shop.dto.DTOUtilMapper;
import ua.com.Web_Shop.Service.MailSenderService;
import ua.com.Web_Shop.Service.UserService;
import ua.com.Web_Shop.entity.User;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private MailSenderService mailsenderService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String User(Model model) {
		model.addAttribute("UserDTOs", DTOUtilMapper.userToUserDTO(userService.findAll()));
		model.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	private String saveUser(@ModelAttribute User user, Model model) {
		String uuid = UUID.randomUUID().toString();
		user.setUuid(uuid);

		try {
			userService.save(user);

		} catch (Exception e) {
			model.addAttribute("exception", e.getMessage());
			return "register";
		}

		String theme = "thanks for registration";
		String mailBody = "gl & hf      http://localhost:8080/Shop/confirm/" + uuid;
		mailsenderService.sendMail(theme, mailBody, user.getEmail());

		return "redirect:/";
	}

	@RequestMapping(value = "/confirm/{uuid}", method = RequestMethod.GET)
	public String confirm(@PathVariable String uuid) {
		System.out.println(uuid);
		User user = userService.findByUUID(uuid);
		user.setEnabled(true);
		userService.update(user);
		return "redirect:/index";
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	public String City(@PathVariable String id) {
		userService.delete(Integer.parseInt(id));
		return "redirect:/register";
	}

	@RequestMapping(value = "/saveImage", method = RequestMethod.POST)
	public String saveImage(Principal principal, @RequestParam MultipartFile image) {

		userService.saveImage(principal, image);

		return "redirect:/profile";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(Principal principal, Model model) {

		User user = userService.findOne(Integer.parseInt(principal.getName()));
		// User user =
		// userService.fetchUserWithBook(Integer.parseInt(principal.getName()));

		model.addAttribute("user", user);

		return "profile";
	}
	

	@RequestMapping(value = "joinUserWithProduct/{idProduct}", method = RequestMethod.PUT)
	private String join(Principal principal, @PathVariable String idProduct) {

		userService.join(Integer.parseInt(principal.getName()), Integer.parseInt(idProduct));

		return null;
	}
}
