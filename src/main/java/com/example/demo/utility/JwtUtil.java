package com.example.demo.utility;



import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
public class JwtUtil {

    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String generateJwt(String nome,String cognome,String email) {
        // Set the expiration time for the token
        long expirationTimeMillis = 3600000; // 1 hour
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTimeMillis);

        // Create the JWT with the specified claim
        return Jwts.builder()
                .setSubject("user") // You can set the subject (optional)
                .claim("nome", nome)
                .claim("cognome",cognome)
                .claim("email",email)// Add the custom claim
                .setIssuedAt(new Date()) // Set the issued date
                .setExpiration(expirationDate) // Set the expiration date
                .signWith(key) // Sign the token with the secret key
                .compact(); // Compact the JWT into a URL-safe string
    }

    public static Key getKey() {
        return key;
    }

}
