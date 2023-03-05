package com.github.ahuangjm.jwt.generator.jwt;

import com.github.ahuangjm.jwt.generator.claims.BasicJWTClaims;
import com.nimbusds.jwt.JWTClaimsSet;

public class BasicJWTCreator extends JWTCreator<BasicJWTClaims> {
    @Override
    JWTClaimsSet getClaimsSet(final BasicJWTClaims claims) {
        return new BasicJWTClaimSetBuilder().jwtClaims(claims).build();
    }
}
