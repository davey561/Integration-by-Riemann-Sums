package Riemann;
import java.util.Random;

import org.opensourcephysics.display.DrawableShape;
import org.opensourcephysics.frames.PlotFrame;

import polyfun.Polynomial;

public class RanRuleDM extends RiemannDM{
	
	//declarations 
	Random randomgen = new Random(); //random generator
	
	/**
	 * finds area of slice for subinterval
	 * @param poly
	 * @param sleft
	 * @param sright
	 * @return
	 */
	
	public double slice(Polynomial poly, double sleft, double sright) {
		return (sright-sleft)*(PolyPracticeDM.eval(poly, randomgen.nextInt(100)/100*(sright-sleft)) + sleft);
	}
	
	/**
	 * draws the region whose area is calculated by slice.
	 */
	public void slicePlot(PlotFrame pframe, Polynomial poly, double sleft, double sright) {
		double subint = sright-sleft;
		double ranx = randomgen.nextInt(100);
		double ranval = PolyPracticeDM.eval(poly, (ranx/100)*(subint) + sleft);
		
		pframe.addDrawable(DrawableShape.createRectangle((sleft+sright)/2, ranval/2, sright-sleft, ranval));
	}
}
