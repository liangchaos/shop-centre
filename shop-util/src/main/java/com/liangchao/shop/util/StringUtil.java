package com.liangchao.shop.util;

/**
 * Description:
 * User: Administrator-LiangChao
 * Date: 2019-05-20
 * Time: 9:54
 */
public class StringUtil {

    /**
     * Object[] toString
     * @param objects
     */
    public static String toString (Object[] objects) {
        String str = "";
        for (Object o : objects) {
            str += ";" + o.toString ();
        }
        return str.length () > 0 ? str.substring (1) : null;
    }

}
