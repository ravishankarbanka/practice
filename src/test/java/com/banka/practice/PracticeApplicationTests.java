package com.banka.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.banka.practice.entity.Department;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PracticeApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {

	}

	@Test
	void greetingShouldReturnDefaultMessage() throws Exception {

		String url = "http://localhost:" + port + "/dept";
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		
		assertEquals("Reachable", this.restTemplate.getForObject(url, String.class));

	}

	@Test
	void testGetByDeptId() throws Exception {
		
		Department department = this.restTemplate.getForObject("http://localhost:"+ this.port +"/dept/departments/81", Department.class);

		
	}

}
