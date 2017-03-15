
import polyfun.Polynomial;
import Riemann.TestClasses.*;
import Riemann.PolyPracticeDM;

public class EvalTestDM {

	        public static void main(String[] args) 
	        {
	                PolyPracticeDM popeye = new PolyPracticeDM(); 
	                Polynomial poly = new Polynomial(new double[] {-6, -1}); 
	                System.out.println(popeye.eval(poly,2.5)); //popeye evaluates poly at 2.5
	        }
	}
