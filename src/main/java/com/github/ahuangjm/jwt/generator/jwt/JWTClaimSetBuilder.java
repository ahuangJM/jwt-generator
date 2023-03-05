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
                .claim(JWTClaimNames.Public.AZP, this.jwtClaims.getPublicClaims().getAzp())
                .claim(JWTClaimNames.Public.CSRF, this.jwtClaims.getPublicClaims().getCsrf())
                .claim(JWTClaimNames.Public.SID, this.jwtClaims.getPublicClaims().getSid())
                .claim(JWTClaimNames.Public.EMAIL, this.jwtClaims.getPublicClaims().getEmail())
                .claim(JWTClaimNames.Public.EMAIL_VERIFIED, this.jwtClaims.getPublicClaims().getEmailVerified())
                .claim(JWTClaimNames.Public.LOCALE, this.jwtClaims.getPublicClaims().getLocale())
                .claim(JWTClaimNames.Public.ZONEINFO, this.jwtClaims.getPublicClaims().getZoneInfo())
                .claim(JWTClaimNames.Registered.IAT, this.jwtClaims.getRegisteredClaims().getIat())
                .claim(JWTClaimNames.Registered.AUD, this.jwtClaims.getRegisteredClaims().getAud())
                .claim(JWTClaimNames.Registered.EXP, this.jwtClaims.getRegisteredClaims().getExp())
                .claim(JWTClaimNames.Registered.ISS, this.jwtClaims.getRegisteredClaims().getIss())
                .claim(JWTClaimNames.Registered.SUB, this.jwtClaims.getRegisteredClaims().getSub());
    }
}
