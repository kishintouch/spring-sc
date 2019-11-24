package com.ecommerce.auth.config;
import static java.util.Collections.emptyList;

import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthenticationService {
    static final long EXPIRATIONTIME = 864_000_000; // 10 days
    static final String SECRET = "erohrohorhworolknlnl";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    static void addAuthentication(HttpServletResponse res, String username) {
        String JWT = getJWTToken(username);
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
    }

    public static String getJWTToken(String username) {
        String JWT = Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SECRET).compact();
        return JWT;
    }

    static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);

        if (token != null) {
            // parse the token.
            String user = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody()
                    .getSubject();

            return user != null ? new UsernamePasswordAuthenticationToken(user, null, emptyList()) : null;
        }

        String queryString = request.getQueryString();

        if (StringUtils.isBlank(queryString)) {
            return null;
        }

        String queryParamToken = Arrays.asList(queryString.split("&")).stream().filter((q) -> {
            return q.indexOf("token") == 0;
        }).map((q) -> {
            return q.replace("token=", "");
        }).findFirst().orElse(null);

        if (queryParamToken != null) {
            String user = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(queryParamToken).getBody().getSubject();

            return user != null ? new UsernamePasswordAuthenticationToken(user, null, emptyList()) : null;
        }
        return null;
    }
}