package cz.fav.sar.server.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cz.fav.sar.server.main.JwtUtil;
import cz.fav.sar.server.main.TokenDetails;

@RestController
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	private LoginResult login(@RequestBody LoginRequest body) {
		// TODO check DB
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("USER"));
		
		long expires = System.currentTimeMillis() + 1000 * 60 * 5; 
		
		TokenDetails det = new TokenDetails(body.username, expires, 1, authorities);
		String token = JwtUtil.generateToken(det);

		LoginResult result = new LoginResult();
		result.expires = expires;
		result.token = token;
		result.userId = 1;
		result.username = body.username;
		return result;
	}
	
	public static class LoginResult {
		
		public String username;
		public int userId;
		public String token;
		public long expires;
		
	}
	
	public static class LoginRequest {
		
		public String username;
		public String password;
		
	}
	

	
}
