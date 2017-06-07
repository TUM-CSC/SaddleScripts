package edu.stanford.multiagent.gamer;

import java.io.*;

/**
 * Outputs a game in the Gametracer .gam file format.
 *
 * Note, unfortunately this format doesn't have comments,
 * So it's best to use this output only in conjunction with something else,
 * so that comments aren't lost
 */

public class GTOutput extends GameOutput
{

    public void writeGame(PrintWriter out, Game g)
      throws Exception
    {
	
	// -- number of players
	out.println(g.getNumPlayers());

	// -- actions for each player
	for(int i=0; i<g.getNumPlayers(); i++)
	    out.print(g.getNumActions(i) + " "); 

	// That's it for the first line..
	out.println();
	out.println();

	// Now print the payoffs in a row
	Outcome o = new Outcome(g.getNumPlayers(), g.getNumActions());

	for(int i=0; i<g.getNumPlayers(); i++)	
	    {
		for(o.reset(); o.hasMoreOutcomes(); o.nextOutcome())
		    out.print(g.getOutputPayoff(o.getOutcome(), i) + " ");
		out.println();
	    }

    }
}
