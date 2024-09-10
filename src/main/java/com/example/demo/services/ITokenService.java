package com.example.demo.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.models.User;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public interface ITokenService {
    public String generateToken(User user);
    public String validateToken(String token);
    private Instant generateExpirationDate() {
        return null;
    }
}
