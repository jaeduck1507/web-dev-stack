package com.kh.security.config;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.kh.security.model.vo.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class TokenProvider {

	private final SecretKey secretkey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	
	public String create(User user) {
		return Jwts.builder()
				.signWith(secretkey, SignatureAlgorithm.HS512)
				.setClaims(Map.of(
							"id",user.getId(),
							"name",user.getName(),
							"role", user.getRole()
						))
				.setIssuedAt(new Date())
				.setExpiration(Date.from(Instant.now().plus(1,ChronoUnit.DAYS)))
				.compact();
	}
	
	public User validate(String token) {
		Claims claims = Jwts
				.parserBuilder()
				.setSigningKey(secretkey)
				.build()
				.parseClaimsJws(token)
				.getBody();
		return User.builder()
				.id((String)claims.get("id"))
				.name((String)claims.get("name"))
				.role((String)claims.get("role"))
				.build();
	}
}
