package Riemann;
import polyfun.Polynomial;

public class AddXsquaredTest {

        public static void main(String[] args) 
        {
                PolyPracticeDM popeye = new PolyPracticeDM(); 
                Polynomial poly = new Polynomial(new double[] {-6,-1}); 
                popeye.addXsquared(poly); //popeye adds x^2 to poly, and then both prints and graphs the resulting polynomial
        }
}
