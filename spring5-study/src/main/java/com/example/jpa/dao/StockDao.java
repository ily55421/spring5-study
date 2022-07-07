package com.example.jpa.dao;

import com.example.jpa.entity.StockDo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: linKe
 * @Date: 2022/7/1 23:50
 * @FileName: StockDao
 * @version: 1.0
 * @Description: 股票
 */
public interface StockDao extends JpaRepository<StockDo, String> {
    /**
     * 根据股票符号查询
     * @param symbol 符号
     * @return 股票对象
     */
    StockDo findBySymbol(String symbol);

}
