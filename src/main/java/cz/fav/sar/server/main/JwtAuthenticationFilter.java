package cz.fav.sar.server.main;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String header = request.getHeader("Authorization");

		if (header == null || !header.startsWith("Bearer ")) { throw new JwtAuthenticationException("No JWT token found in request headers"); }

		String authToken = header.substring(7);
		TokenDetails tokenDetails = JwtUtil.parseToken(authToken);
		if (tokenDetails == null) { throw new JwtAuthenticationException("Invalid JWT token found in request headers"); }

		if (tokenDetails.getExpires() > System.currentTimeMillis()) {
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(tokenDetails.getUserId() + "", null, tokenDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		else {
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		request.setAttribute("user", tokenDetails.getUserId());
		filterChain.doFilter(request, response);
	}

	public static class JwtAuthenticationException extends AuthenticationException {

		public JwtAuthenticationException(String msg) {
			super(msg);
		}

		private static final long serialVersionUID = 1135451085927040858L;

	}
}