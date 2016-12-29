package ua.com.Web_Shop.ServiceImpl;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.cache.NullUserCache;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ua.com.Web_Shop.Service.UserService;
import ua.com.Web_Shop.Validator.Validator;
import ua.com.Web_Shop.dao.ProdcutDao;
import ua.com.Web_Shop.dao.UserDao;
import ua.com.Web_Shop.entity.User;
import ua.com.Web_Shop.entity.Product;
import ua.com.Web_Shop.entity.Role;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	@Qualifier("userValidator")
	private Validator validator;

	@Autowired
	private UserDao userDao;

	@Autowired
	private ProdcutDao productdao;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public void save(User user) throws Exception {
		validator.validator(user);
		user.setRole(Role.ROLE_USER);
		user.setPassword(encoder.encode(user.getPassword()));
		userDao.save(user);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public User findOne(int id) {
		return userDao.findOne(id);
	}

	public void delete(int id) {
		userDao.delete(id);
	}

	public UserDetails loadUserByUsername(String firstName) throws UsernameNotFoundException {
		return userDao.findByfirstName(firstName);
	}

	public User findByfirstName(String firstName) {
		return userDao.findByfirstName(firstName);
	}

	@Transactional
	public void saveImage(Principal principal, MultipartFile multipartFile) {

		User user = userDao.findOne(Integer.parseInt(principal.getName()));

		String path = System.getProperty("catalina.home") + "/resources/" + user.getFirstName() + "/"
				+ multipartFile.getOriginalFilename();

		user.setPathImage("resources/" + user.getFirstName() + "/" + multipartFile.getOriginalFilename());

		File file = new File(path);

		try {
			file.mkdirs();
			try {
				FileUtils.cleanDirectory(
						new File(System.getProperty("catalina.home") + "/resources/" + user.getFirstName() + "/"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			multipartFile.transferTo(file);
		} catch (IOException e) {
			System.out.println("error with file");
		}
	}

	@Override
	public User findByUUID(String uuid) {

		return userDao.findByUUID(uuid);
	}

	@Override
	public void update(User user) {
		userDao.saveAndFlush(user);

	}

	@Override
	public User fetchuserWithProducts(int id) {
		return userDao.fetchuserWithProducts(id);
	}

	@Override
	public Cookie intoBasket(int id, HttpServletRequest request, HttpServletResponse response) {
		request.getSession(false);
		Product product = productdao.findOne(id);

		Cookie cookiePorduct = new Cookie(product.getProduct_Name(), String.valueOf(product.getId()));
		cookiePorduct.setMaxAge(24 * 60 * 60 * 60);// ---------------------------------->
													// I don't understand
		cookiePorduct.setHttpOnly(true);
		cookiePorduct.setPath("/");

		response.addCookie(cookiePorduct);
		return cookiePorduct;

	}

	@Override
	public List<Product> userProductsCookie(HttpServletRequest request) {
		request.getSession(false);
		List<Product> products = new ArrayList<>();
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("JSESSIONID")) {

			} else {
				products.add(productdao.findOne(Integer.parseInt(cookie.getValue())));
			}
		}
		return products;

	}

	@Transactional
	public void getOrder(Principal principal, String id, Cookie[] cookies, HttpServletResponse response) {

		User user = userDao.fetchuserWithProducts(Integer.parseInt(principal.getName()));
		Product product = productdao.findOne(Integer.parseInt(id));
		user.getProducts().add(product);

		sortCookie(cookies, id, response);
	}

	@Override
	public void deleteCookieFromOrder(String id, HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		sortCookie(cookies, id, response);

	}

	@Transactional
	@Override
	public void join(int idUser, int idProduct) {
		User user = userDao.findOne(idUser);
		Product product = productdao.findOne(idProduct);

		user.getProducts().add(product);

	}

	public void sortCookie(Cookie[] cookies, String id, HttpServletResponse response) {
		for (int i = 0; i < cookies.length; i++) {
			if (id.equals(cookies[i].getValue())) {
				Cookie cookie = new Cookie(cookies[i].getName(), null);
				cookie.setHttpOnly(true);
				cookie.setPath("/");
				cookie.setValue(null);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
	}

	@Override
	public void buyProduct(Principal principal, String id) {
		User user = userDao.findOne(Integer.parseInt(principal.getName()));
		Product product = productdao.findOne(Integer.parseInt(id));
		user.getProducts().add(product);

	}

	@Override
	public int totalPrice(int id) {
		User user = userDao.fetchuserWithProducts(id);
		int i =0;
		for(Product product : user.getProducts()){
			i+=product.getPrice();
		}
		return i;
	}

	@Override
	public void deleteProductFromUser(int id, String productId) {
		
		User user = userDao.fetchuserWithProducts(id);

		Product product = productdao.findOne(Integer.parseInt(productId));

		for (Product product2 : user.getProducts()) {
			if (product2.getId() == product.getId()) {
				user.getProducts().remove(product2);
				return;
			}

		}

	}

}
