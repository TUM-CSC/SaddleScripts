package edu.stanford.multiagent.gamer;

/**
 * Create a random version of a two-player confrontation game (symmetric zero-sum game that satisfies off-diagonal property).
 */ 


public class ConfrontationGame extends ZeroSumGame
{

    // Parameters: SymmetricZeroSumGame is parameterized by the number
    // of actions for each player.
    private static Parameters.ParamInfo[] rzsParam;

    static {
	rzsParam = new Parameters.ParamInfo[] {Game.actions};
	Global.registerParams(ConfrontationGame.class, rzsParam);
    }


    // ----------------------------------------------


    public ConfrontationGame() 
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

	initPayoffs(getNumActions(0), getNumActions(0));
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
	return "Creates a 2 player Symmetric Zero Sum Game" + getRangeHelp() + "\n\n" +
	    "Note that when normalization is used, there may be error " +
	    "in the last digits of the decimal payoffs resulting in a " +
	    "games which are occasionally not quite zero sum."; 
    }


    /**
     * Create an instance of the symmetric zero sum game
     */
    public void doGenerate()
    {
	// double low = DEFAULT_LOW;
	// double high = DEFAULT_HIGH;
	//int low = (int) DEFAULT_LOW;
	//int high = (int) DEFAULT_HIGH;
	int high = 10;
	//int low = -10;


	setDescription("Zero Sum Game\n" + getDescription());
	setName("Symmetric Random Zero Sum Game");

	Outcome outcome = new Outcome(2, getNumActions());
	outcome.reset();

	int[] next = new int[2];
	int[] next2 = new int[2];

	// Loop through all outcomes in the matrix, generating
	// random payoffs between payoff_low and payoff_high 
	// and randomly negating half of them
	while (outcome.hasMoreOutcomes()) {
	    // double pay = Global.randomDouble(low, high); // to get a double
		// generates number between 1 and 10 and randomly decides if it will be negated or not
		int pay = Global.randomInt(1, high);
		boolean absolute = Global.randomBoolean();

		if (!absolute)  {
			pay = -pay;
		}
	    
	    next = outcome.getOutcome();
	    outcome.nextOutcome();
		next2[0] = next[1];
		next2[1] = next[0];

	    if (Global.randomBoolean()) {
		pay = -pay;
	    }
		
		if (next[0]==next[1]) {
	    	setPayoff(next, 0);
			setPayoff(next2, 0);			
		}

	    else {
			setPayoff(next, pay);
			setPayoff(next2, -pay);
		}
	}

    }

}
