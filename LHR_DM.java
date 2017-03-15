package Riemann;
import org.opensourcephysics.display.DrawableShape;
import org.opensourcephysics.frames.PlotFrame;

import polyfun.Polynomial;

/*
 * Left Hand Rule Daughter Class of RiemannDM,
 * @Davey
 * uses Left Hand Rule to approximate area under a curve and plots this approximation- only methods here are dealing with slices in individual subintervals
 * 
 * Documenation: DONE
 */
public class LHR_DM extends RiemannDM{
	//METHODS
	
	/**
	 * plots left hand rule slice
	 * @param poly given poly
	 * @param sleft left constraint
	 * @param sright right constraint
	 */
	public void slicePlot(PlotFrame pframe, Polynomial poly, double sleft, double sright) {
		//(sleft+sright)/2 is x midpoint of rect,
		//half the height is y midpoint of rect.
		//sright-sleft is width
		//p(left) is height
		pframe.addDrawable(DrawableShape.createRectangle((sleft+sright)/2, PolyPracticeDM.eval(poly, sleft)/2, sright-sleft, PolyPracticeDM.eval(poly, sleft)));
	}
	/**
	 * uses a lefthand Riemann sum rule to calculate the area of rectangular with height at left's side evaluation in poly and width as subinterval given
	 * @param poly
	 * @param sleft
	 * @param sright
	 */
	public double slice(Polynomial poly, double sleft, double sright) {
		return (sright-sleft)*(PolyPracticeDM.eval(poly, sleft));
	}
}
