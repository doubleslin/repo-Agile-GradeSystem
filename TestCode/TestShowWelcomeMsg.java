package pair02TestCode;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

import pair02SourceCode.UI;

/*****************************************************************************
 * - class TestShowWelcomeMsg test case 
 * 1: ID 962001044 (¥¿½T ­â©v§Ê) test case 
 * @throws Exception 
 ******************************************************************************/
public class TestShowWelcomeMsg
{
	@Test
	public void testShowWelcomeMsg() throws Exception
	{	
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut (new PrintStream (outContent));
		UI aUi=new UI();
		aUi.showWelcomeMsg("962001044");
		assertEquals("Welcome ­â©v§Ê\r\n".replaceAll("\\s+",""), outContent.toString().replaceAll("\\s+",""));
	}

}
