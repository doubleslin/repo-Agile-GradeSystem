package pair02TestCode;

import static org.junit.Assert.*;

import java.util.TreeMap;

import org.junit.Test;

import pair02SourceCode.GradeSystems;

/*****************************************************************************
 * - class TestContainID test case 1: ID 962001044 (正確 凌宗廷) test case 
 * 2: ID 96z001044 (2打成z) test case 
 * 3: ID 96200104 (漏最後4) test case 
 * 4: ID 123456789 (錯誤ID) test case 
 * 5: ID “” (empty string)
 ******************************************************************************/
public class TestContainID
{


	@Test
	public void testContainID1() throws Exception
	{
		String id = "962001044";
		GradeSystems gradeSystems = new GradeSystems();
		assertTrue(gradeSystems.containID(id));
	}
	
	@Test
	public void testContainID2() throws Exception
	{
		String id = "96z001044";
		GradeSystems gradeSystems = new GradeSystems();
		assertFalse(gradeSystems.containID(id));
	}
	
	@Test
	public void testContainID3() throws Exception
	{
		String id = "96200104";
		GradeSystems gradeSystems = new GradeSystems();
		assertFalse(gradeSystems.containID(id));
	}
	
	@Test
	public void testContainID4() throws Exception
	{
		String id = "123456789";
		GradeSystems gradeSystems = new GradeSystems();
		assertFalse(gradeSystems.containID(id));
	}
	
	@Test
	public void testContainID5() throws Exception
	{
		String id = "";
		GradeSystems gradeSystems = new GradeSystems();
		assertFalse(gradeSystems.containID(id));
	}
	

}
