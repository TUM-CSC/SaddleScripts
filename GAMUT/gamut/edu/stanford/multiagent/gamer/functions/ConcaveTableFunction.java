package edu.stanford.multiagent.gamer.functions;

import java.util.*;
import edu.stanford.multiagent.gamer.*;


/**
 * Class implements a table lookup concave function (for truly 
 * random table functions)
 */

public class ConcaveTableFunction extends IncreasingTableFunction
{

    // -- Parameters
    
    static {
	Global.registerParams(ConcaveTableFunction.class, tfParam); 
    }
    
    
    // --------------------------------------------------
    
    
    protected  String getFunctionHelp()
    {
	return "ConcaveTableFunction: Represents a general concave function as a table of points. Function is evaluated by looking up nearest point to the x value. No interpolation is done.";
    }
    
    
    public ConcaveTableFunction() 
	throws Exception
    {
	super();
    }
    
  
    public void initialize()
	throws Exception
    {
	super.initialize();
    }
  

    /**
     * Generate the table
     */
    public void doGenerate()
    {
	int nPoints=(int)getLongParameter(pPoints.name);
	double min = getDoubleParameter(pMin.name);
	double max = getDoubleParameter(pMax.name);
	
	// -- generate derivative
	table = new double[nPoints];
   
	double maxDeriv = max-min;

	table[0] = -maxDeriv;
	table[nPoints-1] = maxDeriv;

	//    recGenerate(0, nPoints-1, table[0], table[nPoints-1]);
	recGenerate(0, nPoints-1, -maxDeriv, maxDeriv);
    
	double[] deriv=table;
  
	intAndNorm(deriv);    
    }

    
    /** 
     * Just used for testing
     */
    public static void main(String[] args)
	throws Exception
    {

	Global.rand=new Random(    System.currentTimeMillis() );

	ConcaveTableFunction p = new ConcaveTableFunction();
	p.setParameters(new ParamParser(args), false);
	p.initialize();
	p.doGenerate();

	for(int i=0; i<p.table.length; i++)
	    System.out.println(p.table[i]);
	System.out.println("\n--------------------------");
	System.out.println(p.eval(0));
	System.out.println(p.eval(1));
	System.out.println(p.eval(0.5));
	System.out.println(p.eval(0.7));
    }
}

