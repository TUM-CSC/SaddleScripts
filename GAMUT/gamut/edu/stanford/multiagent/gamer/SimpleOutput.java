package edu.stanford.multiagent.gamer;

import java.io.*;

/**
 * A very simple outputter, mostly for development purposes.
 */

public class SimpleOutput extends GameOutput
{

    public void writeGame(PrintWriter out, Game g)
	throws Exception
    {
	out.println(commentString(GAMER_STRING, "# "));

	out.println(commentString(g.getDescription(), "# "));

	Outcome o = new Outcome(g.getNumPlayers(), g.getNumActions());

	for(o.reset(); o.hasMoreOutcomes(); o.nextOutcome())
	    {
		out.print(o + " :\t[ ");

		for(int i=0; i<g.getNumPlayers(); i++)
		    out.print(g.getOutputPayoff(o.getOutcome(), i) + " ");
		out.println("]");
	    }

    }
}
