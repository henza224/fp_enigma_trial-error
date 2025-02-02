package saham_ku.saham_ku.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.stream.Collectors;

import static io.jsonwebtoken.Jwts.parserBuilder;

@Component
public class JwtTokenProvider {
    @Value("@{app.jwtSecret}")
    private String jwtSecret;
    @Value("@{app.jwtExpirationInMS}")
    private Long jwtExpirationInMS;
    private final Key key;

    public JwtTokenProvider(@Value("${app.jwtSecret}")String jwtSecret){
        this.key= Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }
    public String generateToken(Authentication auth){
        String username = auth.getName();
        String roles = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMS);

        return Jwts.builder()
                .setSubject(username)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(key)
                .compact();
    }

<<<<<<< HEAD
}

=======
    public String getUsernameFromJWT(String token){
        Claims claims = parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;

        }catch (JwtException | IllegalArgumentException e){
            return false;
        }
    }
}


>>>>>>> 7c0e95d5b695bae0b357b8f75a4f46215c0def43
