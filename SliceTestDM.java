package TestClasses;

import Riemann.*;
import polyfun.Polynomial;
/*
 * Testing calculation for slice area
 * @Gomp
 * @Davey (for adding trap)
 * tests the slice functions for Left HR, Right HR, and Trap Rule
 * 
 * Documentation: DONE
 */
public class SliceTestDM 
{
        public static void main(String[] args) 
        {
                LHR_DM LHR = new LHR_DM();  //LeftHandRule extends Riemann
                RHR_DM RHR = new RHR_DM();  //RightHandRule extends Riemann
                TrapRuleDM TR= new TrapRuleDM(); //TrapezoidRule extends Riemann
        
                Polynomial p = new Polynomial(new double[] {0,4,0,3}); // p=3x^3+4x
                
                System.out.println(LHR.slice(p,1, 1.1)+"\n"); //the area of a left hand rule slice of 3x^3+4x, from x=1 to x=1.1
                
                System.out.println(RHR.slice(p,1,1.1)+"\n"); //the area of a rightt hand rule slice of 3x^3+4x, from x=1 to x=1.1
                
                System.out.println(TR.slice(p,1,1.1)+"\n"); //the area of a trapezoid rule slice of 3x^3+4x, from x=1 to x=1.1
        }
}
