/**
 * 
 */
package com.example.spring.boot;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.spring.boot.dao.entity.Blog;
import com.example.spring.boot.service.BlogService;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import reactor.core.publisher.Flux;

/**
 * @author Vijay
 *
 */
public class BlogControllerTest {
	
	MockWebServer server =new MockWebServer();
	
	@Autowired
	private BlogService blogService;
	
	@Before
	public void before() throws IOException {
		MockResponse response=new MockResponse();
		response.setResponseCode(200);
		response.setBody("This is for Testing");
		server.enqueue(response);
		server.start();
	}
	
	@Test
	public Flux<Blog> TestfindAll() {
		return blogService.findAll();
		
	}

}
