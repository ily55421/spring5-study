package com.link.spring.mvc.service;

import com.link.spring.mvc.vo.WeatherResponse;

/**
 * 天气数据服务.

 */
public interface WeatherDataService {

	/**
	 * 根据城市ID查询天气数据
	 * @param cityId
	 * @return
	 */
	WeatherResponse getDataByCityId(String cityId);
	
	/**
	 * 根据城市名称查询天气数据
	 * @param cityName
	 * @return
	 */
	WeatherResponse getDataByCityName(String cityName);
}
