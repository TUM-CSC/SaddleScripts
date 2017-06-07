package edu.stanford.multiagent.gamer.functions;

import edu.stanford.multiagent.gamer.*;

/**
 * An abstract class to support functions on vectors of values.
 */
public abstract class VectorFunction extends ParameterizedObject
{

    /**
     * Constructor for a vector function.
     */
    public VectorFunction()
	throws Exception
    {
	super();
    }

    /**
     * Returns the arity of the function
     */
    public abstract int getArity();

    /**
     * Returns the value of the function evaluated on x.
     *
     * @param x an array of values on which the function should
     * be executed
     */
    public abstract double eval(double[] x);


    /**
     * Initializes the vector function.
     */
    public void initialize()
	throws Exception
    {
	super.initialize();
    }
}
