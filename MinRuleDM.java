package Riemann;
import org.opensourcephysics.display.DrawableShape;
import org.opensourcephysics.frames.PlotFrame;

import polyfun.Polynomial;
/**
 * Midpoint Rule
 * @author student
 *calculates slices' area and plots them with height as poly evaluated at minimum of left or right x value constraints of interval
 *Documentation: DONE
 */
public class MinRuleDM extends RiemannDM{
	/**
	 * finds area of slice for subinterval
	 * @param poly
	 * @param sleft
	 * @param sright
	 * @return
	 */
	public double slice(Polynomial poly, double sleft, double sright) {
		if((PolyPracticeDM.eval(poly, sleft)<PolyPracticeDM.eval(poly, sright))){ //if left x value is smaller than right
			return (sright-sleft)*(PolyPracticeDM.eval(poly, sright));
		}
		else {
			return (sright-sleft)*(PolyPracticeDM.eval(poly, sleft)); //else, (if right is smaller than left)
		}
	}

	/**
	 * draws the region whose area is calculated by slice.
	 */
	public void slicePlot(PlotFrame pframe, Polynomial poly, double sleft, double sright) {
		if (PolyPracticeDM.eval(poly, sleft)<PolyPracticeDM.eval(poly, sright)){
			pframe.addDrawable(DrawableShape.createRectangle((sleft+sright)/2, PolyPracticeDM.eval(poly, sleft)/2, sright-sleft, PolyPracticeDM.eval(poly, sleft)));
		}
		else{
			pframe.addDrawable(DrawableShape.createRectangle((sleft+sright)/2, PolyPracticeDM.eval(poly, sright)/2, sright-sleft, PolyPracticeDM.eval(poly, sright)));
		}
	}
}
