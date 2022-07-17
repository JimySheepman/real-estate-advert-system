package com.example.authservice.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.authservice.models.UsernameAndRole;
import org.springframework.stereotype.Service;

@Service
public class JwtUtil {

    public UsernameAndRole getUserAndRoleFromToken(String token){
        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        String username = decodedJWT.getSubject();
        Claim rolesClaim = decodedJWT.getClaim("roles");
        String[] roles = rolesClaim.asArray(String.class);

        return  UsernameAndRole
                .builder()
                .username(username)
                .role((roles.length >0) ? roles[0]: "")
                .build();
    }
}
