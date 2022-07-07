package com.example.mvc.service.impl;

import com.example.jpa.dao.StockDao;
import com.example.jpa.entity.StockDo;
import com.example.mvc.model.Stock;
import com.example.mvc.service.StockService;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * @Author: linKe
 * @Date: 2022/7/2 0:18
 * @FileName: StockServiceImpl
 * @version: 1.0
 * @Description: 描述
 */
@AllArgsConstructor
public class StockServiceImpl implements StockService {

    private StockDao stockDao;
    @Override
    public List<Stock> getAllStocks() {
        List<StockDo> all = stockDao.findAll();
        return null;

    }
}
