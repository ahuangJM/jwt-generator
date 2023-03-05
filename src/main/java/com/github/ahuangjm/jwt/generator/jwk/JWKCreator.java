package com.github.ahuangjm.jwt.generator.jwk;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.jwk.ECKey;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.ECKeyGenerator;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;

public class JWKCreator {
    public ECKey createECKey() throws JOSEException {
        return new ECKeyGenerator(Curve.Ed25519).generate();
    }

    public RSAKey createRSAKey() throws JOSEException {
        return new RSAKeyGenerator(2048).generate();
    }
}
