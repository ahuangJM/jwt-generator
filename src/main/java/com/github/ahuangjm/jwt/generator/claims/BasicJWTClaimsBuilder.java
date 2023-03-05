package com.github.ahuangjm.jwt.generator.claims;

public class BasicJWTClaimsBuilder extends JWTClaimsBuilder<BasicJWTClaims> {
    public BasicJWTClaimsBuilder() {
        super(new BasicJWTClaims());
    }

    @Override
    protected void setPrivateClaims() {
    }
}
