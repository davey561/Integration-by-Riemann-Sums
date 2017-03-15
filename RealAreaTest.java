package TestClasses;
import java.awt.Color;

import org.opensourcephysics.frames.PlotFrame;

import Riemann.*;
import polyfun.Polynomial;
/*
 * Tests the real area class, which contains methods to draw and calculate area without approximation
 */
public class RealAreaTest {
	public static void main(String[] args) {

		//testing area calculator
		Polynomial poly = new Polynomial(new double[] {0, 0, 1});
		PlotFrame f = new PlotFrame("x","y","Real Area Sum Graph"); //naming plotframe and axes
		RealAreaDM.realArea(f, poly, 1, 2);

		//testing visualizer
		//tweaking plotframe setting and making visible
		double right = 5;
		f.setPreferredMinMax(0, right, 0, right*right);
		f.setDefaultCloseOperation(3);
		f.setVisible(true);
		RealAreaDM.shadeMyInterval(f, poly, 0, 5, .01);


	}

}
