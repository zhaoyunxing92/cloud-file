/**
 * Copyright(C) 2020 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cloud.file.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoyunxing92
 * @date: 2020-04-05 00:03
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public void hello() {
        int a = 1 / 0;
    }
}
