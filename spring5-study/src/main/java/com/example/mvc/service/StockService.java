package com.example.mvc.service;

import com.example.mvc.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: linKe
 * @Date: 2022/7/2 0:14
 * @FileName: StockService
 * @version: 1.0
 * @Description: 描述
 */
public interface StockService {
    List<Stock> getAllStocks();
}
