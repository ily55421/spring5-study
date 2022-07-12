
package com.link.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Application Main.
 * EL表达式demo
 *
 */
public class Application {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		ShopList list = (ShopList) ctx.getBean("list");
		System.out.println(list);

		list = (ShopList) ctx.getBean("list2");
		System.out.println(list);

		list = (ShopList) ctx.getBean("list3");
		System.out.println(list);

		list = (ShopList) ctx.getBean("list4");
		System.out.println(list);

		list = (ShopList) ctx.getBean("list5");
		System.out.println(list);

		list = (ShopList) ctx.getBean("list6");
		System.out.println(list);

		list = (ShopList) ctx.getBean("list7");
		System.out.println(list);

		list = (ShopList) ctx.getBean("list8");
		System.out.println(list);

		list = (ShopList) ctx.getBean("list9");
		System.out.println(list);

		list = (ShopList) ctx.getBean("list10");
		System.out.println(list);

		list = (ShopList) ctx.getBean("list11");
		System.out.println(list);

		list = (ShopList) ctx.getBean("list12");
		System.out.println(list);
		//ShopList [name=shanpoo, count=2, price=3.6500000000000004, items=[], onlyOne=null, allGood=null]
		//ShopList [name=shanpoo, count=2, price=3.6500000000000004, items=[], onlyOne=null, allGood=null]
		//ShopList [name=zh_CN, count=2, price=1.0, items=[], onlyOne=null, allGood=null]
		//ShopList [name=zh_CN, count=2, price=1.0, items=[], onlyOne=null, allGood=null]
		//ShopList [name=defaultTax, count=2, price=1.0, items=[], onlyOne=null, allGood=null]
		//ShopList [name=defaultTax, count=2, price=1.0, items=[Item [good=poke, weight=3.34], Item [good=chicken, weight=5.66], Item [good=dark, weight=3.64], Item [good=egg, weight=2.54]], onlyOne=null, allGood=null]
		//ShopList [name=defaultTax, count=2, price=1.0, items=[], onlyOne=Item [good=poke, weight=3.34], allGood=null]
		//ShopList [name=defaultTax, count=2, price=1.0, items=[], onlyOne=Item [good=chicken, weight=5.66], allGood=null]
		//ShopList [name=link, count=0, price=1.0, items=[], onlyOne=null, allGood=null]
		//ShopList [name=null, count=0, price=0.0, items=[Item [good=poke, weight=3.34], Item [good=egg, weight=2.54]], onlyOne=null, allGood=null]
		//ShopList [name=null, count=0, price=0.0, items=[], onlyOne=null, allGood=[poke, chicken, dark, egg]]
		//ShopList [name=null, count=0, price=0.0, items=[], onlyOne=null, allGood=[chicken, dark]]
	}

}
