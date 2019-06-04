package pair02TestCode;

import static org.junit.Assert.*;

import org.junit.Test;

import pair02SourceCode.Grades;

/*****************************************************************************	
 *  最後是 testGrades1() : (因testGradeSystems1已測aGrade內值 故只測是否建構此object)
	testGrades1() {assertNotNull (new Grades() ); }
******************************************************************************/

public class TestGrades
{

	@Test
	public void testGrades1()
	{
		assertNotNull(new Grades());
	}

}
