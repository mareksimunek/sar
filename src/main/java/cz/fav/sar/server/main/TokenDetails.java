package cz.fav.sar.server.main;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public class TokenDetails {
	
	private final String username;
	private final long expires;
	private final int userId;
	private final List<GrantedAuthority> authorities;
	
	public TokenDetails(String username, long expires, int userId, List<GrantedAuthority> authorities) {
		super();
		this.username = username;
		this.expires = expires;
		this.userId = userId;
		this.authorities = authorities;
	}
	
	public String getUsername() {
		return username;
	}
	
	public long getExpires() {
		return expires;
	}
	
	public int getUserId() {
		return userId;
	}
	
	
	public List<GrantedAuthority> getAuthorities() {
		return authorities;
	}

}
