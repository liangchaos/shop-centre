package com.liangchao.shop.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Description:MD5 工具
 * User: Administrator-LiangChao
 * Date: 2019-06-02
 * Time: 14:30
 */
public class Md5Util {

    /** 默认盐值 **/
    private static final String SALT = "default.liangchaos.wy";

    /**
     * MD5加盐加密 方式一
     * @param password
     * @return
     */
    public static String encode (String password) throws NoSuchAlgorithmException {
        password = password + SALT;
        char[] charArray = password.toCharArray ();
        MessageDigest md5 = MessageDigest.getInstance ("MD5");
        byte[] byteArray = new byte[charArray.length];
        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest (byteArray);
        StringBuffer hexValue = new StringBuffer ();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append ("0");
            }
            hexValue.append (Integer.toHexString (val));
        }
        return hexValue.toString ();
    }

    /**
     * MD5 盐值加密方法 方式二
     * @param salt 盐
     * @param str 需要加密数据
     */
    public static String geMd5 (String salt, String str) throws NoSuchAlgorithmException {
        //密码和盐值组合方式
        str = str + "{" + salt + "}";
        byte[] strBytes = str.getBytes ();
        MessageDigest md = MessageDigest.getInstance ("MD5");
        byte[] digest = md.digest (strBytes);
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        int j = digest.length;
        char strs[] = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte b = digest[i];
            strs[k++] = hexDigits[b >> 4 & 0xf];
            strs[k++] = hexDigits[b & 0xf];
        }
        return new String (strs);
    }

    // /**
    //  * 对密码进行加密
    //  * @param password
    //  * @return
    //  */
    // public static String encode(String password) {
    //     BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
    //     String hashPass = bcryptPasswordEncoder.encode(password);
    //     return hashPass;
    // }
    // /**
    //  * 对原密码和已加密的密码进行匹配，判断是否相等
    //  * @param password
    //  * @param encodedPassword
    //  * @return
    //  */
    // public static boolean match(String password,String encodedPassword) {
    //     BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
    //     boolean result = bcryptPasswordEncoder.matches(password, encodedPassword);
    //     return result;
    // }
}
