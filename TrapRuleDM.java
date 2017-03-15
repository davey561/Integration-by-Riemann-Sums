package Riemann;
import org.opensourcephysics.display.DrawableShape;
import org.opensourcephysics.display.Trail;
import org.opensourcephysics.frames.PlotFrame;

import polyfun.Polynomial;

public class TrapRuleDM extends RiemannDM{


	/**
	 * graphs the polynomial whose Riemann sum is being calculated and also draws the rectangles (or other shapes) whose areas are summed in the calculation of the Riemann sum.
	 * @param pframe
	 * @param poly
	 * @param index
	 * @param precision
	 * @param left
	 * @param right
	 * @param subintervals
	 */
	public void rsPlot(PlotFrame pframe, Polynomial poly, int index, double precision, double left, double right, int subintervals){
		//plot Fx
		plotFx(pframe,  poly,  left, right, precision );

		//plot traps- trail
		double [] coords = getSubintervalCoords(left, right, subintervals);
		for (int i = 0; i<subintervals; i++){
			slicePlot(pframe, poly, coords[i], coords[i+1]);
		}
	}
	
	/**
	 * draws the region whose area is calculated by slice.
	 * @param pframe
	 * @param poly
	 * @param sleft
	 * @param sright
	 */
	public void slicePlot(PlotFrame pframe, Polynomial poly, double sleft, double sright) {
		//draw trap
		Trail trap = new Trail();
		trap.addPoint(sleft, 0);
		trap.addPoint(sright, 0);
		trap.addPoint(sright,PolyPracticeDM.eval(poly, sright));
		trap.addPoint(sleft,PolyPracticeDM.eval(poly, sleft));
		trap.closeTrail();

		//add to frame
		pframe.addDrawable(trap);
	}

	/**
	 * uses a particular Riemann sum rule to calculate an approximation of the area under the graph of the given polynomial and over one interval on the x-axis.
	 * @param poly
	 * @param sleft
	 * @param sright
	 */
	public  double slice(Polynomial poly, double sleft, double sright){
		return (sright-sleft)*(((PolyPracticeDM.eval(poly, sright)+PolyPracticeDM.eval(poly,sleft))/2));
	}

	//	/**
	//	 * draws the region whose area is calculated by slice.
	//	 * @param pframe
	//	 * @param poly
	//	 * @param sleft
	//	 * @param sright
	//	 */
	//	slicePlot(PlotFrame pframe, Polynomial poly, double sleft, double sright){
	//		
	//	}
}
