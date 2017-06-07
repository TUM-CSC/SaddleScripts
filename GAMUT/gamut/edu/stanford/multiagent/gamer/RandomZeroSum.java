package edu.stanford.multiagent.gamer;

/**
 * Create a random version of a two-player zero-sum game.
 */ 


public class RandomZeroSum extends ZeroSumGame
{

    // Parameters: ZeroSumGame is parameterized by the number
    // of actions for each player.
    private static Parameters.ParamInfo[] rzsParam;

    static {
	rzsParam = new Parameters.ParamInfo[] {Game.actions};
	Global.registerParams(RandomZeroSum.class, rzsParam);
    }


    // ----------------------------------------------


    public RandomZeroSum() 
	throws Exception
    {
	super();
    }



    public void initialize()
	throws Exception
    {
	super.initialize();

	// All zero sum games must have two players.  The
	// number of actions for each is extensible.
	setNumPlayers(2);
	parseActions();

	initPayoffs(getNumActions(0), getNumActions(1));
    }



    //
    // Nothing to check
    //
    protected void checkParameters() throws Exception 
    {
    }



    //
    // Nothing to randomize
    //
    public void randomizeParameters() 
    {
    }


    protected String getGameHelp()
    {
	return "Creates a 2 player Zero Sum Game" + getRangeHelp() + "\n\n" +
	    "Note that when normalization is used, there may be error " +
	    "in the last digits of the decimal payoffs resulting in a " +
	    "games which are occasionally not quite zero sum."; 
    }


    /**
     * Create an instance of the zero sum game
     */
    public void doGenerate()
    {
	double low = DEFAULT_LOW;
	double high = DEFAULT_HIGH;

	setDescription("Zero Sum Game\n" + getDescription());
	setName("Random Zero Sum Game");

	Outcome outcome = new Outcome(2, getNumActions());
	outcome.reset();

	int[] next = new int[2];

	// Loop through all outcomes in the matrix, generating
	// random payoffs between payoff_low and payoff_high 
	// and randomly negating half of them
	while (outcome.hasMoreOutcomes()) {
	    double pay = Global.randomDouble(low, high);
	    
	    next = outcome.getOutcome();
	    outcome.nextOutcome();

	    if (Global.randomBoolean()) {
		pay = -pay;
	    }
		
	    setPayoff(next, pay);
	}

    }

}
