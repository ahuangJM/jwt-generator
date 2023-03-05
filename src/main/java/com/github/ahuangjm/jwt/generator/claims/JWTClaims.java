package com.github.ahuangjm.jwt.generator.claims;

import lombok.Data;
import sun.util.calendar.ZoneInfo;

import java.util.Locale;
import java.util.Map;

@Data
public abstract class JWTClaims implements RegisteredClaims, PublicClaims, PrivateClaims {
    private String sub;
    private String iss;
    private String aud;
    private Long exp;
    private Long iat;

    private String azp;
    private String email;
    private Boolean emailVerified;
    private ZoneInfo zoneInfo;
    private Locale locale;
    private String sid;
    private String csrf;

    private Map<String, String> unknownClaims;
}
