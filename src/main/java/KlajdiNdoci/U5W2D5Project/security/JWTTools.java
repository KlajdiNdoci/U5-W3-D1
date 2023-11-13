package KlajdiNdoci.U5W2D5Project.security;

import KlajdiNdoci.U5W2D5Project.entities.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class JWTTools {
    @Value("${spring.jwt.secret}")
    private String secret;

    public String createToken(User user){
        return Jwts.builder().setSubject(String.valueOf(user.getId()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 1000 * 60 * 60 * 24 * 7))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes())).compact();
    }
}
