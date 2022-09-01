package lti.she.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserControllerTests.class)
@SpringBootTest
public class UserControllerTests {

	@Autowired
	MainController mc;
	
	@Test
	public void greetTest() {
		assertNotNull(mc.greet());
	}
	
}
