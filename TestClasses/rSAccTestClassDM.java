package TestClasses;
import polyfun.Polynomial;
import org.opensourcephysics.frames.*;
import Riemann.LHR_DM;
import Riemann.RHR_DM;
import Riemann.TrapRuleDM;

/*
 * Accumulation Function Test Class
 * @Gomp
 * @Davey
 * 
 * Documentation: DONE
 * 
 * basic rule tests provided by Gomp, trap added by Davey
 * ADD SIMPSONS
 */

public class rSAccTestClassDM
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
                        
                Polynomial p = new Polynomial(new double[] {0,1,1}); // p=x^2+x
        
                PlotFrame f = new PlotFrame("x","y","Left Hand Rule Accumulation Function Graph");
                f.setPreferredMinMaxX(-3, 3); // x values range from -3 to 3
                f.setDefaultCloseOperation(3);
                f.setVisible(true);
                        
                PlotFrame g = new PlotFrame("x","y","Right Hand Rule Accumulation Function Graph");
                g.setPreferredMinMaxX(-3, 3); // x values range from -3 to 3
                g.setDefaultCloseOperation(3);
                g.setVisible(true);
                        
                PlotFrame i = new PlotFrame("x","y","Trapezoid Rule Accumulation Function Graph");
                i.setPreferredMinMaxX(-3, 3); // x values range from -3 to 3
                i.setDefaultCloseOperation(3);                  
                i.setVisible(true);
                        
                LHR.rsAcc(f, p, 2, .01, -1.0); //plots the left hand rule acccumulation function of x^2+x, with base x=-1;
                        
                RHR.rsAcc(g, p, 2, .01, -1.0); //plots the right hand rule acccumulation function of x^2+x, with base x=-1;
                        
                TR.rsAcc(i, p, 2, .01, -1.0); //plots the trapezoid rule acccumulation function of x^2+x, with base x=-1;   
                System.out.println("AK will lose BC at HM");
        }
}       

