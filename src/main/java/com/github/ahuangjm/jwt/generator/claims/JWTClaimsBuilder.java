package com.github.ahuangjm.jwt.generator.claims;

import com.nimbusds.jwt.JWTClaimsSet;
import org.apache.commons.lang3.LocaleUtils;
import sun.util.calendar.ZoneInfo;

import java.text.ParseException;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public abstract class JWTClaimsBuilder<T extends JWTClaims> {
    private final T jwtClaims;
    protected JWTClaimsSet claimsSet;

    protected JWTClaimsBuilder(final T jwtClaims) {
        this.jwtClaims = jwtClaims;
    }

    public JWTClaimsBuilder<T> claimsSet(final JWTClaimsSet claimsSet) {
        this.claimsSet = claimsSet;
        return this;
    }

    public T build() throws Exception {
        this.setRegisteredClaims();
        this.setPublicClaims();
        this.setPrivateClaims();
        this.setUnknownClaims();
        return this.jwtClaims;
    }

    private void setUnknownClaims() {
        final Map<String, Object> claims = this.claimsSet.getClaims();
        
        claims.remove(JWTClaimNames.Registered.ISS);
        claims.remove(JWTClaimNames.Registered.AUD);
        claims.remove(JWTClaimNames.Registered.SUB);
        claims.remove(JWTClaimNames.Registered.IAT);
        claims.remove(JWTClaimNames.Registered.EXP);
        claims.remove(JWTClaimNames.Public.LOCALE);
        claims.remove(JWTClaimNames.Public.ZONEINFO);
        claims.remove(JWTClaimNames.Public.AZP);
        claims.remove(JWTClaimNames.Public.SID);
        claims.remove(JWTClaimNames.Public.CSRF);
        claims.remove(JWTClaimNames.Public.EMAIL);
        claims.remove(JWTClaimNames.Public.EMAIL_VERIFIED);
        this.jwtClaims.setUnknownClaims(claims);
    }

    private void setRegisteredClaims() throws ParseException {
        final RegisteredClaims claims = new RegisteredClaims();
        claims.setIss(this.claimsSet.getStringClaim(JWTClaimNames.Registered.ISS));
        claims.setAud(this.claimsSet.getStringClaim(JWTClaimNames.Registered.AUD));
        claims.setSub(this.claimsSet.getStringClaim(JWTClaimNames.Registered.SUB));
        claims.setIat(this.claimsSet.getLongClaim(JWTClaimNames.Registered.IAT));
        claims.setExp(this.claimsSet.getLongClaim(JWTClaimNames.Registered.EXP));
        this.jwtClaims.setRegisteredClaims(claims);
    }

    private void setPublicClaims() throws ParseException {
        final PublicClaims claims = new PublicClaims();

        final String localeClaim = this.claimsSet.getStringClaim(JWTClaimNames.Public.LOCALE);
        if (localeClaim != null) {
            final Locale locale = LocaleUtils.toLocale(localeClaim);
            claims.setLocale(locale);
        }

        final String zoneInfoClaim = this.claimsSet.getStringClaim(JWTClaimNames.Public.ZONEINFO);
        if (zoneInfoClaim != null) {
            final TimeZone timeZone = ZoneInfo.getTimeZone(zoneInfoClaim);
            claims.setZoneInfo(timeZone);
        }

        claims.setAzp(this.claimsSet.getStringClaim(JWTClaimNames.Public.AZP));
        claims.setSid(this.claimsSet.getStringClaim(JWTClaimNames.Public.SID));
        claims.setCsrf(this.claimsSet.getStringClaim(JWTClaimNames.Public.CSRF));
        claims.setEmail(this.claimsSet.getStringClaim(JWTClaimNames.Public.EMAIL));
        claims.setEmailVerified(this.claimsSet.getBooleanClaim(JWTClaimNames.Public.EMAIL_VERIFIED));
        this.jwtClaims.setPublicClaims(claims);
    }

     protected abstract void setPrivateClaims() throws Exception;
}
