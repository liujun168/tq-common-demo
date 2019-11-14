package com.sctq.app.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 响应基础实体对象
 * @author: liujun 249489478@qq.com
 * @create: 2019-11-14 15:16
 */
@Data
public class ResponseBaseDTO implements Serializable {

    /**
     * 执行结果响应码
     */
    private String code;

    /**
     * 执行结果响应信息
     */
    private String msg;
}
