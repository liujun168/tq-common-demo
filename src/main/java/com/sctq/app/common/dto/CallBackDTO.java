package com.sctq.app.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 回调函数请求实体对象
 * @author: liujun 249489478@qq.com
 * @create: 2019-11-14 14:50
 */
@Data
public class CallBackDTO extends ResponseBaseDTO implements Serializable {

    /**
     * 当前任务ID
     */
    private String taskId;

    /**
     * 当前时间戳
     */
    private String timeStamp;

    /**
     * 加密的密文
     */
    private String cryptograph;
}
