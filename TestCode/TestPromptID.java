package pair02TestCode;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import pair02SourceCode.UI;

/*****************************************************************************
 * testPromptID1()
 * 用 setIn 設定console input，使用者輸入的字串Q 
	ByteArrayInputStream inContent = new ByteArrayInputStream("Q".getBytes());
	System.setIn(inContent);

	用 setOut設定console output
	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	System.setOut (new PrintStream (outContent));

	promptID return使用者輸入字串
	String result = promptID();  

	預期promptID會顯示"輸入ID或 Q (結束使用)？" 
	assertEquals("輸入ID或 Q (結束使用)？", outContent);
	assertEquals ("Q", result);
 * @throws Exception 
 * 
 *  testPromptID2()
 * 	用 setIn 設定console input，使用者輸入的字串 962001044 
	ByteArrayInputStream inContent = new ByteArrayInputStream("962001044".getBytes());
	System.setIn(inContent);

	用 setOut設定console output
	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	System.setOut (new PrintStream (outContent));

	 promptID return使用者輸入字串
	String result = promptID();  

	預期promptID會顯示"輸入ID或 Q (結束使用)？"
	assertEquals("輸入ID或 Q (結束使用)？", outContent);
	assertEquals ("962001044", result);
 * @throws Exception 
 
 *  testPromptID3()
 *  用 setIn 設定console input，使用者輸入的字串 1234567 
	ByteArrayInputStream inContent = new ByteArrayInputStream("1234567".getBytes());
	System.setIn(inContent);

	用 setOut設定console output
	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	System.setOut (new PrintStream (outContent));

	 promptID return使用者輸入字串
	String result = promptID();  

	預期promptID會顯示"輸入ID或 Q (結束使用)？" 
	assertEquals("輸入ID或 Q (結束使用)？", outContent);
	assertEquals ("1234567", result);
 * @throws Exception 
 ******************************************************************************/
public class TestPromptID
{


	@Test
	public void testPromptID1() throws Exception
	{
		ByteArrayInputStream inContent = new ByteArrayInputStream("Q".getBytes());
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		System.setIn(inContent);
		System.setOut(new PrintStream(outContent));
		UI aUi = new UI();
		String result = aUi.promptID();

		assertEquals(("輸入ID或 Q (結束使用)？\r\n").replaceAll("\\s+",""), outContent.toString().replaceAll("\\s+",""));
		assertEquals ("Q", result);
	}
	
	@Test
	public void testPromptID2() throws Exception
	{
		ByteArrayInputStream inContent = new ByteArrayInputStream("962001044".getBytes());
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		System.setIn(inContent);
		System.setOut(new PrintStream(outContent));
		UI aUi = new UI();
		String result = aUi.promptID();

		assertEquals(("輸入ID或 Q (結束使用)？\r\n").replaceAll("\\s+",""), outContent.toString().replaceAll("\\s+",""));
		assertEquals ("962001044", result);
	}
	
	@Test
	public void testPromptID3() throws Exception
	{
		ByteArrayInputStream inContent = new ByteArrayInputStream("1234567".getBytes());
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		System.setIn(inContent);
		System.setOut(new PrintStream(outContent));
		UI aUi = new UI();
		String result = aUi.promptID();

		assertEquals(("輸入ID或 Q (結束使用)？\r\n").replaceAll("\\s+",""), outContent.toString().replaceAll("\\s+",""));
		assertEquals ("1234567", result);	
	}


}
