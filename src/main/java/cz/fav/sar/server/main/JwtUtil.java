package cz.fav.sar.server.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {

	public static TokenDetails parseToken(String token) {
		try {
			Claims body = Jwts.parser()
					.setSigningKey(DBConfig.JWT_SECRET)
					.parseClaimsJws(token)
					.getBody();

			String username = body.getSubject();
			long expires = (Long)body.get("expires");
			int userId = (Integer)body.get("userId");
			String auth = (String)body.get("authorities");
			List<GrantedAuthority> authList = new ArrayList<>();
			for (String role : auth.split(",")) {
				authList.add( new SimpleGrantedAuthority(role));
			}
			
			TokenDetails ret = new TokenDetails(username, expires, userId, authList);
			return ret;
			
		} catch (JwtException | ClassCastException e) {
			System.out.println(e);
			return null;
		}
	}

	public static String generateToken(TokenDetails tokenDeatils) {
		Claims claims = Jwts.claims().setSubject(tokenDeatils.getUsername());
		claims.put("userId", tokenDeatils.getUserId());
		claims.put("expires", tokenDeatils.getExpires());
		String auth = "";
		for (GrantedAuthority grantedAuthority : tokenDeatils.getAuthorities()) {
			auth += grantedAuthority.getAuthority() + ",";
		}
		auth = auth.substring(0, auth.length() - 1);
		claims.put("authorities", auth);

		return Jwts.builder()
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS512, DBConfig.JWT_SECRET)
				.compact();
	}

	/*
	public static void main(String[] args) {

		List<GrantedAuthority> auth = new ArrayList<>();
		auth.add(new SimpleGrantedAuthority("USER"));
		auth.add(new SimpleGrantedAuthority("ADMIN"));
		auth.add(new SimpleGrantedAuthority("TEST"));

		TokenDetails det = new TokenDetails("username", System.currentTimeMillis(), 1, auth);
		String token = generateToken(det);
		System.out.println(token);
		
		TokenDetails detail = parseToken(token);
		
		System.out.println(detail.getExpires() + "");
		System.out.println(detail.getUserId());
		System.out.println(detail.getUsername());
		System.out.println(detail.getAuthorities());
		
	}
	*/
}