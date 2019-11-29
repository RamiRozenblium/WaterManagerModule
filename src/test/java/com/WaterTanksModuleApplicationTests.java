package com;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.controller.WaterTanksController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class WaterTanksModuleApplicationTests {

	@Autowired
	private WaterTanksController controller;
	
	@Autowired
	  private MockMvc mockMvc;
	
	@Test	
	void contextLoads() throws Exception{
		assertThat(controller).isNotNull();
		
	}
	
	
}
