package com.github.ahuangjm.jwt.generator.jwt;

import com.github.ahuangjm.jwt.generator.claims.JWTClaimNames;
import com.github.ahuangjm.jwt.generator.claims.JWTClaims;
import com.nimbusds.jwt.JWTClaimsSet;

public abstract class JWTClaimSetBuilder<T extends JWTClaims> {
    private T jwtClaims;

    public JWTClaimSetBuilder<T> jwtClaims(final T jwtClaims) {
        this.jwtClaims = jwtClaims;
        return this;
    }

    public JWTClaimsSet build() {
        return this.buildInternal().build();
    }

    JWTClaimsSet.Builder buildInternal() {
        return new JWTClaimsSet.Builder()
                .claim(JWTClaimNames.Public.AZP, this.jwtClaims.getAzp())
                .claim(JWTClaimNames.Public.CSRF, this.jwtClaims.getCsrf())
                .claim(JWTClaimNames.Public.SID, this.jwtClaims.getSid())
                .claim(JWTClaimNames.Public.EMAIL, this.jwtClaims.getEmail())
                .claim(JWTClaimNames.Public.EMAIL_VERIFIED, this.jwtClaims.getEmailVerified())
                .claim(JWTClaimNames.Public.LOCALE, this.jwtClaims.getLocale())
                .claim(JWTClaimNames.Public.ZONEINFO, this.jwtClaims.getZoneInfo())
                .claim(JWTClaimNames.Registered.IAT, this.jwtClaims.getIat())
                .claim(JWTClaimNames.Registered.AUD, this.jwtClaims.getAud())
                .claim(JWTClaimNames.Registered.EXP, this.jwtClaims.getExp())
                .claim(JWTClaimNames.Registered.ISS, this.jwtClaims.getIss())
                .claim(JWTClaimNames.Registered.SUB, this.jwtClaims.getSub());
    }
}
