package pair02SourceCode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import javax.xml.soap.Text;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

/**#################################################################################
*	本Grade system 讓使用者(學生)取得他的總成績total grade 及排名 rank.
*	total grade 基於配分weights 來算 而 weights可以update. 
*	Rank 表示此 total grade 在全班學生的分數排序
*
*	Input file: 全班學生的分數 例如
*	962001044 凌宗廷 87 86 98 88 87
*	962001051 李威廷 81 98 84 90 93
*	注意 data field names 如下: 
*	ID name lab1 lab2 lab3 midtermExam finalExam
################################################################################### */
public class Main
{
	static String input;
	static UI ui = new UI();
	static Scanner scanner = new Scanner(System.in);
	static String id;
	
	/**-------------------------------------------------------------------------------------------------------------
	 * IdExist Usage
	 * @return whether student ID that user input exist in system.
	 * 
	 * pseudo code: 
	 * 1. Ask ui to do checkID(input) to check whether input student ID exist in system.
	 * 2. If input student ID do exist, return true.
	 *    Otherwise, ask ui to show wrong message and return false.
	 * 
	 * Time estimate: O(N), N for number of students.
	 * 
	 * Example: input 555 (wrong student ID), print wrong message and return false.
	 *-------------------------------------------------------------------------------------------------------------*/
	private static boolean IdExist()
	{

		if (ui.aGradeSystem.containID(input) == false)
		{
			ui.showStudentIdWrongMsg();
			return false;
		}
		id = input;
		return true;
	}
	
	/**-------------------------------------------------------------------------------------------------------------
	 * UserInput Usage
	 * @return 0, 1 or 2 to distinguish user input. 
	 * 
	 * 0, shut down system
	 * 1, user id wrong, re-ask user to enter ID or Quit
	 * 2, continue to Function Mode
	 * 
	 * * pseudo code: 
	 * 1. If input string equal to "Q", ask ui to show finish message and return 0.
	 *    Otherwise, if user input student ID do not exist, return 1.
	 *    Other situations return 2.
	 * 
	 * Time estimate: O(N), N for number of students.
	 * 
	 * Example: input Q, print finish message and return 0.
	 **-------------------------------------------------------------------------------------------------------------*/
	private static int UserInput()
	{
		if (input.toUpperCase().equals("Q"))
		{
			ui.showFinishMsg();
			return 0;
		}
		// check whether input student ID exit in system
		else
		{
			// if student ID didn't exist, continue to another run
			if (IdExist() == false)
				return 1;
		}
		return 2;
	}
	
	/**-------------------------------------------------------------------------------------------------------------
	 * functionMode Usage
	 * 1st, Welcome user log in system, and indicate them their are 5 different commands(G, R, A, W, E).
	 * 2nd, ask user enter command or log out.
	 * 
	 * pseudo code: 
	 * 1. Ask ui to show welcome message.
	 * 2. Use a loop to wait user to enter command (G, R, A, W or E).
	 *    If user enter E, break the loop.
	 * 
	 * Time estimate: O(N), N for number of students.
	 * 
	 * Example: input E, break the loop.
	 * @throws NoSuchCommandExceptions 
	 **-------------------------------------------------------------------------------------------------------------*/
	private static void functionMode() throws NoSuchCommandExceptions
	{
		// show some welcome message
		ui.showWelcomeMsg(input);

		// ask user to enter G, R, A, W or E
		while (true)
		{
			input = ui.promptCommand(input);

			if (input.toUpperCase().equals("G"))
			{
				System.out.println(ui.aGradeSystem.showGrade(id));
			}
			else if (input.toUpperCase().equals("R"))
			{
				System.out.println(ui.aGradeSystem.showRank(id));
			}
			else if (input.toUpperCase().equals("W"))
			{
				ui.aGradeSystem.updateWeights();
			}
			else if (input.toUpperCase().equals("E"))
			{
				break;
			}
		}
	}
	
	/**-------------------------------------------------------------------------------------------------------------
	 * main Usage
	 * 1st, welcome user and ask them to use student ID to log in.
	 * 2nd, ask user to enter command.
	 * 
	 * pseudo code: 
	 * 1. Ask ui to show welcome message.
	 * 2. If user input Q, break the loop.
	 * 3. If user input wrong student ID, continue to re-ask user input ID or Q.
	 * 4. Else, enter function mode.
	 * 
	 * Time estimate: O(N), N for number of students.
	 * 
	 * Example: input E, break the loop and shut down whole system.
	 * @throws NoSuchCommandExceptions 
	 **-------------------------------------------------------------------------------------------------------------*/
	public static void main(String[] args) throws NoSuchCommandExceptions
	{
		while (true)
		{
			// indicate user to enter student ID or quit System
			input = ui.promptID();
			/* user enter ID or Q */
			int InputReact = UserInput();
			if (InputReact == 0)
				break;
			else if (InputReact == 1)
				continue;
			/* user enter G, R, A, W or E */
			functionMode();
		}
		scanner.close();
	}

}
