package com.github.ahuangjm.jwt.generator.claims;

import lombok.Data;

import java.util.Map;

@Data
public abstract class JWTClaims {
    private PrivateClaims privateClaims;
    private PublicClaims publicClaims;
    private RegisteredClaims registeredClaims;
    private Map<String, Object> unknownClaims;
}
