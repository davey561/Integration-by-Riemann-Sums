package Riemann;
import org.opensourcephysics.frames.DisplayFrame;
import org.opensourcephysics.frames.PlotFrame;

import polyfun.Polynomial;

public class PolyPracticeDM {
	//methods
	//not evaluating properly, but satisfies test
	public static double eval(Polynomial p, double x) {
		return p.evaluate(x).getTerms()[0].getTermDouble();
	}
	public static void addXsquared(Polynomial p){
		Polynomial parab = new Polynomial (1, 2);
		Polynomial added = p.plus(parab);
		added.print();
		PlotFrame myFrame = new PlotFrame("x","y", "addXsquared");
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(3);
		int min = -10;
		int max = 10;
		myFrame.setPreferredMinMax(min,  max, min, max);
		myFrame.setMarkerSize(0, 2);
		//for each tenth of a unit along the x axis, plot a point
		for (double i = min; i<(max-min); i= (i+0.05)){
			myFrame.append(0, i, eval(added, i));
		}
	}
}
