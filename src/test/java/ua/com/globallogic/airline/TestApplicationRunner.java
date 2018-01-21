package ua.com.globallogic.airline;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.stereotype.Component;

@TestConfiguration
public class TestApplicationRunner implements ApplicationRunner {

    public TestApplicationRunner() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Do nothing...
    }

}