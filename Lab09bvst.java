// Lab09bvst.java
// The Rational Class Program II
// This is the student, starting version of the Lab09b assignment.


import java.util.Scanner;


public class Lab09bvst
{
	private static int num1, den1;   // numerator and denominator of the 1st rational number
	private static int num2, den2;   // numerator and denominator of the 2nd rational number

	public static void main (String args[])
	{
		enterData();

		Rational r1 = new Rational(num1,den1);
		Rational r2 = new Rational(num2,den2);
		Rational r3 = new Rational();

		r3.multiply(r1,r2);
		System.out.println("\n\n" + r1.getOriginal() + " * " + r2.getOriginal() + "  =  " + r3.getReduced());
		r3.divide(r1,r2);
		System.out.println("\n" + r1.getOriginal() + " / " + r2.getOriginal() + "  =  " + r3.getReduced());
//		100 Point Version Only
		r3.add(r1,r2);
		System.out.println("\n" + r1.getOriginal() + " + " + r2.getOriginal() + "  =  " + r3.getReduced());
		r3.subtract(r1,r2);
		System.out.println("\n" + r1.getOriginal() + " - " + r2.getOriginal() + "  =  " + r3.getReduced());
		System.out.println();
	}

	public static void enterData()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter the 1st numerator ----> ");
		num1 = input.nextInt();
		System.out.print("\nEnter the 1st denominator --> ");
		den1 = input.nextInt();
		System.out.print("\nEnter the 2nd numerator ----> ");
		num2 = input.nextInt();
		System.out.print("\nEnter the 2nd denominator --> ");
		den2 = input.nextInt();
	}
}


class Rational
{
	private int firstNum;	   // entered numerator
	private int firstDen;	   // entered denominator
	private int reducedNum;		// reduced numerator
	private int reducedDen;		// reduced denominator
  private int gcf;           // greatest common factor
//added!
	public Rational(int firstNum, int firstDen){
	this.firstNum = firstNum;
	this.firstDen= firstDen;
}
	public Rational(){
		firstNum = 1;
		firstDen = 1;
	}
	public String getOriginal(){
		String original = "" + firstNum + "/" + firstDen;
		return original;
	}

	// Defining a method -> expectations are defined
	public int multiply(Rational n1, Rational n2){
		firstNum = n1.firstNum * n2.firstNum;
		firstDen = n1.firstDen * n2.firstDen;
		reduce();
		return firstNum / firstDen;
	}
	public int divide(Rational n1, Rational n2){
		firstNum = n1.firstNum* n2.firstDen;
		firstDen = n1.firstDen * n2.firstNum;
		reduce();
		return firstNum / firstDen;
	}
	public int add(Rational n1, Rational n2){
		firstNum = (n1.firstNum * n2.firstDen) + (n2.firstNum * n1.firstDen);
		firstDen = (n1.firstDen * n2.firstDen);
		reduce();
		return firstNum / firstDen;
	}
	public int subtract(Rational n1, Rational n2){
		firstNum = (n1.firstNum * n2.firstDen) - (n2.firstNum * n1.firstDen);
		firstDen = (n1.firstDen * n2.firstDen);
		reduce();
		return firstNum / firstDen;
	}

	public void reduce(){
		getGCF(firstNum, firstDen);
		reducedNum = firstNum / gcf;
		reducedDen = firstDen / gcf;
	}
	public String getReduced(){
		reduce();
		String reducedFraction = "" + reducedNum + "/" + reducedDen;
		return reducedFraction;
	}

	private void getGCF(int n1,int n2)
	{
		int rem = 0;
		do
		{
			rem = n1 % n2;
			if (rem == 0)
				gcf = n2;
			else
			{
				n1 = n2;
				n2 = rem;
			}
		}
		while (rem != 0);
	}


}
