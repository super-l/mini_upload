package cn.nepenthes.miniupload.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.List;

public class JwtUtil {
    /**
     * 过期时间24小时
     */
    private static final long EXPIRE_TIME = 24 * 60 * 60 * 1000;

    /**
     * jwt 密钥
     */
    private static final String SECRET = "nepenthes_jwt_sec2020";

    /**
     * 生成签名，五分钟后过期
     */
    public static String sign(long userId,String userName) {
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            return JWT.create()
                    .withAudience(String.valueOf(userId),userName)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 根据token获取信息
     * @param token
     * @return
     */
    public static List<String> getUserData(String token) {
        try {
            return JWT.decode(token).getAudience();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 根据token获取userId
     * @param token
     * @return
     */
    public static String getUserId(String token) {
        try {
            String userId = JWT.decode(token).getAudience().get(0);
            return userId;
        } catch (JWTDecodeException e) {
            return null;
        }
    }


    /**
     * 根据token获取userId
     * @param token
     * @return
     */
    public static String getUserName(String token) {
        try {
            String userName = JWT.decode(token).getAudience().get(1);
            return userName;
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 校验token
     * @param token
     * @return
     */
    public static boolean checkSign(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            DecodedJWT jwt = jwtVerifier.verify(token);
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("token 无效，请重新获取");
        }
        return true;
    }


}
