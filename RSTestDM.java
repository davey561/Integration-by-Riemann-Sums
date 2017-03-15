package TestClasses;


import Riemann.*;
import polyfun.Polynomial;

/*
 * Riemann Sum Calculator Tester
 * @Gomp for base of class
 * @Davey for adding trap rule
 * tests the calculation of area under a curve using Left hand rule, Right hand rule, and Trap rule
 * 
 * Documentation: DONE
 */
public class RSTestDM
{

	/**
	 * main
	 * @param args
	 */
	public static void main(String[] args) 
	{
		LHR_DM LHR = new LHR_DM();  //LeftHandRule extends Riemann
		RHR_DM RHR = new RHR_DM();  //RightHandRule extends Riemann
		TrapRuleDM TR= new TrapRuleDM(); //TrapezoidRule extends Riemann

		Polynomial p = new Polynomial(new double[] {0,0,3}); //p=3x^2

		System.out.println(LHR.rs(p, 0.0, 1.0, 2000)+"\n"); //the approximate area under 3x^2, from 0 to 1, using the left hand rule

		System.out.println(RHR.rs(p, 0.0, 1.0, 2000)+"\n"); //the approximate area under 3x^2, from 0 to 1, using the right hand rule

		System.out.println(TR.rs(p, 0.0, 1.0, 2000)+"\n"); //the approximate area under 3x^2, from 0 to 1, using the trapezoid rule
	}
}
