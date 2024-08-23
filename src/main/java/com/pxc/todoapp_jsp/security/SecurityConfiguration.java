package com.pxc.todoapp_jsp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		UserDetails userDetails1 = createUser("jellyfish", "jf1234", "USER");
		UserDetails userDetails2 = createUser("calamare", "cm1234", "USER");
		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
	}

	private UserDetails createUser(String username, String password, String role) {
		UserDetails userDetails = User.builder()
									.passwordEncoder(input -> encoder().encode(input))
									.username(username)
									.password(password)
									.roles(role)
									.build();
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//authorize http request. any request
		//form login, default
		//must disable csrf if unhandled
		//disable frame option
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		http.formLogin(Customizer.withDefaults());
		http.csrf(csrf -> csrf.disable());
		http.headers(headers -> headers.frameOptions(fo -> fo.disable()));
		return http.build();
	}

}
