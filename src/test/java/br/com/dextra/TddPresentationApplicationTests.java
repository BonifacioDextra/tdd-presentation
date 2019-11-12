package br.com.dextra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class TddPresentationApplicationTests {

	private FileHandler fileHandler;

	@BeforeEach
	public void init() {
		fileHandler = new FileHandler();
		fileHandler.load("src/test/resources/static/test.txt");
	}

	@Test
	public void testFileLoad() {
		assertEquals(fileHandler.getContent(), "12345");
	}

	@Test
	public void testFileWrite() {
		String filePath = "src/test/resources/static/test2.txt";
		fileHandler.save(filePath);
		fileHandler.load(filePath);
		assertEquals(fileHandler.getContent(), "12345");
	}

	@Test
	public void testFileContentChange() {
		fileHandler.revert();
		assertEquals(fileHandler.getContent(), "54321");
	}

}
