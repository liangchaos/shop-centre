package com.liangchao.shop.webwap.web;

/**
 * Description: 公共参数定义
 * User: Administrator-LiangChao
 * Date: 2019-05-20
 * Time: 17:17
 */
public final class Web {

    /** Admin Mapping 根 **/
    public static final String MAPPLING_WEB_ADMIN_ROOT = "/admins";
    public static final String MAPPLING_WEB_DEFAULTS_ROOT = MAPPLING_WEB_ADMIN_ROOT + "/default";
    public static final String MAPPLING_WEB_DEFAULTS_USERSACCOUNT_ROOT = MAPPLING_WEB_DEFAULTS_ROOT + "/users_account";

    /** 验证码KEY **/
    public static String SESSION_CODE_KEY = "SESSION_CODE_KEY";
}
