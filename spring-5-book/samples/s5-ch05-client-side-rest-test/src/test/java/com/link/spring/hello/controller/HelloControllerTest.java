
package com.link.spring.hello.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * HelloController Test.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
@WebAppConfiguration
public class HelloControllerTest {
	/**
	 * 模拟休息服务服务器
	 */
	private MockRestServiceServer mockServer;

	private RestTemplate restTemplate;

	@Before
	public void setup() {
		this.restTemplate = new RestTemplate();
		this.mockServer = MockRestServiceServer.bindTo(this.restTemplate).ignoreExpectOrder(true).build();
	}

	@Test
	public void performGet() throws Exception {

		String responseBody = "Hello World! Welcome to visit link.com!";

		this.mockServer.expect(requestTo("/hello")).andExpect(method(HttpMethod.GET))
			.andRespond(withSuccess(responseBody, MediaType.APPLICATION_JSON));

		@SuppressWarnings("unused")
		String hello = this.restTemplate.getForObject("/hello", String.class);
		System.out.println(hello);
		// Hello World! Welcome to visit link.com!

		// 我们只验证请求。响应是被 Mock 掉的  Mock模拟请求
		this.mockServer.verify();
	}
}