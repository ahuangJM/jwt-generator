package com.github.ahuangjm.jwt.generator.claims;

public interface RegisteredClaims {
    String getSub();
    void setSub(final String sub);
    String getIss();
    void setIss(final String iss);
    String getAud();
    void setAud(final String aud);
    Long getExp();
    void setExp(final Long exp);
    Long getIat();
    void setIat(final Long iat);
}
