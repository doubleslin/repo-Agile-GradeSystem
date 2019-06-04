package pair02TestCode;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import pair02SourceCode.UI;

/*****************************************************************************
下面是method “showFinishMsg() ” 的部分的unit test code 用 setOut設定console output
public testShowFinishMsg()
1. final  ByteArrayOutputStream outContent = new ByteArrayOutputStream();
2. System.setOut (new printStream (outContent));
3. 呼叫showFinishMsg();
4. assertEquals(“結束了\r\n”, outContent);
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
		assertEquals("結束了\r\n".replaceAll("\\s+",""), outContent.toString().replaceAll("\\s+",""));
	}

}
