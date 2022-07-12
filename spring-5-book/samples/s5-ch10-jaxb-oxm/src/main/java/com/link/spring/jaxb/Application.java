
package com.link.spring.jaxb;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.link.spring.jaxb.service.CityDataService;
import com.link.spring.jaxb.vo.City;

/**
 * Application Main.
 */
public class Application {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		CityDataService cityDataService = context.getBean(CityDataService.class);
		
		List<City> cityList = cityDataService.listCity();
		for (City city : cityList) {
			System.out.println(city);
		}
		//City [cityId=101280101, cityName=广州, cityCode=guangzhou, province=广东]
		//City [cityId=101280102, cityName=番禺, cityCode=panyu, province=广东]
		//City [cityId=101280103, cityName=从化, cityCode=conghua, province=广东]
		//City [cityId=101280104, cityName=增城, cityCode=zengcheng, province=广东]
		//City [cityId=101280301, cityName=惠州, cityCode=huizhou, province=广东]
		//City [cityId=101280601, cityName=深圳, cityCode=shenzhen, province=广东]
		//City [cityId=101281601, cityName=东莞, cityCode=dongguan, province=广东]
		//City [cityId=101281701, cityName=中山, cityCode=zhongshan, province=广东]

	}

}
