package kohn.dictionary;

import static org.junit.Assert.*;

import org.junit.Test;

public class DictionaryTest {
	
	String fileName = "src/dictionary.txt";
	Dictionary dictionary = new Dictionary(fileName);
	
	@Test
	public void testDictionary() {
		assertTrue(!dictionary.isEmpty());	
	}
	
	@Test
	public void testContain() {
		
		String word = "cyclist";
		assertTrue(word, dictionary.contains(word));
	}

	@Test
	public void testDefinition()
	{
		String word = "cyclist";
		String definition = " one who rides a bicycle [n -S]";
		assertEquals(definition, dictionary.getDefinition(word));
	}
}
