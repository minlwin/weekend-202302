package com.jdc.balance.utils.security;

import java.util.Calendar;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtTokenProvider {
	
	@Value("${jdc.balance.jwt.issuer}")
	private String issuer;
	@Value("${jdc.balance.jwt.life}")
	private int life;
	
	private SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	private static final String AUTH_KEY = "rol";
	private static final String TOKEN_HEADER = "Bearer:";

	public Authentication authenticate(String token) {
		
		try {
			if(StringUtils.hasLength(token)) {
				var parser = Jwts.parserBuilder().requireIssuer(issuer).setSigningKey(key).build();
				var tokenValue = token.substring(TOKEN_HEADER.length());
				
				var jws = parser.parseClaimsJws(tokenValue);
				
				var username = jws.getBody().getSubject();
				var authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(jws.getBody().get(AUTH_KEY).toString());
				
				return UsernamePasswordAuthenticationToken.authenticated(username, null, authorities);
			}
		} catch (Exception e) {
			// Nothing To Do for Invalid Token
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String generate(Authentication authentication) {
		
		if(null != authentication && authentication.isAuthenticated()) {
			var builder = Jwts.builder().signWith(key);
			
			var username = authentication.getName();
			var authorities = authentication.getAuthorities().stream()
					.map(a -> a.getAuthority()).collect(Collectors.joining(","));
			
			var now = Calendar.getInstance();
			
			builder.setSubject(username);
			builder.setIssuer(issuer);
			builder.setIssuedAt(now.getTime());
			
			now.add(Calendar.MINUTE, life);
			builder.setExpiration(now.getTime());
			builder.claim(AUTH_KEY, authorities);
			
			return String.format("%s%s", TOKEN_HEADER, builder.compact());
		}
		
		return null;
	}
}
