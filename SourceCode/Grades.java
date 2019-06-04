package pair02SourceCode;

/** **********************************************************************
class Grades  aGrade儲存name, lab1, lab2, lab3, midtermExam, finalExam, totalGrade
calculateTotalGrade (weights)
Grades () { } //建構子
************************************************************************/
public class Grades
{
	String name;
	Integer lab1;
	Integer lab2;
	Integer lab3;
	Integer midtermExam;
	Integer finalExam;
	Integer totalGrade;
	
	public Grades()
	{
		super();
	}

	public Grades(String name, Integer lab1, Integer lab2, Integer lab3, Integer midtermExam, Integer finalExam)
	{
		super();
		Double weights[] = GradeSystems.weights;
		this.name = name;
		this.lab1 = lab1;
		this.lab2 = lab2;
		this.lab3 = lab3;
		this.midtermExam = midtermExam;
		this.finalExam = finalExam;
		this.totalGrade = calculateTotalGrade(weights);
	}
	
	/**-------------------------------------------------------------------------------------------------------------
	* 將新的總分記錄起來
	* totalGrade須四捨五入
	* @param weight 新的配分比例
	* @return
	* @throws 
	*
	* Time estimate : 演算法設計後，才獲此資訊，如 O (n)
	* Example:當此函式被呼叫，將新的總分記錄起來
	**-------------------------------------------------------------------------------------------------------------*/
	public Integer calculateTotalGrade(Double weights[])
	{
		return (int) Math.round(this.lab1 * weights[0] + this.lab2 * weights[1] + this.lab3 * weights[2] + this.midtermExam * weights[3] + this.finalExam * weights[4]);
	}

}
