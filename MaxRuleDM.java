package Riemann;
import org.opensourcephysics.display.DrawableShape;
import org.opensourcephysics.frames.PlotFrame;

import polyfun.Polynomial;
/*
 * Maximum Rule, a Daughter Class of Riemann
 * calculates rectangular slices with height of larger btw. p(left side) and p(right side)
 * @author Davey
 */
public class MaxRuleDM extends RiemannDM{
	/**
	 * finds area of slice for subinterval
	 * @param poly given polynomial
	 * @param sleft left x value of slice
	 * @param sright x value for right of slice
	 * @return area of slice
	 */
	public double slice(Polynomial poly, double sleft, double sright) {
		if((PolyPracticeDM.eval(poly, sright)<PolyPracticeDM.eval(poly, sleft))){ //if p(right side) is larger
			return (sright-sleft)*(PolyPracticeDM.eval(poly, sright));
		}
		else {
			return (sright-sleft)*(PolyPracticeDM.eval(poly, sleft)); //else
		}
	}

	/**
	 * draws the region whose area is calculated by slice.
	 * @param pframe given plot frame
	 * @param poly given polynomial
	 * @param sleft x value of left edge of slice
	 * @param sright x value of right edge of slice
	 */
	public void slicePlot(PlotFrame pframe, Polynomial poly, double sleft, double sright) {
		if (PolyPracticeDM.eval(poly, sright)<PolyPracticeDM.eval(poly, sleft)){ //if p(right side) is larger
			pframe.addDrawable(DrawableShape.createRectangle((sleft+sright)/2, PolyPracticeDM.eval(poly, sleft)/2, sright-sleft, PolyPracticeDM.eval(poly, sleft)));
		}
		else{ 
			pframe.addDrawable(DrawableShape.createRectangle((sleft+sright)/2, PolyPracticeDM.eval(poly, sright)/2, sright-sleft, PolyPracticeDM.eval(poly, sright)));
		}
	}
}
