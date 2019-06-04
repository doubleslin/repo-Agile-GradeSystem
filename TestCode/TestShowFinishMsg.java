package pair02TestCode;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import pair02SourceCode.UI;

/*****************************************************************************
�U���Omethod ��showFinishMsg() �� ��������unit test code �� setOut�]�wconsole output
public testShowFinishMsg()
1. final  ByteArrayOutputStream outContent = new ByteArrayOutputStream();
2. System.setOut (new printStream (outContent));
3. �I�sshowFinishMsg();
4. assertEquals(�������F\r\n��, outContent);
 ******************************************************************************/
public class TestShowFinishMsg
{


	@Test
	public void testShowFinishMsg() throws Exception
	{
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut (new PrintStream (outContent));
		UI aUi=new UI();
		aUi.showFinishMsg();
		assertEquals("�����F\r\n".replaceAll("\\s+",""), outContent.toString().replaceAll("\\s+",""));
	}

}
