package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.config.security.filters.CustomAuthenticationFilter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
public class ProjectConfig {

	private final CustomAuthenticationFilter customAuthenticationFilter;
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		return http.addFilterAt(customAuthenticationFilter,UsernamePasswordAuthenticationFilter.class)
					.authorizeHttpRequests(Customizer.withDefaults())
				    .build();
	}
}
