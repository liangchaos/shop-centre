package com.liangchao.shop.util;

import java.util.logging.Logger;
/**
 * Description:日志工具类
 * User: Administrator-LiangChao
 * Date: 2019-05-31
 * Time: 12:04
 */
public class Log {
    /** BASE日志名称 **/
    private static final String BASE_FILE_LOG_KEY = "BASE_FILE_LOG";

    /** 自定义日志输出 BASE_FILE_LOG **/
    public static final Logger L = Logger.getLogger (BASE_FILE_LOG_KEY);

}
