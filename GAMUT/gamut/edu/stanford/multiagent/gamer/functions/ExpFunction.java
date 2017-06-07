package edu.stanford.multiagent.gamer.functions;

import java.util.*;
import edu.stanford.multiagent.gamer.*;


/**
 * Implements an exponential function with given multiplicative
 * and additive terms.
 *
 */

public class ExpFunction extends Function
{

    // Parameters: the exponential function takes a multiplicative
    // and an additive term as parameters.    
    private static Parameters.ParamInfo pAlpha, pBeta;
    private static Parameters.ParamInfo[] expParams;
    
    static {
	// Parameter ranges are very arbitrary..

	pAlpha = new Parameters.ParamInfo("alpha", Parameters.ParamInfo.DOUBLE_PARAM, new Double(0), new Double(1), "multiplicative constant.  Should be in the range 0 to 1.  Defaults to 1.", false, new Double(1));

	pBeta = new Parameters.ParamInfo("beta", Parameters.ParamInfo.DOUBLE_PARAM, new Double(-1000), new Double(1000), "additive term.  Defaults to 0.", false, new Double(0));

	expParams = new Parameters.ParamInfo[] {pAlpha, pBeta};
	Global.registerParams(ExpFunction.class, expParams);
    }


    // --------------------------------------------------

    protected String getFunctionHelp()
    {
	return "ExpFunction: A function of the form f(x) = exp(alpha * x) + beta";
    }

    public ExpFunction() 
	throws Exception
    {
	super();
    }
    
 
    public void initialize()
	throws Exception
    {
	super.initialize();
    }



    protected void checkParameters() 
	throws Exception
    {
	
	if(dMax <= dMin)
	    throw new Exception("Bad Range!");
    }
	    

    /**
     * There is no generation whatsoever involved for
     * the exponential function.
     */
    public void doGenerate()
    {
    }



    public double eval(double x)
    {
	double alpha = (double) getDoubleParameter(pAlpha.name);
	double beta = (double) getDoubleParameter(pBeta.name);

	double exp =  Math.exp(alpha * x) + beta;

	return exp;
    }

}

