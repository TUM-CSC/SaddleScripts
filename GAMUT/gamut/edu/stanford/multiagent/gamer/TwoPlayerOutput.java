package edu.stanford.multiagent.gamer;

import java.io.*;

/**
 * A very simple outputter, for two player games
 */

public class TwoPlayerOutput extends GameOutput
{

    public void writeGame(PrintWriter out, Game g)
	throws Exception
    {
	if(g.getNumPlayers()!=2)
	    throw new Exception("Unsupported Game Type for Output!");

	out.println("// " + GAMER_STRING + "\n");

	out.println(commentString(g.getDescription(), "// "));

	int n=g.getNumActions(0);
	int m=g.getNumActions(1);

	int[] o=new int[2];

	for(int i=1; i<=n; i++)
	    {
		o[0]=i;
		for(int j=1; j<=m; j++)
		    {
			o[1]=j;
			out.print("(" + g.getOutputPayoff(o,0) + ", " + 
				    g.getOutputPayoff(o,1) + ")");
			if(j!=m)
			    out.print("\t");
		    }
		out.println("");
	    }
    }
}
