package Riemann;
import java.awt.Color;

import org.opensourcephysics.display.DrawableShape;
import org.opensourcephysics.frames.PlotFrame;

import polyfun.Polynomial;

/*
 * Central Parent Class for all Area Under Curve Program
 * @Davey Morse
 * 
 * Is able to both plot and calculate an approximation of the area under a curve
 * Documentation: DONE
 * 
 * contains methods, some abstract, some substantiated, in order to both calculate and display on a plot frame (graphing)
 * 
 * idea for bonus:
 *calculate rate at which area increases within function (i.e. constrained between function and y axis) as y increases
 *use triangles (NOT DONE)
 */
public abstract class RiemannDM {
	//no class-wide variables
	//METHODS
	/**
	 * Calculates a Riemann sum. (rs is short for Riemann sum.)
	 * @param poly :the polynomial given
	 * @param left :the left constraint of relevant interval
	 * @param right : the right constraint of relevant interval
	 * @param subintervals: the number of subintervals = the number of slices we are using to calc. area
	 */
	public double rs(Polynomial poly, double left, double right, int subintervals){
		double rs = 0; //total riemann sum
		double []coords = RiemannDM.getSubintervalCoords(left, right, subintervals); //stores the x values for each side of each rectangle, calling each a 'coord'
		for (int i = 0; i<subintervals; i++){ //going through each coord
			rs = rs + slice(poly, coords[i], coords[i+1] ); //adding area of each slice to sum of all slices
		}
		return rs; //returns rieman sum
	}

	/**
	 * abstract class that links to area calculation for each slice in each rule
	 * @param poly given polynomial
	 * @param sleft left x coordinate of relevant subinterval
	 * @param sright right x coordinate of relevant subinterval
	 * @return
	 */
	public abstract double slice (Polynomial poly, double sleft, double sright);

	/**
	 * gets subinterval x coordinates of bottom two vertices of each slice
	 * @param left left x constraint of subinterval
	 * @param right right x constraint of subinterval
	 * @param subintervals number of subintervals for which function will evaluate coords
	 * @return
	 */
	public static double [] getSubintervalCoords(double left, double right, int subintervals){
		double delta = (right - left)/subintervals; //width of each rectangle
		double [] coords = new double [subintervals+1]; //records the coordinate of the side of each rectangle/trapezoid in the riemann sum, and output of each when used as input for polynom
		for (int i = 0; i<coords.length; i++){ //filling coords array with values:
			coords[i] = left + delta*(i); // fills in x coord value at index i
		}
		return coords; //now, the common shape used, and therefore the area of each, differs among the rules, so no more general info to include. 
	}

	/**
	 * plots the given polynomial
	 * @param pframe given plotframe
	 * @param poly given polynomial you wanna plot 
	 * @param precision the incremented between each point plotted
	 * @param left the left side cutoff of graph
	 * @param right the right side cutoff of graph
	 */
	public static void plotFx(PlotFrame pframe, Polynomial poly, double left, double right, double precision){
		//setting up plot frame
		//pframe.setDefaultCloseOperation(3); //just gotta do this
		pframe.setMarkerSize(0, 1); //setting marker size
		pframe.setMarkerColor(0, Color.black);
		//plot polynomial in interval region
		//for each tenth of a unit along the x axis, plot a point
		for (double i = left; i<right; i= (i+precision)){
			//add this point to the plotframe
			pframe.append(0, i, PolyPracticeDM.eval(poly, i));
		}
	}	

	/**
	 * plots the polynomial and the slices of the method used for evaluating area below
	 * @param pframe - 
	 * @param poly
	 * @param index
	 * @param precision
	 * @param left
	 * @param right
	 * @param subintervals
	 */
	public void rsPlot(PlotFrame pframe, Polynomial poly, int index, double precision, double left, double right, int subintervals){
		pframe.setPreferredMinMax(left,  right, PolyPracticeDM.eval(poly, left)*2, PolyPracticeDM.eval(poly, right)*2); //implementing the parameter constraints of plotframe
		//plot Fx
		plotFx(pframe,  poly, left,  right, .01);
		//plot rectangles
		double [] coords = getSubintervalCoords(left, right, subintervals); //gets x coordinates of rectangles
		//loops through each pair of coordinates
		for (int i = 0; i<subintervals; i++){
			//plots the slice for the given rule
			slicePlot(pframe, poly, coords[i], coords[i+1]);		
		}
	}
	/**
	 * an abstract method that links to slice plot functions (substantiated) of each rule's daughter class
	 * @param pframe given plotframe
	 * @param poly given polynomial
	 * @param sleft left side constraint of slice
	 * @param sright right side constraint of slice
	 */
	public abstract void slicePlot (PlotFrame pframe, Polynomial poly, double sleft, double sright);

	/**
	 * graphs an accumulation function. 
	 * @param pframe given plotframe
	 * @param poly given poly
	 * @param index given set of points
	 * @param precision space between each graphed point
	 * @param base the constant coordinate of the area calculation
	 */
	public void rsAcc(PlotFrame pframe, Polynomial poly, int index, double precision, double base) {
		//setting up plot frame
		pframe.setVisible(true);
		pframe.setDefaultCloseOperation(3); 
		double xmin = -5;
		double xmax = 5;
		double ymin = -100;
		double ymax = 100;
		pframe.setPreferredMinMax(xmin,  xmax, ymin, ymax); // preferred min and maxes
		pframe.setMarkerSize(0, 1); //marker size is one pixel
		double slicecount = 0; //keeps track of area already accumulated, so that doesn't need to recalculate everytime

		//calculating accumulated area at each point and graphing
		for (double i=base; i<100; i= i+precision){
			pframe.append(index, i, slicecount + slice(poly, i, i+1)); //appends next point on graph,
			slicecount = slicecount + slice(poly, i, i+1); //keeping track of area already counted
		}
	}



}
