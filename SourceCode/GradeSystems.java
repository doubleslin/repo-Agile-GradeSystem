package pair02SourceCode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

/** ***************************************************
* class GradeSystems  aGradeSystem�x�sa tree of anEntry objects with key ID and value aGrade
*
* containID (ID)  //��aGradeSystem���_�t��ID
* GradeSystems () //�غc aGradeSystem
* showGrade (ID)
* showRank (ID)
* updateWeights ()
********************************************************/
//TreeMap <String, Grades> aGradeSystem; 
//String is the KEY (ID) class; Grades is the VALUE class
//��TreeMap class��object�saGradeSystem���x�sanEntry objects. ������ KEY (�YID) �� VALUE (�YaGrade object)
//���Obinary search tree �ҥH �k�l��key�j��root��s key���U���]�p���

public class GradeSystems
{
	public TreeMap<String, Grades> aTree;
	static Double weights[] = { 0.1, 0.1, 0.1, 0.3, 0.4 };
	static Double newWeights[] = new Double[5];
	Scanner input  = new Scanner(System.in);

	/** -------------------------------------------------------------------------------------------------------------
	//	public GradeSystems ()  //�غc aGradeSystem
	//
	//	1. �}�� input file ��gradeInput.txt��
	//	2. ��Java TreeMap�غca tree of anEntry(key, value) objects�s aGradeSystem
	//	3. read line
	//	4. while not endOfFile
	//	1.call Grades() �غcaGrade
	//	2.call Entry()�غc anEntry
	//	3��Java Scanner scan line,ID�skey ��l�saGrade(value) (key,value)�YanEntry
	//	4 aGrade.calculateTotalGrade(weights) �^��aTotalGrade�⥦�saGrade
	//	5 �� anEntry �s�J aGradeSystem
	//	     end while
	-----------------------------------------------------------------------------------------------------------------*/
	public GradeSystems()
	{
		super();
		this.aTree = getAllGrade();
	}

	public TreeMap<String, Grades> getAllGrade()
	{	
		TreeMap<String, Grades> aGradeSystem = new TreeMap<String, Grades>();
		try
		{
			FileReader fr = new FileReader("../Pair02/src/pair02SourceCode/gradeInput.txt");
			BufferedReader br = new BufferedReader(fr);
			while (br.ready())
			{
				String str = br.readLine();
				String arg[] = str.split(" ");
				Grades aGrade = new Grades(arg[1], Integer.parseInt(arg[2]), Integer.parseInt(arg[3]), Integer.parseInt(arg[4]), Integer.parseInt(arg[5]), Integer.parseInt(arg[6]));
				aGradeSystem.put(arg[0], aGrade);
			}
			fr.close();
		}
		catch (Exception e)
		{
			System.out.println("Loading error");
			e.printStackTrace();
		}
		return aGradeSystem;
	}

	/** -------------------------------------------------------------------------------------------------------------
	* �ˬdID�O�_�X�{�bID�C��
	*
	* @param ID �n�Q�ˬd��ID
	* @return result �Y��ID�s�b�h�^��true�A�Y���s�b�hfalse�C
	* @throws NoSuchIDExceptions
	*         �Y���s�b��ID�h��X���ҥ~���p
	*
	* Time estimate : �t��k�]�p��A�~�򦹸�T�A�p O (n)
	* Example:1.ID���s�b�h��X�ҥ~���p
	*         2.ID�s�b�h�~�����{��
	-----------------------------------------------------------------------------------------------------------------*/
	/**---------------------------------------------------------------------
	//	1. for anEntry in aGradeSystem 
	//  2. if ID���� ID of anEntry then return true end for 
	//	3. throw an object of NoSuchIDExceptions
	-------------------------------------------------------------------------- */
	public boolean containID(String ID)
	{
		boolean flag = false;
		if (this.aTree.get(ID) != null)
			flag = true;
		return flag;
	}

	/**-------------------------------------------------------------------------------------------------------------
	 showGrade (ID) return String parameter: ID a user ID ex: 123456789 time:
	 O(n) n is aGradeSystem �����Z�H��
	-----------------------------------------------------------------------------------------------------------------*/
	public int showGrade(String ID)
	{
		return this.aTree.get(ID).calculateTotalGrade(weights);
	}

	/** -------------------------------------------------------------------------------------------------------------
	// 1. ���o�o ID �� theTotalGrade
	// 2. �Orank �� 1
	// 3. loop aGrade in aList if aTotalGrade > theTotalGrade then
	// rank�[1(�h1�W) end loop
	// (�v�@����A��h�j��)
	// 4. �^�� rank
	-----------------------------------------------------------------------------------------------------------------*/
	public int showRank(String ID)
	{
		int theTotalGrade = this.showGrade(ID);
		int rank = 1;

		for (Entry<String, Grades> anEntry : this.aTree.entrySet())
		{
			if (anEntry.getValue().totalGrade > theTotalGrade)
				rank += 1;
		}
		return rank;
	}

	/** -------------------------------------------------------------------------------------------------------------
	// public updateWeights () 
    // 1. showOldWeights() // ���T��private methods ���� test code
	// 2. getNewWeights() 
	// 3. setWeights(weights)
	// 4. for anEntry in aGradeSystem calculateTotalGrade(weights) & save it end for
	// public containID(ID) �� ID �O�_�t�b aGradeSystem��
    // end class GradeSystems
	-----------------------------------------------------------------------------------------------------------------*/
	public void updateWeights()
	{
		showOldWeights();
		Double[] w = setWeights();
		showNewWeights(w);

		System.out.println("�H�W���T�� ? Y (Yes) �� N (No)");
		String cmd = input.next();
		if (cmd.toUpperCase().equals("Y"))
		{
			setNewWeights(w);
			System.out.println("��s���\");
		}
	}

	// ���T��private methods ���� test code
	private void showOldWeights()
	{
		System.out.println("�°t��");
		String[] items = { "lab1", "lab2", "lab3", "mid-term", "final exam" };
		assert (items.length == weights.length);
		for (int i = 0; i < items.length; i++)
		{
			System.out.println(items[i]+"         "+Math.round(this.weights[i]*100)+"%");
		}
	}
	
	private void showNewWeights(Double[] w)
	{
		System.out.println("�нT�{�s�t��");
		String[] items = { "lab1", "lab2", "lab3", "mid-term", "final exam" };
		assert (items.length == weights.length);
		for (int i = 0; i < items.length; i++)
		{
			System.out.println(items[i]+"         "+Math.round(w[i]*100)+"%");
		}
	}

	private void setNewWeights(Double[] w)
	{
		this.weights = w;
	}

	private Double[] setWeights()
	{
		System.out.println("��J�s�t��");
		Double newWeights[] = new Double[5];
		String[] items = { "lab1", "lab2", "lab3", "mid-term", "final exam" };
		for (int i = 0; i < items.length; i++)
		{
			System.out.print(items[i] + "       ");
			newWeights[i] = input.nextDouble()/100;
		}
		return newWeights;
	}

}
