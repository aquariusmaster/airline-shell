package ua.com.globallogic.airline;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.shell.Shell;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(TestApplicationRunner.class)
public class AirlineApplicationTests {

	@Autowired
	private Shell shell;

	@Test
	public void shellAvailable() {
		assertThat(shell.evaluate(() -> "help")).isNotNull();
	}
}