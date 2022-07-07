package com.example.mvc.controller;

import com.example.mvc.model.Stock;
import com.example.mvc.service.StockService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: linKe
 * @Date: 2022/7/2 0:03
 * @FileName: StockController
 * @version: 1.0
 * @Description: 描述
 */
@Controller
@RequestMapping("/stocks")
@AllArgsConstructor
public class StockController {

    StockService stockService;

    public String getStocks(Model model) {
      List<Stock> stocks =   stockService.getAllStocks();

        return "stocks";
    }

}
