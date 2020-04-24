package edu.uncc.domoapi;

import edu.uncc.domoapi.api.SystemController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApplicationTests {
	@Autowired
	SystemController systemController;

	@Test
	void contextLoads() {
		assertThat(systemController).isNotNull();
	}

}
