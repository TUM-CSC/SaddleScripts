package edu.stanford.multiagent.gamer.functions;

import java.util.*;
import edu.stanford.multiagent.gamer.*;


/**
 * Class implements a log function.
 */

public class LogFunction extends Function
{

    // Parameters: The log function takes as parameters a multiplicative
    // and an additive term.
 
    private static Parameters.ParamInfo pAlpha, pBeta;
    private static Parameters.ParamInfo[] logParams;
    
    static {
	// Ranges on these are extremely arbitrary..
	
	pAlpha = new Parameters.ParamInfo("alpha", Parameters.ParamInfo.DOUBLE_PARAM, new Double(0), new Double(10), "multiplicative constant");

	pBeta = new Parameters.ParamInfo("beta", Parameters.ParamInfo.DOUBLE_PARAM, new Double(-1000), new Double(1000), "additive term");

	logParams = new Parameters.ParamInfo[] {pAlpha, pBeta};
	Global.registerParams(LogFunction.class, logParams);
    }


    // --------------------------------------------------


    protected  String getFunctionHelp()
    {
	return "LogFunction: A function of the form f(x) = alpha * ln(x + k) + beta. k is calculated automatically as 1-dMin, where dMin is the lower bound on the domain.";
    }

    private double shift=0;

    public LogFunction() 
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
	if( dMax < dMin )
	    throw new Exception("Bad Range!: " + "[" + dMax + ", " + dMin + "]");

	//if (dMin <= 0)
	//   System.err.println("WARNING: Log Domain non positive, shifting arguments by " + (1-dMin));
    }
	    

    /**
     * Shifts the function if the domain min is less than or
     * equal to 0.
     */
    public void doGenerate()
    {
	if(getDMin()<=0)
	    shift = 1-getDMin();
    }


    public double eval(double x)
    {
	double alpha = (double) getDoubleParameter(pAlpha.name);
	double beta = (double) getDoubleParameter(pBeta.name);

	double log = alpha * Math.log(x + shift) + beta;
	return log;
    }

}

