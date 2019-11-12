package br.com.dextra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class TddPresentationApplicationTests {

	private Parser parser;

	@BeforeEach
	public void init() {
		parser = new Parser();
		parser.loadFile("src/test/resources/static/test.txt");
	}

	@Test
	public void testFileLoad() {
		assertEquals(parser.getContent(), "12345");
	}

	@Test
	public void testFileWrite() {
		String filePath = "src/test/resources/static/test2.txt";
		parser.writeFile(filePath);
		parser.loadFile(filePath);
		assertEquals(parser.getContent(), "12345");
	}

	@Test
	public void testFileContentChange() {
		parser.parse();
		assertEquals(parser.getContent(), "54321");
	}

}
