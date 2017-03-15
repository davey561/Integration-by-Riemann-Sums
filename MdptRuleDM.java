package Riemann;
import org.opensourcephysics.display.DrawableShape;
import org.opensourcephysics.frames.PlotFrame;

import polyfun.Polynomial;


/*
 * midpoint rule daughter class of RiemannDM
 * @author Davey
 * calculates area of slice with height of midpoint of interval's evaluation in function
 * 
 * Documentation: DONE
 */
public class MdptRuleDM extends RiemannDM {
	/**
	 * calculates area in slice
	 * @param poly given polynomial
	 * @param sleft left constraint
	 * @param sright right constraint
	 */
	public double slice (Polynomial poly, double sleft, double sright){
		return (sright-sleft)*(PolyPracticeDM.eval(poly, (sleft+sright)/2));
	}
	/**
	 * plots the chosen midpoint rectangle slice
	 * @param pframe given plotframe
	 * @param poly given polynomial
	 * @param sleft right edge of slice
	 * @param sright left edge of slice
	 */
	public void slicePlot (PlotFrame pframe, Polynomial poly, double sleft, double sright){
		pframe.addDrawable(DrawableShape.createRectangle((sleft+sright)/2, PolyPracticeDM.eval(poly, (sleft+sright)/2)/2, sright-sleft, PolyPracticeDM.eval(poly, (sleft+sright)/2)));
	}
}
