package pair02TestCode;

import static org.junit.Assert.*;

import org.junit.Test;

import pair02SourceCode.GradeSystems;

/*****************************************************************************
 * - class TestShowWelcomeMsg test case 
 * 1: ID 955002056 (TotalGrade = 91) test case 
 * @throws Exception 
 ******************************************************************************/
public class TestShowGrade
{

	@Test
	public void testShowGrade1() throws Exception
	{
		GradeSystems gradeSystems = new GradeSystems();
		assertEquals(93, gradeSystems.showGrade("955002056"));
	}

}
