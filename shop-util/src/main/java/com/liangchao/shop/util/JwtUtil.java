package com.liangchao.shop.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Map;
/**
 * Description: JWT生成token
 * User: Administrator-LiangChao
 * Date: 2019-05-30
 * Time: 19:54
 */
public class JwtUtil {

    /** 额外的盐 **/
    private static final String SECRET = "XX#$%()(#*!()!KL<><MQLMNQNQJQK sdfkjsdrow32234545fdf>?N<:{LWPW";
    /** 过期时间 **/
    private static final String EXP = "exp";
    /** 数据 **/
    private static final String PAYLOAD = "payload";

    /**
     * 创建toke令牌
     * @param str 数据
     * @param maxAge 生命时间的毫秒数
     */
    public static String sign (String str, long maxAge) {
        Algorithm algorithm = Algorithm.HMAC256 (SECRET);
        //@formatter:off
        String token = JWT.create ()
                //签名
                .withIssuer ("liangchao")
                //数据
                .withClaim (PAYLOAD, str)
                //过期时间
                .withClaim (EXP, System.currentTimeMillis () + maxAge)
                .sign (algorithm);
        //@formatter:on
        return token;
    }

    /**
     * 测试生成的token是否可用或失效 返回数据信息
     * @param token
     */
    public static String unsign (String token) {
        Algorithm algorithm = Algorithm.HMAC256 (SECRET);
        //@formatter:off
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("liangchao")
                .build();
        //@formatter:on
        DecodedJWT decodedJWT = verifier.verify (token);

        //获取令牌数据
        final Map<String, Claim> claims = decodedJWT.getClaims ();
        if (claims.containsKey (EXP) && claims.containsKey (PAYLOAD)) {
            long exp = claims.get (EXP).asLong ();
            long currentTimeMillis = System.currentTimeMillis ();
            if (exp > currentTimeMillis) {
                return claims.get (PAYLOAD).asString ();
            }
        }
        return null;
    }
}
