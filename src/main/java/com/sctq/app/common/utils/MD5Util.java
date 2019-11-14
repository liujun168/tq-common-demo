package com.sctq.app.common.utils;

import org.apache.commons.codec.digest.DigestUtils;
/**
 * @description: MD5加密工具类
 * @author: liujun 249489478@qq.com
 * @create: 2019-11-14 14:42
 */
public class MD5Util {

    /**
     * 不带秘钥加密
     * @param text
     * @return
     */
    public static String md5(String text) {
        String md5str = DigestUtils.md5Hex(text);
        return md5str;
    }

    /**
     * 带秘钥加密
     * @param text
     * @param key
     * @return
     */
    public static String md5(String text, String key) {
        String md5str = DigestUtils.md5Hex(text + key);
        return md5str;
    }

    /**
     * MD5验证方法 --根据传入的密钥进行验证
     *
     * @param text 明文
     * @param key 密钥
     * @param md5 密文
     */
    public static boolean verify(String text, String key, String md5) throws Exception {
        String md5str = md5(text, key);
        if (md5str.equals(md5)) {
            return true;
        }
        return false;
    }

    /**
     * MD5验证方法 --根据传入的密钥进行验证(忽略大小写)
     *
     * @param text 明文
     * @param key 密钥
     * @param md5 密文
     */
    public static boolean verifyIgnorseCase(String text, String key, String md5) throws Exception {
        String md5str = md5(text, key);
        if (md5str.equalsIgnoreCase(md5)) {
            return true;
        }
        return false;
    }

}
