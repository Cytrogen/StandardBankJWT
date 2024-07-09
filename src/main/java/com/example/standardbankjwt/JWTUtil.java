package com.example.standardbankjwt;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecureDigestAlgorithm;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.UUID;
import java.time.Instant;
import javax.crypto.SecretKey;

/**
 * Utility class for handling JWT (JSON Web Token) operations.
 * This class provides methods for generating and parsing JWT tokens.
 *
 * @author Cytrogen
 * @version 1.0
 * @since 2024-07-09
 */
@Component
public class JWTUtil {

    /** The expiration time for access tokens in seconds. */
    public static final int ACCESS_EXPIRE = 60;

    /** The algorithm used for JWT signing. */
    private final static SecureDigestAlgorithm<SecretKey, SecretKey> ALGORITHM = Jwts.SIG.HS256;

    /** The secret key used for JWT signing and verification. */
    private final static String SECRET = "aVeryLongSecretKeyThatIsAtLeast256Bits";

    /** The SecretKey object generated from the SECRET string. */
    public static final SecretKey KEY = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    /** The issuer claim for the JWT. */
    private final static String JWT_ISS = "Tiam";

    /** The subject claim for the JWT. */
    private final static String SUBJECT = "Peripherals";

    /**
     * Generates an access token for the given username.
     *
     * @param username The username for which to generate the token.
     * @return A JWT string representing the access token.
     */
    public static String genAccessToken(String username) {
        String uuid = UUID.randomUUID().toString();
        Date exprireDate = Date.from(Instant.now().plusSeconds(ACCESS_EXPIRE));

        return Jwts.builder()
                .header()
                .add("typ", "JWT")
                .add("alg", "HS256")
                .and()
                .claim("username", username)
                .id(uuid)
                .expiration(exprireDate)
                .issuedAt(new Date())
                .subject(SUBJECT)
                .issuer(JWT_ISS)
                .signWith(KEY, ALGORITHM)
                .compact();
    }

    /**
     * Parses the claims from a JWT token.
     *
     * @param token The JWT token to parse.
     * @return A Jws<Claims> object representing the parsed claims.
     */
    public static Jws<Claims> parseClaim(String token) {
        return Jwts.parser()
                .verifyWith(KEY)
                .build()
                .parseSignedClaims(token);
    }

    /**
     * Parses the header from a JWT token.
     *
     * @param token The JWT token to parse.
     * @return A JwsHeader object representing the parsed header.
     */
    public static JwsHeader parseHeader(String token) {
        return parseClaim(token).getHeader();
    }

    /**
     * Parses the payload from a JWT token.
     *
     * @param token The JWT token to parse.
     * @return A Claims object representing the parsed payload.
     */
    public static Claims parsePayload(String token) {
        return parseClaim(token).getPayload();
    }

}
