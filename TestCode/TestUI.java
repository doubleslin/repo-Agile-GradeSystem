package pair02TestCode;

import static org.junit.Assert.*;

import org.junit.Test;

import pair02SourceCode.UI;

/*****************************************************************************
 * 	�p�GUI class �S�ŧidata �S�k�p�W�ҥ�assertEquals �h���O�_�T���غc�X��object
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
