package pair02TestCode;

import static org.junit.Assert.*;

import org.junit.Test;

import pair02SourceCode.GradeSystems;

/*****************************************************************************
 * - class TestShowRank test case 
 * 1: ID 985002515 (²Ä¤@¦W) test case 
 * @throws Exception 
 ******************************************************************************/
public class TestShowRank
{

	@Test
	public void testShowRank1() throws Exception
	{
		GradeSystems gradeSystems = new GradeSystems();
		assertEquals(1, gradeSystems.showRank("985002515"));
	}
}
