package pair02SourceCode;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

/** ***********************************************************************
*	class UI (user interface)  aUI�B�z�ϥάɭ�
*	double[5] weights;  
*	//��l�� lab1 0.1, lab2 0.1, lab3 0.1, midTerm 0.3, finalExam 0.4
*	//�`�Nweights ���M������1.0
*	
*	promptCommand()
*	promptID()
*	showFinishMsg()
*	showWelcomeMsg()
*	UI()  �غc aUI
*************************************************************************/
public class UI
{
	
	// UI() �غc�l �غc aGradeSystem
	GradeSystems aGradeSystem;
	Scanner input;

	/** ----------------------------------------------------------------------------------------------------------
		UI() �غc�l 
		try 
    		1.call GradeSystem() to�غc aGradeSystem
    
    		2.loop1 until Q (Quit)
		      1.promptID() to get user ID  ��JID�� Q (�����ϥ�)�H 
      		  2.checkID() to see if the ID is in aGradeSystem
      		  3.showWelcomeMsg()      ex. Welcome���§�
      		  4.loop2 until E (Exit)
        			promptCommand() to prompt for inputCommand 
      			end loop2
    		end loop1
    		
    		3.showFinishMsg()�����F
    		end try
	-------------------------------------------------------------------------------------------------------------- */
	public UI()
	{
		super();
		input = new Scanner(System.in);
		this.aGradeSystem = new GradeSystems();
	}

	/** -------------------------------------------------------------------------------------------------------------
	* ���_�ˬd��J�r��O�_�OG�BR�BW�BE�䤤���@�A�Y���O�h��X�ҥ~���p�A�Y�O�䤤���@�h�̦r�����۹����ʧ@
	*           G ��ܦ��Z (Grade) 
    *           R ��ܱƦW (Rank) 
    *           W ��s�t��  (Weight) 
    *           E ���}��� (Exit) 
    *           M ������ (Modify)
	*
	* @param 
	* @return command �Ω�P�O�O�_E
	* @throws NoSuchCommandExceptions �V 
	*			if  ���O�OG�BR�BW�BE�䤤���@ �h��X�ҥ~���p
	*
	* Time estimate : �t��k�]�p��A�~�򦹸�T�A�p O (n)
	* Example:1.�ù���J���OG�BR�BW�BE�䤤���@�h��X�ҥ~���p
	*         2.�ù���J�OG�BR�BW�BE�䤤���@�h�ݨ�ĪG
	-----------------------------------------------------------------------------------------------------------------*/
	/** -------------------------------------------------------------------------------------------------------------
	//	1. prompt user for inputCommand
	//	2. if inputCommand is not G (Grade),R (Rank), W (Weights), or E (Exit),
	//	   throws an object of NoSuchCommandException  end if
	//	3. if inputCommand is E (Exit) then break
	//	   else: G aGradeSystem.showGrade(ID), R showRank(ID), W updateWeights() end if
	//	4. �^�� true
	-----------------------------------------------------------------------------------------------------------------*/
	public String promptCommand(String id) throws NoSuchCommandExceptions
	{
		System.out.println("��J���O 1) G ��ܦ��Z (Grade)\n" + "      2) R ��ܱƦW (Rank)\n" 
						   + "      3) W ��s�t�� (Weight)\n" + "      4) E ���}��� (Exit)\n");
		
		String cmd = input.next();
		if (cmd.toUpperCase().equals("E")){}
		else if (cmd.toUpperCase().equals("G")){}
		else if (cmd.toUpperCase().equals("R")){}
		else if (cmd.toUpperCase().equals("W")){}
		else
			throw new NoSuchCommandExceptions();
		
		return cmd;
	}

	/** -------------------------------------------------------------------------------------------------------------
	* ���_�ˬd��J�r��O�_�OQ�A�Y���O�h���עҡA�Y�߫h���}
	*
	* @param 
	* @return ID �Ω�P�O�O�_Q
	* @throws 
	*
	* Time estimate : �t��k�]�p��A�~�򦹸�T�A�p O (n)
	* Example: 1.�Y�ù���J�߫h�{������
	*          2.�Y�ù���J���~ID�A�h��X�@NoSuchIDExceptions
	*          3.�Y�ù���J���TID�A�h�i�J���t�ξާ@����
	-----------------------------------------------------------------------------------------------------------------*/
	public String promptID()
	{
		System.out.println("��JID�� Q (�����ϥ�)�H");
		return input.next();
	}
	
	/** -------------------------------------------------------------------------------------------------------------
	* �ù����"�����F"
	*
	* @param 
	* @return 
	* @throws 
	*
	* Time estimate : �t��k�]�p��A�~�򦹸�T�A�p O (n)
	* Example:���禡�Q�I�s�A�N�|�b�ù��ݨ�"�����F"
	-----------------------------------------------------------------------------------------------------------------*/
	public void showFinishMsg()
	{
		System.out.println("�����F");
	}
	
	public void showStudentIdWrongMsg()
	{
		System.out.println("ID���F!");
	}

	/** -------------------------------------------------------------------------------------------------------------
	* �ھ�ID�ù����"Welcome �Y�Y�Y"
	*
	* @param 
	* @return 
	* @throws 
	*
	* Time estimate : �t��k�]�p��A�~�򦹸�T�A�p O (n)
	* Example:���禡�Q�I�s�A�N�|�b�ù��ݨ�"Welcome �Y�Y�Y"
	-----------------------------------------------------------------------------------------------------------------*/
	public void showWelcomeMsg(String id)
	{	
		for (Entry<String, Grades> map : aGradeSystem.aTree.entrySet())
		{
			if (map.getKey().equals(id)){
				System.out.println("Welcome " + map.getValue().name);
				break;
			}
		}
	}
}
