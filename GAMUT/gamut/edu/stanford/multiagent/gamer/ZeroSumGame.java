package edu.stanford.multiagent.gamer;

/**
 * Abstract class used for representing a two-player zero-sum 
 * game. Implemented in a similar manner to MatrixGame 
 * except only one payoff matrix needs to be stored.
 */ 


public abstract class ZeroSumGame extends Game
{

    // Payoffs holds the payoff matrix for player 1,
    // the payoffs for player 2 are found by negating these.
    double[][] payoffs;


    // --------------------------------------------------


    /**
     * Constructor for two-player zero-sum games.
     */
    public ZeroSumGame()
	throws Exception
    {
	super();
    }


    /**
     * Create the matrix of payoffs.
     *
     * @param a1 the number of actions player 1 has
     * @param a2 the number of actions player 2 has
     */
    public void initPayoffs(int a1, int a2) {
	payoffs = new double[a1][a2];
    }



    /**
     * Return the payoff for the specified player at the
     * specified outcome.
     *
     * @param outcome an array holding the outcome choices for
     * each player
     * @param player the player whose action should be returned
     */
    public double getPayoff(int[] outcome, int player) {
	if (player == 0)
	    return payoffs[outcome[0] - 1][outcome[1] - 1];

	return (-payoffs[outcome[0] - 1][outcome[1] - 1]);
    }


    
    /**
     * Set the payoff for the first player at the given outcome.
     * The payoff for player 2 at this outcome will be the negation
     * of this.
     *
     * @param outcome an array holding the outcome choices for
     * each player
     * @param payoff the amount of the payoff
     */
    public void setPayoff(int[] outcome, double payoff) {
	payoffs[outcome[0] - 1][outcome[1] - 1] = payoff;
    }
}
