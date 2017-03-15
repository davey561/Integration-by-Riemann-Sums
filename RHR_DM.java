package Riemann;
import org.opensourcephysics.display.DrawableShape;
import org.opensourcephysics.frames.PlotFrame;

import polyfun.Polynomial;

public class RHR_DM extends RiemannDM{
	
	
	/**
	 * finds area of slice for subinterval
	 * @param poly
	 * @param sleft
	 * @param sright
	 * @return
	 */
	public double slice(Polynomial poly, double sleft, double sright) {
		return (sright-sleft)*(PolyPracticeDM.eval(poly, sright));
	}
	
	/**
	 * draws the region whose area is calculated by slice.
	 */
	public void slicePlot(PlotFrame pframe, Polynomial poly, double sleft, double sright) {
		pframe.addDrawable(DrawableShape.createRectangle((sleft+sright)/2, PolyPracticeDM.eval(poly, sright)/2, sright-sleft, PolyPracticeDM.eval(poly, sright)));
	}
}
