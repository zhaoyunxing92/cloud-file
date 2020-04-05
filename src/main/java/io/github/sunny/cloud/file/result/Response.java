/**
 * Copyright(C) 2020 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cloud.file.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhaoyunxing92
 * @date: 2020-04-05 17:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response implements Serializable {
    /**
     * code编码
     */
    private Integer code;
    /**
     * 消息
     */
    private String msg;
    /**
     * 数据
     */
    private Object data;

    public static Response of(Integer code, String msg, Object data) {
        return new Response(code, msg, data);
    }

    /**
     * 成功code=0
     *
     * @param msg  成功消息
     * @param data 数据
     * @return
     */
    public static Response of(String msg, Object data) {
        return new Response(0, msg, data);
    }

    /**
     * 成功code=0
     *
     * @param msg  成功消息
     * @param data 数据
     * @return
     */
    public static Response of(Object data) {
        return new Response(0, "ok", data);
    }

    public static Response of(Integer code, String msg) {
        return new Response(code, msg, null);
    }
}
