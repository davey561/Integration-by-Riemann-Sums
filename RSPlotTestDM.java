package Riemann;

import polyfun.Polynomial;
import org.opensourcephysics.frames.*;
/*
 * RSPlotTest
 * @Gomp
 * @Davey
 * 
 * Documentation: DONE
 * 
 * Test class to plot all the types of slices for each different rule.
 * Gomp's basic tests, plus added tests of all the new rules I developed 
 * INCLUDE REAL AREA 
 */
public class RSPlotTestDM 
{
        public static void main(String[] args) 
        {
                LHR_DM LHR = new LHR_DM();  //LeftHandRule extends Riemann
                RHR_DM RHR = new RHR_DM();  //RightHandRule extends Riemann
                TrapRuleDM TR = new TrapRuleDM(); //traprule extends riemann
                MdptRuleDM mdpt = new MdptRuleDM(); //midpoint rule extends riemann
                MinRuleDM min = new MinRuleDM(); //min rule extends riemann
                MaxRuleDM max = new MaxRuleDM(); //max
                RanRuleDM rand = new RanRuleDM(); //random rule
                SimpsonsRuleDM simp = new SimpsonsRuleDM();//simpsons rule
                
                Polynomial p = new Polynomial(new double[] {0,2, 1}); // x^2 + x

                
                PlotFrame f = new PlotFrame("x","y","Left Hand Riemann Sum Graph"); //naming plotframe and axes
                f.setDefaultCloseOperation(3);
                f.setVisible(true);
                
                
                PlotFrame g = new PlotFrame("x","y","Right Hand Riemann Sum Graph"); //naming plotframe and axes
                g.setDefaultCloseOperation(3);
                g.setVisible(true);
                
                PlotFrame h = new PlotFrame("x","y", "Trapezoid Rule Riemann Sum Graph");//naming plotframe and axes
                h.setDefaultCloseOperation(3);
                h.setVisible(true);
                
                PlotFrame i = new PlotFrame("x","y", "Mdpt Rule Riemann Sum Graph");//naming plotframe and axes
                i.setDefaultCloseOperation(3);
                i.setVisible(true);
                
                PlotFrame j = new PlotFrame("x","y", "Min Rule Riemann Sum Graph");//naming plotframe and axes
                j.setDefaultCloseOperation(3);
                j.setVisible(true);
                
                PlotFrame k = new PlotFrame("x","y", "Max Rule Riemann Sum Graph");//naming plotframe and axes
                k.setDefaultCloseOperation(3);
                k.setVisible(true);
                
                PlotFrame l = new PlotFrame("x","y", "Random Rule Riemann Sum Graph");//naming plotframe and axes
                l.setDefaultCloseOperation(3);
                l.setVisible(true);
                
                PlotFrame m = new PlotFrame("x","y", "Simpsons Rule Riemann Sum Graph");//naming plotframe and axes
                m.setDefaultCloseOperation(3);
                m.setVisible(true);
                
                double right = 5; //value of right constrant
                LHR.rsPlot(f, p, 1, 0.01, 0.0, right, 10); // the left hand rule from x=0 to x=2, with 10 rectangles      
                RHR.rsPlot(g, p, 1, 0.01, 0.0, right, 10); // the right hand rule from x=0 to x=2, with 10 rectangles
                TR.rsPlot(h, p, 1, 0.01, 0.0, right, 10); //// the trapezoid rule from x=0 to x=2, with 10 rectangles
                mdpt.rsPlot(i, p, 1, .01, 0.0, right, 10);// mdpt rule
                min.rsPlot(j, p, 1, .01, 0.0, right, 10); //min rule
                max.rsPlot(k,p,1, .01, 0.0, right, 10); //max rule
                rand.rsPlot(l, p, 1, .01, 0.0, right, 10); //random rule
                simp.rsPlot(m, p, 1, .01, 0.0, right, 10); //simpsons rule
                
        }
}       

