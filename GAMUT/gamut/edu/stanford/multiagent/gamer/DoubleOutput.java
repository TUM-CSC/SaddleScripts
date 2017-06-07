package edu.stanford.multiagent.gamer;

import java.io.*;

/**
 * Outputs a game in the gambit and gametracer output formats
 * Separated by SEP
 */

public class DoubleOutput extends GameOutput
{

    public static final String SEP = "========================================";

    public void writeGame(PrintWriter out, Game g)
      throws Exception
    {
	
	GambitOutput nfg = new GambitOutput();
	GTOutput gam = new GTOutput();

	nfg.writeGame(out, g);
	out.println(SEP);
	gam.writeGame(out, g);

    }
}
