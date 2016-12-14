package cz.fav.sar.server.controllers;

import java.util.ArrayList;
import java.util.List;

import cz.fav.sar.server.dao.CompanyRepository;
import cz.fav.sar.server.dao.SystemRepository;
import cz.fav.sar.server.domain.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cz.fav.sar.server.dao.PersonRepository;
import cz.fav.sar.server.domain.Person;
import cz.fav.sar.server.main.JwtUtil;
import cz.fav.sar.server.main.TokenDetails;

@RestController
public class LoginController {

	@Autowired private PersonRepository peopleRepo;

	@Autowired private PasswordEncoder passwordEncoder;
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private SystemRepository systemRepository;


	@RequestMapping(value = "/login", method = RequestMethod.POST)
	private LoginResult login(@RequestBody LoginRequest body) {
		Person person = peopleRepo.findByEmail(body.getUsername());
		if (person == null) {
			LoginResult result = new LoginResult();
			result.setStatus("Wrong username or password");
			return result;
		}
		
		if (! passwordEncoder.matches(body.getPassword(), person.getPasswordHash())) {
			LoginResult result = new LoginResult();
			result.setStatus("Wrong username or password");
			return result;
		}

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("USER"));
		long expires = System.currentTimeMillis() + 1000 * 60 * 30;

		TokenDetails det = new TokenDetails(person.getEmail().trim(), expires, person.getId().intValue(), authorities);
		String token = JwtUtil.generateToken(det);

		LoginResult result = new LoginResult();
		result.setStatus("OK");
		result.setExpires(expires);
		result.setToken(token);
		result.setUserId(person.getId().intValue());
		result.setUsername(person.getEmail().trim());
		createBulk(result);
		return result;

	}

	public void createBulk(LoginResult res){
		res.setCompanyList(companyRepository.findAll());
		res.setSystemList(systemRepository.findAll());
	}

	
	public static class LoginResult {

		private String status;
		
		private String username;
		private int userId;
		private String token;
		private long expires;
		private Iterable<Company> companyList;
		private Iterable<cz.fav.sar.server.domain.System> systemList;
		
		public String getStatus() {
			return status;
		}
		
		public void setStatus(String status) {
			this.status = status;
		}
		
		public String getUsername() {
			return username;
		}
		
		public long getExpires() {
			return expires;
		}
		
		public String getToken() {
			return token;
		}
		
		public int getUserId() {
			return userId;
		}
		
		public void setExpires(long expires) {
			this.expires = expires;
		}
		
		public void setToken(String token) {
			this.token = token;
		}
		
		public void setUserId(int userId) {
			this.userId = userId;
		}
		
		public void setUsername(String username) {
			this.username = username;
		}

		public Iterable<Company> getCompanyList() {
			return companyList;
		}

		public void setCompanyList(Iterable<Company> companyList) {
			this.companyList = companyList;
		}

		public Iterable<cz.fav.sar.server.domain.System> getSystemList() {
			return systemList;
		}

		public void setSystemList(Iterable<cz.fav.sar.server.domain.System> systemList) {
			this.systemList = systemList;
		}
	}

	public static class LoginRequest {

		private String username;
		private String password;
		
		public String getPassword() {
			return password;
		}
		
		public String getUsername() {
			return username;
		}

	}

}
