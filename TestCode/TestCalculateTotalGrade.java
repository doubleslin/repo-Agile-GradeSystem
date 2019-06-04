package pair02TestCode;

import static org.junit.Assert.*;

import org.junit.Test;

import pair02SourceCode.Grades;

/*****************************************************************************-
class CalculateTotalGradeTest 
aGrade: name李威廷 lab1 81  lab2 98  lab3 84  midtermExam 90 finalExam 93

test case 1: lab1 0.1  lab2 0.1  lab3 0.1  midtermExam 0.3  finalExam 0.4
			 81*0.1+98*0.1+84*0.1+90*0.3+93*0.4 = 91 四捨五入
test case 2: lab1 0.2  lab2 0.2  lab3 0.2  midTermExam 0.2  finalExam 0.2
		     81*0.2+98*0.2+84*0.2+90*0.2+93*0.2 = 89 四捨五入
test case 3: lab1 0.1  lab2 0.1  lab3 0.0  midtermExam 0.4  finalExam 0.4
			 81*0.1+98*0.1+84*0.0+90*0.4+93*0.4 = 91 四捨五入
**************************************************************************** */
public class TestCalculateTotalGrade
{
	
	@Test
	public void testCalculateTotalGrade1() throws Exception
	{
		Double weights[] = { 0.1, 0.1, 0.1, 0.3, 0.4 };
		Grades aGrade = new Grades("李威廷",81,98,84,90,93);
		int totalGrade = aGrade.calculateTotalGrade(weights);
		assertEquals(91, totalGrade);
	}
	
	@Test
	public void testCalculateTotalGrade2() throws Exception
	{
		Double weights[] = { 0.2, 0.2, 0.2, 0.2, 0.2 };
		Grades aGrade = new Grades("李威廷",81,98,84,90,93);
		int totalGrade = aGrade.calculateTotalGrade(weights);
		System.out.println(totalGrade);
		assertEquals(89, totalGrade);
	}
	
	@Test
	public void testCalculateTotalGrade3() throws Exception
	{
		Double weights[] = { 0.1, 0.1, 0.0, 0.4, 0.4 };
		Grades aGrade = new Grades("李威廷",81,98,84,90,93);
		int totalGrade = aGrade.calculateTotalGrade(weights);
		System.out.println(totalGrade);
		assertEquals(91, totalGrade);
	}


}
