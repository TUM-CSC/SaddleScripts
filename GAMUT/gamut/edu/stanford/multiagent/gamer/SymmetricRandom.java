package edu.stanford.multiagent.gamer;

/**
 * Create a random version of a two-player symmetric game.
 */ 


public class SymmetricRandom extends MatrixGame
{
    // -- Parameters: Random games are parameterized only on the
    // number of players and the number of actions
    private static Parameters.ParamInfo[] rgParam;

    static {
	rgParam = new Parameters.ParamInfo[] {Game.actions};
	Global.registerParams(SymmetricRandom.class, rgParam);
    }

    // ----------------------------------------------

    /**
     * Construct a new game
     */

    public SymmetricRandom()
	throws Exception
    {
	super();
    }

    public void initialize()
	throws Exception
    {
	super.initialize();

	// All zero sum games must have two players.  The
	// number of actions is extensible.
	setNumPlayers(2);
	parseActions();

	//initPayoffs(getNumActions(0), getNumActions(0));
	//parsePlayersActions();

	initMatrix();
    }


    /**
     * None to check
     */
    protected void checkParameters() throws Exception
    {
    }



    /** 
     * Return the help screen
     */

    protected String getGameHelp()
    {
	return "Creates a game with the given number of players " +
	    "with payoffs distributed uniformly at random." +
	    getRangeHelp();
    }

    /** 
     * Fill in the payoffs
     */
    public void doGenerate()
    {
	double low = DEFAULT_LOW;
	double high = DEFAULT_HIGH;

	setDescription("Symmetric Game\n" + getDescription());
	setName("Symmetric Random Game");

	Outcome outcome = new Outcome(2, getNumActions());
	outcome.reset();

	int[] next = new int[2];
	int[] next2 = new int[2];

	// Loop through all outcomes in the matrix, generating
	// random payoffs between payoff_low and payoff_high 
	// and randomly negating half of them
	while (outcome.hasMoreOutcomes()) {
	    double pay1 = Global.randomDouble(low, high);
	    double pay2 = Global.randomDouble(low, high);
	    
	    next = outcome.getOutcome();
	    outcome.nextOutcome();
		next2[0] = next[1];
		next2[1] = next[0];

	    if (Global.randomBoolean()) {
		pay1 = -pay1;
	    }
	    if (Global.randomBoolean()) {
		pay2 = -pay2;
	    }

		if (next[0]==next[1]) {
			setPayoff(next, 0, pay1);
	    	setPayoff(next, 1, pay1);
		}
		
		else {
	    	setPayoff(next, 0, pay1);
	    	setPayoff(next, 1, pay2);
			setPayoff(next2, 0, pay2);
			setPayoff(next2, 1, pay1);
		}
	}

    }
}
