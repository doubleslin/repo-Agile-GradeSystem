package pair02TestCode;

import static org.junit.Assert.*;

import org.junit.Test;

import pair02SourceCode.UI;

/*****************************************************************************
 * 	如果UI class 沒宣告data 沒法如上例用assertEquals 則測是否確有建構出此object
	testUI1() {assertNotNull ( new UI() );}
 ******************************************************************************/
public class TestUI
{

	@Test
	public void testUI1() throws Exception
	{
		assertNotNull(new UI());
	}
}
