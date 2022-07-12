package com.link.spring.jaxb.service;

import java.util.List;

import com.link.spring.jaxb.vo.City;


/**
 * City Data Service.

 */
public interface CityDataService {

	/**
	 * 获取City列表
	 * @return
	 * @throws Exception
	 */
	List<City> listCity() throws Exception;
}
