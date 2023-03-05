package com.github.ahuangjm.jwt.generator.claims;

import lombok.Data;

import java.util.Locale;
import java.util.TimeZone;

@Data
public class PublicClaims {
    private String azp;
    private String email;
    private Boolean emailVerified;
    private TimeZone zoneInfo;
    private Locale locale;
    private String sid;
    private String csrf;
}
