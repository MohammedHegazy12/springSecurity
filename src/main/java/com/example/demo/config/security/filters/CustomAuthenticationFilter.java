package com.example.demo.config.security.filters;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.config.security.authentication.CustomAuthentication;
import com.example.demo.config.security.managers.CustomAuthenticationManager;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CustomAuthenticationFilter  extends  OncePerRequestFilter{

	private final CustomAuthenticationManager customAuthenticationManager;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response,
			FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String key=String.valueOf(request.getHeader("key"));
		 CustomAuthentication customeAuthentication=
				 new CustomAuthentication(false, key);
		Authentication authentication=customAuthenticationManager.authenticate(customeAuthentication);
		
		if(authentication.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(authentication);
		filterChain.doFilter(request, response);
		}
	}

	 

}
