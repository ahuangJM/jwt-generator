package com.github.ahuangjm.jwt.generator.claims;

import lombok.Data;

@Data
public class RegisteredClaims {
    private String sub;
    private String iss;
    private String aud;
    private Long exp;
    private Long iat;
}
