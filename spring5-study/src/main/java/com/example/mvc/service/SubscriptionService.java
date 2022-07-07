package com.example.mvc.service;

import com.example.mvc.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: linKe
 * @Date: 2022/7/2 0:07
 * @FileName: SubscriptionService
 * @version: 1.0
 * @Description: 描述
 */
public interface SubscriptionService extends JpaRepository<Stock, String> {

}
