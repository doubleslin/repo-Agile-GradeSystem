package pair02TestCode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import pair02SourceCode.UI;

/*****************************************************************************
 * - class TestPromptCommand1 test case 
 * 1: ID 962001044，inputCommand輸入E test case 
 * 2: ID 962001044，inputCommand輸入G test case  
 * 3: ID 962001044，inputCommand輸入R test case 
 * 4: ID 962001044，inputCommand輸入W test case 
 * 5: ID 962001044，inputCommand輸入O，出現exception test case 
 * @throws Exception 
 ******************************************************************************/
public class TestPromptCommand
{

	@Test
	public void testPromptCommand1() throws Exception
	{
		ByteArrayInputStream inContent = new ByteArrayInputStream("E".getBytes());
		System.setIn(inContent);
		UI aUi = new UI();	
		assertEquals("E", aUi.promptCommand("962001044"));	
	}
	
	@Test
	public void testPromptCommand2() throws Exception
	{
		ByteArrayInputStream inContent = new ByteArrayInputStream("G".getBytes());
		System.setIn(inContent);
		UI aUi = new UI();	
		assertEquals("G", aUi.promptCommand("962001044"));	
	}
	
	@Test
	public void testPromptCommand3() throws Exception
	{
		ByteArrayInputStream inContent = new ByteArrayInputStream("R".getBytes());
		System.setIn(inContent);
		UI aUi = new UI();	
		assertEquals("R", aUi.promptCommand("962001044"));	
	}
	
	@Test
	public void testPromptCommand4() throws Exception
	{
		ByteArrayInputStream inContent = new ByteArrayInputStream("W".getBytes());
		System.setIn(inContent);
		UI aUi = new UI();	
		assertEquals("W", aUi.promptCommand("962001044"));	
	}
	
	@Test
	public void testPromptCommand5()
	{
		ByteArrayInputStream inContent = new ByteArrayInputStream("O".getBytes());
		System.setIn(inContent);
		String exception = "";
		try
		{
			UI aUi = new UI();
			aUi.promptCommand("962001044");
		}
		catch (Exception ex)
		{
			exception = ex.toString();
		}  
		assertEquals("GradeSystem.NoSuchCommandExceptions", exception);
	}

}
