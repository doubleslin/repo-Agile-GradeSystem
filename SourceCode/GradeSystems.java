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
* class GradeSystems  aGradeSystem儲存a tree of anEntry objects with key ID and value aGrade
*
* containID (ID)  //看aGradeSystem有否含此ID
* GradeSystems () //建構 aGradeSystem
* showGrade (ID)
* showRank (ID)
* updateWeights ()
********************************************************/
//TreeMap <String, Grades> aGradeSystem; 
//String is the KEY (ID) class; Grades is the VALUE class
//用TreeMap class的object叫aGradeSystem來儲存anEntry objects. 它對應 KEY (即ID) 到 VALUE (即aGrade object)
//它是binary search tree 所以 右子樹的key大於root’s key見下面設計草圖

public class GradeSystems
{
	public TreeMap<String, Grades> aTree;
	static Double weights[] = { 0.1, 0.1, 0.1, 0.3, 0.4 };
	static Double newWeights[] = new Double[5];
	Scanner input  = new Scanner(System.in);

	/** -------------------------------------------------------------------------------------------------------------
	//	public GradeSystems ()  //建構 aGradeSystem
	//
	//	1. 開檔 input file “gradeInput.txt”
	//	2. 用Java TreeMap建構a tree of anEntry(key, value) objects叫 aGradeSystem
	//	3. read line
	//	4. while not endOfFile
	//	1.call Grades() 建構aGrade
	//	2.call Entry()建構 anEntry
	//	3用Java Scanner scan line,ID存key 其餘存aGrade(value) (key,value)即anEntry
	//	4 aGrade.calculateTotalGrade(weights) 回傳aTotalGrade把它存aGrade
	//	5 把 anEntry 存入 aGradeSystem
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
	* 檢查ID是否出現在ID列表中
	*
	* @param ID 要被檢查的ID
	* @return result 若此ID存在則回傳true，若不存在則false。
	* @throws NoSuchIDExceptions
	*         若不存在此ID則丟出此例外狀況
	*
	* Time estimate : 演算法設計後，才獲此資訊，如 O (n)
	* Example:1.ID不存在則丟出例外狀況
	*         2.ID存在則繼續執行程式
	-----------------------------------------------------------------------------------------------------------------*/
	/**---------------------------------------------------------------------
	//	1. for anEntry in aGradeSystem 
	//  2. if ID等於 ID of anEntry then return true end for 
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
	 O(n) n is aGradeSystem 內全班人數
	-----------------------------------------------------------------------------------------------------------------*/
	public int showGrade(String ID)
	{
		return this.aTree.get(ID).calculateTotalGrade(weights);
	}

	/** -------------------------------------------------------------------------------------------------------------
	// 1. 取得這 ID 的 theTotalGrade
	// 2. 令rank 為 1
	// 3. loop aGrade in aList if aTotalGrade > theTotalGrade then
	// rank加1(退1名) end loop
	// (逐一比較，單層迴圈)
	// 4. 回傳 rank
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
    // 1. showOldWeights() // 此三個private methods 不需 test code
	// 2. getNewWeights() 
	// 3. setWeights(weights)
	// 4. for anEntry in aGradeSystem calculateTotalGrade(weights) & save it end for
	// public containID(ID) 看 ID 是否含在 aGradeSystem內
    // end class GradeSystems
	-----------------------------------------------------------------------------------------------------------------*/
	public void updateWeights()
	{
		showOldWeights();
		Double[] w = setWeights();
		showNewWeights(w);

		System.out.println("以上正確嗎 ? Y (Yes) 或 N (No)");
		String cmd = input.next();
		if (cmd.toUpperCase().equals("Y"))
		{
			setNewWeights(w);
			System.out.println("更新成功");
		}
	}

	// 此三個private methods 不需 test code
	private void showOldWeights()
	{
		System.out.println("舊配分");
		String[] items = { "lab1", "lab2", "lab3", "mid-term", "final exam" };
		assert (items.length == weights.length);
		for (int i = 0; i < items.length; i++)
		{
			System.out.println(items[i]+"         "+Math.round(this.weights[i]*100)+"%");
		}
	}
	
	private void showNewWeights(Double[] w)
	{
		System.out.println("請確認新配分");
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
		System.out.println("輸入新配分");
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
