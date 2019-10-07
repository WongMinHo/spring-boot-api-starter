package com.minhow.springbootapistarter.common.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.TextCodec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * jwt 工具类
 * @author MinHow
 * @date 2019/6/6 9:13 下午
 */
@Component
@Slf4j
public class JWTUtil {
    /**
     * 加密SECRET
     */
    @Value("${spring-boot-api.jwt.secret}")
    private String secret;
    /**
     * 过期时间
     */
    @Value("${spring-boot-api.jwt.expire-second}")
    private Long expireSecond;

    /**
     * 创建token
     * @param map
     * @return
     */
    public String createJWT(Map map) {
        Map<String, Object> header = new HashMap<>(2);
        header.put("alg", "HS256");
        header.put("typ", "JWT");
        Instant now = Instant.now();
        String jwt = Jwts.builder()
                .setClaims(map)
                .setHeader(header)
                .setExpiration(Date.from(now.plus(expireSecond, ChronoUnit.SECONDS)))
                .setIssuedAt(Date.from(now))
                .signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.encode(secret))
                .compact();

        return Base64.getEncoder().encodeToString(jwt.getBytes());
    }


    /**
     * 校验token
     * @param jwtToken
     * @return
     */
    public boolean verify(String jwtToken) {
        try {
            byte[] b = Base64.getDecoder().decode(jwtToken);
            String base64jwt = new String(b);
            Jwts.parser().setSigningKey(TextCodec.BASE64.encode(secret)).parse(base64jwt);
            return true;
        } catch (ExpiredJwtException var3) {
            log.error(var3.getMessage(), var3);
        } catch (MalformedJwtException var4) {
            log.error(var4.getMessage(), var4);
        } catch (SignatureException var5) {
            log.error(var5.getMessage(), var5);
        } catch (Exception var6) {
            log.error(var6.getMessage(), var6);
        }

        return false;
    }

    /**
     * Token解密
     * @param jwtToken
     * @return
     */
    public Map getJWTData(String jwtToken) {
        try {
            byte[] b = Base64.getDecoder().decode(jwtToken);
            String base64jwt = new String(b);
            Jwt jwt = Jwts.parser().setSigningKey(TextCodec.BASE64.encode(secret)).parse(base64jwt);
            return (Map)jwt.getBody();
        } catch (ExpiredJwtException var4) {
            log.error(var4.getMessage(), var4);
        } catch (MalformedJwtException var5) {
            log.error(var5.getMessage(), var5);
        } catch (SignatureException var6) {
            log.error(var6.getMessage(), var6);
        } catch (Exception var7) {
            log.error(var7.getMessage(), var7);
        }

        return null;
    }

    /**
     * 刷新token
     * @param token
     * @return
     */
    public String refreshToken(String token) {
        return verify(token) ? createJWT(getJWTData(token)) : null;
    }
}
