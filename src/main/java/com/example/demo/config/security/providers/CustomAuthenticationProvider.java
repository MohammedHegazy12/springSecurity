package com.example.demo.config.security.providers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.example.demo.config.security.authentication.CustomAuthentication;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

	@Value("$(our.very.very.very.secret.key=secret)")
	private String key;
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		CustomAuthentication customAuthentication=(CustomAuthentication)authentication;
		String headerKey=customAuthentication.getKey();
		
		if(key.equals(headerKey)) {
			CustomAuthentication result=new CustomAuthentication(true, null);
			return result;
		}
	 
			throw new BadCredentialsException("oh No");
		 
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return CustomAuthentication.class.equals(authentication);
	}

}
