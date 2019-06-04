package pair02TestCode;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import pair02SourceCode.UI;

/*****************************************************************************
 * testPromptID1()
 * �� setIn �]�wconsole input�A�ϥΪ̿�J���r��Q 
	ByteArrayInputStream inContent = new ByteArrayInputStream("Q".getBytes());
	System.setIn(inContent);

	�� setOut�]�wconsole output
	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	System.setOut (new PrintStream (outContent));

	promptID return�ϥΪ̿�J�r��
	String result = promptID();  

	�w��promptID�|���"��JID�� Q (�����ϥ�)�H" 
	assertEquals("��JID�� Q (�����ϥ�)�H", outContent);
	assertEquals ("Q", result);
 * @throws Exception 
 * 
 *  testPromptID2()
 * 	�� setIn �]�wconsole input�A�ϥΪ̿�J���r�� 962001044 
	ByteArrayInputStream inContent = new ByteArrayInputStream("962001044".getBytes());
	System.setIn(inContent);

	�� setOut�]�wconsole output
	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	System.setOut (new PrintStream (outContent));

	 promptID return�ϥΪ̿�J�r��
	String result = promptID();  

	�w��promptID�|���"��JID�� Q (�����ϥ�)�H"
	assertEquals("��JID�� Q (�����ϥ�)�H", outContent);
	assertEquals ("962001044", result);
 * @throws Exception 
 
 *  testPromptID3()
 *  �� setIn �]�wconsole input�A�ϥΪ̿�J���r�� 1234567 
	ByteArrayInputStream inContent = new ByteArrayInputStream("1234567".getBytes());
	System.setIn(inContent);

	�� setOut�]�wconsole output
	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	System.setOut (new PrintStream (outContent));

	 promptID return�ϥΪ̿�J�r��
	String result = promptID();  

	�w��promptID�|���"��JID�� Q (�����ϥ�)�H" 
	assertEquals("��JID�� Q (�����ϥ�)�H", outContent);
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

		assertEquals(("��JID�� Q (�����ϥ�)�H\r\n").replaceAll("\\s+",""), outContent.toString().replaceAll("\\s+",""));
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

		assertEquals(("��JID�� Q (�����ϥ�)�H\r\n").replaceAll("\\s+",""), outContent.toString().replaceAll("\\s+",""));
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

		assertEquals(("��JID�� Q (�����ϥ�)�H\r\n").replaceAll("\\s+",""), outContent.toString().replaceAll("\\s+",""));
		assertEquals ("1234567", result);	
	}


}
