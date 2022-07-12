package com.link.spring.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 聊天控制器.

 */
@Controller
public class ChatController {
    
    @GetMapping("/")
    public String index() {
        return "index";
    }

}
