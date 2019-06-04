package pair02SourceCode;

/** **********************************************************************
class Grades  aGrade�x�sname, lab1, lab2, lab3, midtermExam, finalExam, totalGrade
calculateTotalGrade (weights)
Grades () { } //�غc�l
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
	* �N�s���`���O���_��
	* totalGrade���|�ˤ��J
	* @param weight �s���t�����
	* @return
	* @throws 
	*
	* Time estimate : �t��k�]�p��A�~�򦹸�T�A�p O (n)
	* Example:���禡�Q�I�s�A�N�s���`���O���_��
	**-------------------------------------------------------------------------------------------------------------*/
	public Integer calculateTotalGrade(Double weights[])
	{
		return (int) Math.round(this.lab1 * weights[0] + this.lab2 * weights[1] + this.lab3 * weights[2] + this.midtermExam * weights[3] + this.finalExam * weights[4]);
	}

}
