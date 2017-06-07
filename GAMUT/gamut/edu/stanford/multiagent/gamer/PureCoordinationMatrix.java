package edu.stanford.multiagent.gamer;

import java.util.*;

/**
 * Abstract class implements a normal form game which is 
 * common payoff and therefore only requires that the payoff
 * for each outcome be stored once.
 */


public abstract class PureCoordinationMatrix extends Game
{
    private DoubleTensor payoffs;

    // -----------------------------------------------

    /**
     * Constructor for a new pure coordination matrix game.
     */
    public PureCoordinationMatrix()
	throws Exception
    {
	super();
    }


    /**
     * Initializes the payoff array assuming the numbers of players
     * and actions have already been set.
     */
    protected void initMatrix()
    {
	payoffs = new DoubleTensor(getNumActions());
    }



    /**
     * Returns the payoff for a player at a given outcome.
     *
     * @param outcome an array holding the action choices for each player
     * @param player the player whose payoff should be returned, irrelevant
     * since the game is common payoff
     */
    public double getPayoff(int[] outcome, int player)
    {
	return payoffs.getValue(outcome);
    }



    /**
     * Sets the payoff for all players for a given outcome.
     *
     * @param outcome an array holding the action choices for each player
     * @param value the amount of the payoff for this outcome 
     */
    protected  void setPayoff(int[] outcome, double value)
    {
	payoffs.setValue(value, outcome);
    }
}

