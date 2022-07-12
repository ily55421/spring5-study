
package com.link.spring.webclient;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.InputStream;


/**
 * Application Main.
 * web客户端上传下载文件
 */
public class Application {

	public static void main(String[] args) throws Exception {

		// 上传图片
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(PageAttributes.MediaType.IMAGE_JPEG);
		HttpEntity<ClassPathResource> entity
			= new HttpEntity<>(new ClassPathResource("1.jpg"), headers);
		
		MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
		parts.add("file", entity);
		
		Mono<String> resp = WebClient.create().post().uri("http://localhost:8081/upload")
				.contentType(PageAttributes.MediaType.MULTIPART_FORM_DATA)
				.body(BodyInserters.fromMultipartData(parts)).retrieve()
				.bodyToMono(String.class);

		System.out.println("Result:" + resp.block());

		// 下载文件
		Mono<ClientResponse> resp2 = WebClient.create().get()
				.uri("https://waylau.com/images/waylau_181_181.jpg")
				.accept(MediaType.APPLICATION_OCTET_STREAM).exchange();
		ClientResponse response = resp2.block();
		Resource resource = response.bodyToMono(Resource.class).block();
		String destination = "d:/test.jpg"; // 文件下载后保存的路径

		InputStream input = resource.getInputStream();
		int index;
		byte[] bytes = new byte[1024];
		FileOutputStream downloadFile = new FileOutputStream(destination);
		while ((index = input.read(bytes)) != -1) {
			downloadFile.write(bytes, 0, index);
			downloadFile.flush();
		}
		downloadFile.close();
		input.close();
	}

}
