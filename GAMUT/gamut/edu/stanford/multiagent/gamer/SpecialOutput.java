package edu.stanford.multiagent.gamer;

import java.io.*;

/**
 * This outputter uses game own output function
 */

public class SpecialOutput extends GameOutput
{

    public void writeGame(PrintWriter out, Game g)
    {
	out.println(commentString(GAMER_STRING, "# "));

	out.println(commentString(g.getDescription(), "# "));

	out.println("# Players: " + g.getNumPlayers());
	
	out.print("# Actions: [ ");
	for(int i=0; i<g.getNumPlayers(); i++)
	    out.print(g.getNumActions(i) + " ");
	out.println("]");

	try {
	    g.writeGame(out);
	} catch (Exception e) {
	    System.err.println("FATAL: Failed to write game!");
	    System.err.println(e.getMessage());
	    System.exit(1);
	}
    }
}
