package edu.uncc.domoapi.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SystemControllerTests {
    @Autowired
    SystemController systemController;

    @Test
    void contextLoads() {
        assertThat(systemController).isNotNull();
    }

    @Test
    void healthCheckTest(){
        assertThat(systemController.healthCheck().getContent().get("healthy")).isEqualTo("true");
    }

}
