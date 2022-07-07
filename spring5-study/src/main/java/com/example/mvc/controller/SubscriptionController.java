package com.example.mvc.controller;

import com.example.mvc.model.StockSymbol;
import com.example.mvc.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: linKe
 * @Date: 2022/7/2 0:03
 * @FileName: SubscriptionController
 * @version: 1.0
 * @Description: 描述 股票代码管理页面
 */
@Controller
@RequestMapping("/subscriptions")
public class SubscriptionController {
     SubscriptionService subscriptionService;

    @Autowired
    public void setSubscriptionService(SubscriptionService subscription){
        this.subscriptionService = subscription;
    }

    public String addSubscription(@ModelAttribute(value = "stockSymbol") StockSymbol symbol) {


        return "redirect:/subscriptions?added=" + symbol.getSymbol();
    }



}
