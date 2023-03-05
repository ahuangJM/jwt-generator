package com.github.ahuangjm.jwt.generator.jwt;

import com.github.ahuangjm.jwt.generator.claims.JWTClaims;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.ECDSASigner;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.jwk.ECKey;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

public abstract class JWTCreator<T extends JWTClaims> {
    public JWT create(final T claims, final JWK key) throws JOSEException {
        final Algorithm algorithm = key.getAlgorithm();
        final JWSSigner signer = this.getSigner(algorithm, key);
        final JWTClaimsSet claimsSet = this.getClaimsSet(claims);
        final JWSHeader header = new JWSHeader((JWSAlgorithm) algorithm);
        final SignedJWT jwt = new SignedJWT(header, claimsSet);
        jwt.sign(signer);
        return jwt;
    }

    private JWSSigner getSigner(final Algorithm algorithm, final JWK key) throws JOSEException {
        if (JWSAlgorithm.Family.EC.contains(algorithm)) {
            return new ECDSASigner((ECKey) key);
        } else if (JWSAlgorithm.Family.RSA.contains(algorithm)) {
            return new RSASSASigner((RSAKey) key);
        } else {
            throw new IllegalArgumentException("Only ES and RSA algorithms are supported");
        }
    }

    abstract JWTClaimsSet getClaimsSet(final T claims);
}
