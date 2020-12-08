package tv.codely.java_basic_skeleton;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class GreeterShould {

	@Test
	void greet_with_a_hello_message_to_the_name_it_receives() {
		Greeter greeter = new Greeter("Jhon");
		assertEquals("Hello Jhon", greeter.greet());
	}

	@Test
	void save_logs_to_the_file() {
		Logger logger = LogManager.getLogger(GreeterShould.class);
		RuntimeException error = new RuntimeException("exceptioooon");
		logger.error("Hello error world!", error);
	}
	
	@Test
	void greet_equals() {
		Greeter greeter = new Greeter("Hello Jhon");
		assertEquals(greeter, new Greeter("Hello Jhon"));
	}
	
	@Test
	void greet_same() {
		Greeter greeter = new Greeter("Hello Jhon");
		assertSame(greeter, greeter);
	}

}
