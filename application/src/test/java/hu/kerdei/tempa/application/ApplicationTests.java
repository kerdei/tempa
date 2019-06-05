package hu.kerdei.tempa.application;

import hu.kerdei.tempa.application.configuraton.TempaApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes={TempaApplication.class})
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}

}
