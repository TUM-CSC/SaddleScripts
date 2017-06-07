package edu.stanford.multiagent.gamer;

/**
 * Return a uniformly random game
 */

public class RandomGame extends MatrixGame
{
    // -- Parameters: Random games are parameterized only on the
    // number of players and the number of actions
    private static Parameters.ParamInfo[] rgParam;

    static {
	rgParam = new Parameters.ParamInfo[] {Game.players, Game.actions};
	Global.registerParams(RandomGame.class, rgParam);
    }

    // ----------------------------------------------

    /**
     * Construct a new game
     */

    public RandomGame()
	throws Exception
    {
	super();
    }

    public void initialize()
	throws Exception
    {
	super.initialize();

	parsePlayersActions();

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
	double high= DEFAULT_HIGH;

	setDescription("A Game With Uniformly Random Payoffs\n" 
			 + getDescription());
	setName("Random Matrix Game");


	Outcome outcome=new Outcome(getNumPlayers(), getNumActions());
	
	for(outcome.reset(); outcome.hasMoreOutcomes(); outcome.nextOutcome())
	    {
		for(int i=0; i<getNumPlayers(); i++)
		    setPayoff(outcome.getOutcome(), i, 
			      Global.randomDouble(low, high));
	    }
    }
}
