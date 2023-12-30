package com.example.demo.config.security.managers;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.example.demo.config.security.providers.CustomAuthenticationProvider;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {
	
	private final CustomAuthenticationProvider customAuthenticationProvider;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		if(customAuthenticationProvider.supports(authentication.getClass())) {
			 return customAuthenticationProvider.authenticate(authentication);
		}
		throw new AuthenticationCredentialsNotFoundException("oh not ");
	}

}
