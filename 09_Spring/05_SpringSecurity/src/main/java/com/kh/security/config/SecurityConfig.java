package com.kh.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(csrf -> csrf.disable()) // 웹 보안 토큰 설정 (비활성화)
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers("/mypage").authenticated()
						.requestMatchers("/admin").hasRole("ADMIN")
						.anyRequest().permitAll()
				)
				.formLogin(form -> 
				form.loginPage("/login")
					.defaultSuccessUrl("/mypage")
					
					
					
				)
				.logout(logout -> 
					logout.logoutUrl("/logout")
						.logoutSuccessUrl("/")
				)
				.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
