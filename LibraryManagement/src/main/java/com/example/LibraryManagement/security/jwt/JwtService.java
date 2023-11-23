package com.example.LibraryManagement.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtService {
    public static final int tokenval=60*60;
    public static final String SCREAT_KEY= "afafasfafafasfasfasfafacasdasfasxASFACASDFACASDFASFASFDAFASFASDAADSCSDFADCVSGCFVADXCcadwavfsfarvf";


 public String getUserfromtoken(String token){
     return getclaimsfromtoken(token,claims -> claims.getSubject());
 }
 public Date getExpirationDateFromToken(String token) {
        return getclaimsfromtoken(token, Claims::getExpiration);
    }
    private <T> T getclaimsfromtoken(String token , Function<Claims,T> claimsResolver){
        final Claims claims=getAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims getAllClaims(String token)
    {
     return Jwts.parserBuilder().setSigningKey(SCREAT_KEY).build().parseClaimsJws(token).getBody();
    }
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String genaratetoken(UserDetails userDetails){
        Map<String , Object> claims=new HashMap<>();
       return  Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername()).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+tokenval*1000)).signWith(SignatureAlgorithm.HS512,SCREAT_KEY)
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUserfromtoken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }



}
