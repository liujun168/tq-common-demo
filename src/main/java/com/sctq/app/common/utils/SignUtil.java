package com.sctq.app.common.utils;

import com.sctq.app.common.constants.Constants;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.TreeMap;

/**
 * @description: 签名工具类
 * @author: liujun 249489478@qq.com
 * @create: 2019-11-14 14:48
 */
public class SignUtil {

    /**
     * 应用加密 --使用appSecret作为密钥加密
     *
     * @param params
     * @param appId
     * @param appSecret
     * @return
     */
    public static String appEncrypt(Map<String, String> params, final String appId, final String appSecret) {
        if (null == params) {
            params = new TreeMap<String, String>();
        }
        params.put(Constants.APP_ID, appId);
        params.put(Constants.APP_SECRET, appSecret);
        return parameterEncrypt(params);
    }

    /**
     * 参数加密--无密钥
     *
     * @param params 参数集合
     * @return
     */
    public static String parameterEncrypt(final Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        // 将参数以参数名的字典升序排序
        Map<String, String> sortParams = new TreeMap<String, String>(params);
        // 遍历排序的字典,并拼接"key=value"格式
        for (Map.Entry<String, String> entry : sortParams.entrySet()) {
            String key = entry.getKey();
            String value = null;
            if (null != entry.getValue()) {
                value = entry.getValue().trim();
            }
            if (StringUtils.isNotEmpty(value)) {
                sb.append("&").append(key).append("=").append(value);
            }
        }
        String str = sb.toString().replaceFirst("&", "");
        String signValue = MD5Util.md5(str);
        return signValue;
    }
}
