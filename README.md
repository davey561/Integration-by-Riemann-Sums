# Integration-by-Riemann-Sums
This set of classes provides, at its base, a simulation-based method for integrating functions, along with a visual counterpart.
The central Riemann class contains the base methods for finding the area under the curve of a polynomial from **x=0** to a 
given **x=a**. The approximation methods that can be visually represented with this program, and that each possess an 
individual class of the parent Riemann, include the following:
* Right-Hand Approximation
* Left-Hand Approximation
* Trapezoidal Approximation
* Simpsons Approximation

Using these Riemann Sums, there is another subclass of Riemann called AccumulationFunction, which plots the accumulation
function (integral) of a given function by generating the Riemann sum under the given function at each point on the graph.
