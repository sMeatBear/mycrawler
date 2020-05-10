package pers.jianfeic.util.csvio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CSVResultWriteTest {

	@Test
	void testCreateCSV() {
		fail("Not yet implemented");
	}

	@Test
	void testAppendCSV() {
		CSVResultWrite.appendCSV("data\\crawler4j\\test\\output.csv", new String[] {"hello", "nihao"});
		CSVResultWrite.appendCSV("data\\crawler4j\\test\\output.csv", new String[] {"hello", "nihao"});
	}

}
