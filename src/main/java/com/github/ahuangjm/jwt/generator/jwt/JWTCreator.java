package com.github.ahuangjm.jwt.generator.jwt;

import com.github.ahuangjm.jwt.generator.claims.JWTClaims;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.ECDSASigner;
import com.nimbusds.jose.crypto.ECDSAVerifier;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.ECKey;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import java.text.ParseException;

public abstract class JWTCreator<T extends JWTClaims> {
    private final Algorithm algorithm;
    private final JWSSigner signer;
    private final JWSVerifier jwsVerifier;

    protected JWTCreator(final JWK key) throws JOSEException {
        this.algorithm = key.getAlgorithm();
        this.signer = this.getSigner(this.algorithm, key);
        this.jwsVerifier = this.getVerifier(this.algorithm, key);
    }

    public JWT create(final T claims) throws JOSEException {
        final JWTClaimsSet claimsSet = this.getClaimsSet(claims);
        final JWSHeader header = new JWSHeader((JWSAlgorithm) this.algorithm);
        final SignedJWT jwt = new SignedJWT(header, claimsSet);
        jwt.sign(this.signer);
        return jwt;
    }

    public JWT parse(final String s) throws ParseException, JOSEException {
        final SignedJWT jwt = SignedJWT.parse(s);
        final boolean verified = this.jwsVerifier.verify(jwt.getHeader(), jwt.getSigningInput(), jwt.getSignature());
        if (!verified) {
            throw new IllegalArgumentException("JWT is unverified.");
        }
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

    private JWSVerifier getVerifier(final Algorithm algorithm, final JWK key) throws JOSEException {
        if (JWSAlgorithm.Family.EC.contains(algorithm)) {
            return new ECDSAVerifier((ECKey) key);
        } else if (JWSAlgorithm.Family.RSA.contains(algorithm)) {
            return new RSASSAVerifier((RSAKey) key);
        } else {
            throw new IllegalArgumentException("Only ES and RSA algorithms are supported");
        }
    }

    abstract JWTClaimsSet getClaimsSet(final T claims);
}
