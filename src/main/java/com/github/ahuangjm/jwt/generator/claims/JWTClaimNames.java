package com.github.ahuangjm.jwt.generator.claims;

/**
 *
 * <a href="https://www.iana.org/assignments/jwt/jwt.xhtml#claims">IANA JWT Claims 2023-02-13</a>
 */
public final class JWTClaimNames {
    public final class Registered {
        public static final String ISS = "iss";
        public static final String SUB = "sub";
        public static final String AUD = "aud";
        public static final String EXP = "exp";
        public static final String IAT = "iat";
    }

    public final class Public {
        public static final String EMAIL = "email";
        public static final String EMAIL_VERIFIED = "email_verified";
        public static final String ZONEINFO = "zoneinfo";
        public static final String LOCALE = "locale";
        public static final String AZP = "azp";
        public static final String SID = "sid";
        public static final String CSRF = "csrf";
    }
}
