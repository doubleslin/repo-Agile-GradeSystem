package pair02TestCode;

import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

import pair02SourceCode.GradeSystems;
import pair02SourceCode.NoSuchCommandExceptions;
import pair02SourceCode.NoSuchIDExceptions;

/*****************************************************************************
 * Unit test
 * test method updateWeights()
 * case1:input "20 20 20 20 20 Y"
 * case2:input "30 10 20 10 30 Y"

 ******************************************************************************/
public class TestUpdateWeights
{	


	@Test
	public void testGradeSystemUpdateWeight1() throws NoSuchIDExceptions, NoSuchCommandExceptions
	{

		ByteArrayInputStream inContent = new ByteArrayInputStream("20 20 20 20 20 Y\n".getBytes());
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		System.setIn(inContent);
		System.setOut(new PrintStream(outContent));
		
		try
		{
			GradeSystems gradeSystem = new GradeSystems();
			gradeSystem.updateWeights();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.getStackTrace();
		}

		String oldGrade = "舊配分\r\nlab1        10%\r\nlab2        10%\r\nlab3        10%\r\nmid-term         30%\r\nfinal exam         40%\r\n";
		String cmdGrade = "輸入新配分\r\nlab1        \r\nlab2        \r\nlab3        \r\nmid-term       \r\nfinal exam       \r\n";
		String newGrade = "請確認新配分\r\nlab1        20%\r\nlab2        20%\r\nlab3        20%\r\nmid-term       20%\r\nfinal exam       20%\r\n";
		String checkCmd = "以上正確嗎 ? Y (Yes) 或 N (No)\r\n";
		String updateCmd = "更新成功\r\n";
		assertEquals((oldGrade + cmdGrade + newGrade + checkCmd + updateCmd).replaceAll("\\s+", ""), outContent.toString().replaceAll("\\s+", ""));
		// '\r'使游標移到行首，'\n'是換行。通常用的Enter是兩個加起來。 string.replaceAll("\\s+","")可將字串中所有空白消除;
		// \s 指的是空白字元，\s+ 是連續多個空白字元，要打成 "\\s+"，第一個反斜線類似跳脫字元。
	}
	
	@Test
	public void testGradeSystemUpdateWeight2() throws NoSuchIDExceptions, NoSuchCommandExceptions
	{

		ByteArrayInputStream inContent = new ByteArrayInputStream("30 10 20 10 30 Y\n".getBytes());
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		System.setIn(inContent);
		System.setOut(new PrintStream(outContent));
		
		try
		{
			GradeSystems gradeSystem = new GradeSystems();
			gradeSystem.updateWeights();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.getStackTrace();
		}

		String oldGrade = "舊配分\r\nlab1        20%\r\nlab2        20%\r\nlab3        20%\r\nmid-term         20%\r\nfinal exam         20%\r\n";
		String cmdGrade = "輸入新配分\r\nlab1        \r\nlab2        \r\nlab3        \r\nmid-term       \r\nfinal exam       \r\n";
		String newGrade = "請確認新配分\r\nlab1        30%\r\nlab2        10%\r\nlab3        20%\r\nmid-term       10%\r\nfinal exam       30%\r\n";
		String checkCmd = "以上正確嗎 ? Y (Yes) 或 N (No)\r\n";
		String updateCmd = "更新成功\r\n";
		assertEquals((oldGrade + cmdGrade + newGrade + checkCmd + updateCmd).replaceAll("\\s+", ""), outContent.toString().replaceAll("\\s+", ""));
	}

}
