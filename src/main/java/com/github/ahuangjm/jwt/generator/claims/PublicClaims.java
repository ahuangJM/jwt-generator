package com.github.ahuangjm.jwt.generator.claims;

import sun.util.calendar.ZoneInfo;

import java.util.Locale;

public interface PublicClaims {
    String getAzp();
    void setAzp(final String azp);
    String getEmail();
    void setEmail(final String email);
    Boolean getEmailVerified();
    void setEmailVerified(final Boolean emailVerified);
    ZoneInfo getZoneInfo();
    void setZoneInfo(final ZoneInfo zoneInfo);
    Locale getLocale();
    void setLocale(final Locale locale);
    String getSid();
    void setSid(final String sid);
    String getCsrf();
    void setCsrf(final String csrf);
}
