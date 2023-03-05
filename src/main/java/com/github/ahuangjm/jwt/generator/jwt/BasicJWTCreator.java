package com.github.ahuangjm.jwt.generator.jwt;

import com.github.ahuangjm.jwt.generator.claims.BasicJWTClaims;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jwt.JWTClaimsSet;

public class BasicJWTCreator extends JWTCreator<BasicJWTClaims> {
    public BasicJWTCreator(final JWK key) throws JOSEException {
        super(key);
    }

    @Override
    JWTClaimsSet getClaimsSet(final BasicJWTClaims claims) {
        return new BasicJWTClaimSetBuilder().jwtClaims(claims).build();
    }
}
