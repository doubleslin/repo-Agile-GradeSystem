package pair02TestCode;

import static org.junit.Assert.*;

import java.util.TreeMap;

import org.junit.Test;

import pair02SourceCode.GradeSystems;
import pair02SourceCode.Grades;

/*****************************************************************************	
	 *  testGradeSystrems1() (測建構的aGradeSystem object的root的lab1是否正確)
		1.	aTree = new GradeSystems();
		2.	assert equality of: 1) 87 and  2) aTree.aGrade.lab1
		
	*  testGradeSystrems2() (測aGradeSystem object的root的right subtree的lab1是否正確)
		1.	aTree = new GradeSystems();
		2.	assert equality of: 1) 81 and  2) aTree.right.aGrade.lab1
******************************************************************************/
public class TestGradeSystems
{
	
	@Test
	public void testGradeSystems1()
	{
		assertNotNull(new GradeSystems());
	}

	@Test
	public void testGradeSystems2()
	{
		TreeMap<String, Grades> aTree  =new GradeSystems().aTree;
//		assertEquals("87", aTree.promptCommand("962001044"));	
	}


	@Test
	public void testGradeSystems3()
	{
		TreeMap<String, Grades> aTree  =new GradeSystems().aTree;
//		assert equality of: 1) 81 and  2) aTree.right.aGrade.lab1
	}

}
