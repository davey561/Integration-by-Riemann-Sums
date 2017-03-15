package Riemann;
import org.opensourcephysics.display.DrawableShape;
import org.opensourcephysics.display.Trail;
import org.opensourcephysics.frames.PlotFrame;

import polyfun.Polynomial;

/*
 * Daughter Class of Riemann: Simpson's Rule
 * @Davey
 * Interpolates three points, left, midpoint, and right, on graph in each subinterval to form parabola as top of each slice. The bottom of the slice is still rectangular
 * 
 * Documentation: DONE
 * 
 * CALC AREA UNDER
 */

public class SimpsonsRuleDM extends RiemannDM{
	//Simpson's rule: the "top" of the slice lies on the graph of the quadratic function which passes through the points (a,p(a)), (m,p(m)), and (b,p(b)).
	/**
	 * finds area of slice for subinterval
	 * @param poly given poly
	 * @param sleft left constraint of interval
	 * @param sright right constraint of interval
	 * @return
	 */
	//public double slice(Polynomial poly, double sleft, double sright) {
	// (involves taking area under the curve) return (sright-sleft)*(PolyPracticeDM.eval(poly, sright));
	//}

	/**
	 * draws the region whose area is calculated by slice.
	 */
	public double slice(Polynomial poly, double sleft, double sright){
		double area = 0;
		return area;
	}
	public void slicePlot(PlotFrame pframe, Polynomial poly, double a, double b) {
		//finding parabola
		//define coordinates of three points
		double m = (a+b)/2; //midpoint of subinterval (average of right and left sides)
		double pa = PolyPracticeDM.eval(poly, a); // poly evaluated at a
		double pb = PolyPracticeDM.eval(poly, b);// poly evaluated at b
		double pm = PolyPracticeDM.eval(poly, m);// poly evaluated at m
		double A; //coefficient of degree 2 term
		double B; //coefficient of degree 1 term
		double C; //coefficient of degree 0 term (constant)

		//calculate A coefficient in standard form
		//plugging B in
		
		
		/*
		 * steps of interpolation calcs:
		 * 1. set up a system of three quadratic equations, each with x and y values filled in (e.g., with pa and a) 
		 * 2. use subtractive elimination to combine equation 1 and 2, then equations 1 and 3 (which should eliminate C both times)
		 * 3. solve for B in one of the equations in terms of the given coordinates of the three points and A
		 * 4. substitute this value for B into other equation, and solve for A (solution is shown below)
		 * 5. then find B in terms of A
		 * 6. then find C in terms of A and B
		 * *can be done differently as well, these were just my steps
		 */
		A = (pa*(b-m)+ pm*(a-b) + pb*(m-a))/((a-b)*(a-m)*(b-m)); //after interpolation, this is what was yielded for A
		B = (pa - pm)/(a-m) - A*(a + m); //B follows from A
		C = pa - A*a*a - B*a;// and C follows from B and A

		//define polynomial
		Polynomial interp = new Polynomial(new double[] {C,B,A}); //interpolated quadratic
		interp.print(); //printing equation
	
		Trail simps = new Trail();//new trail to visually represent this particular slice
		simps.addPoint(a, 0); // add (a,0)
		simps.addPoint(b, 0); //add (b,0) and connect line to here
		simps.addPoint(b,PolyPracticeDM.eval(poly, b)); //add (b, p(b)), and connect line here
		//plotting parabola top:
		for (double i = b; i>a; i= i-0.004){ 		//for each tenth of a unit along the x axis, plot a point
			simps.addPoint(i, PolyPracticeDM.eval(interp, i)); // add all points between left and right slice constraints that are on the interpolated quadratic
		}
		simps.addPoint(a,PolyPracticeDM.eval(poly, a)); //add (a, p(a)) and connect line here
		simps.closeTrail(); //connect line between starting point and last point
		pframe.addDrawable(simps); //add this slice plotframe
	}
}
