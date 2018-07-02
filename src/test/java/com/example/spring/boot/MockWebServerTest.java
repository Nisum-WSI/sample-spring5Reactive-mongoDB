/**
 * 
 */
package com.example.spring.boot;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

/**
 * @author Vijay
 *
 */
public class MockWebServerTest {

	MockWebServer server = new MockWebServer();

	@Before
	public void before() throws IOException {
		MockResponse mockResponse = new MockResponse();
		mockResponse.setResponseCode(200);
		mockResponse.setBody("Hello World");
		server.enqueue(mockResponse);
		server.start();
	}

	@Test
	public void test() throws IOException, InterruptedException {
		URL url = server.url("/v1/path").url();
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		assertEquals(HttpURLConnection.HTTP_OK, connection.getResponseCode());
		assertEquals("Hello World", reader.readLine());
	}

	@After
	public void after() throws IOException {
		server.shutdown();
		server.close();
	}
}
