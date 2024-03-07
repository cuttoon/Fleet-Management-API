package com.fleet.FleetManagementAPI;

import com.fleet.FleetManagementAPI.repository.TaxisRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class FleetManagementApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private TaxisRepository taxisRepository;

	@Test
	@DisplayName("Probando el primer endpoint")
	void contextLoads() {

	}

}
