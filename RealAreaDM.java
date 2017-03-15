package Riemann;

import java.awt.Color;

import org.opensourcephysics.display.Trail;
import org.opensourcephysics.frames.PlotFrame;

import polyfun.Polynomial;
/*
 * Real Area Calculator
 * @author Davey Morse
 * 
 * Calculates the area between a given function and the x-axis on a given interval EXACTLY, not using approximations; calculus used instead, in taking limit of riemann sum functions
 */
public class RealAreaDM {
	
	//METHODS:
	/**
	 * shades between x axis and poly, drawing parallel lines; an attempt to represent the area btw. function and x axis without approximation
	 */
	public static void shadeMyInterval(PlotFrame pframe, Polynomial poly, double left, double right, double precision){
		//plot function
		RiemannDM.plotFx(pframe, poly, left, right, precision/5);
		PolyPracticeDM popeye = new PolyPracticeDM(); 
		for (double i = left; i<right-left; i= i+(right-left)*precision){
			Trail line = new Trail(); //line between spot on x axis and y
			line.addPoint(i, popeye.eval(poly, i));
			line.addPoint(i, 0);
			line.color = Color.MAGENTA;
			pframe.addDrawable(line);
			
		}
	}
	
	/**
	 * Calculates real area, not approximation, between poly and x axis
	 * @param pframe
	 * @param poly
	 * @param base
	 * @return
	 */
	public static double realArea (PlotFrame pframe, Polynomial poly, double left, double right){
		double area = 0;
		double area_deg = 1; //area degree is always one more than degree of term given
		for (int i = 0; i<poly.getDegree()+1; i++){
			area = area+  (poly.getCoefficient(i).getTerms()[0].getTermDouble())*((Math.pow(right, area_deg)/area_deg)- (Math.pow(left, area_deg)/area_deg));
			area_deg++;
		}
		System.out.println("Real Area:" + area);
		return area;
	}
}
