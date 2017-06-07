package edu.stanford.multiagent.gamer;

import java.util.*;


/**
 * Utility class holding a list of objects that can be returned 
 * either by size (largest or smallest) or randomly from the 
 * remaining elements in the list
 */


public class SortedAndRandomSet extends TreeSet {

    public SortedAndRandomSet() {
	super();
    }

    /**
     * Removes the smallest element in the list
     */
    public Object removeSmallest() {
	Object smallest = first();
	remove(smallest);
	return (smallest);
    }

    /**
     * Removes the largest element in the list.
     */
    public Object removeLargest() {
	Object largest = last();
	remove(largest);
	return(largest);
    }

    /**
     * Removes a random element from the list.
     */
    public Object removeRandom() {
	Object randomObject = first();
	int position = Global.rand.nextInt(size());
	Iterator iter = iterator();

	for (int i = 0; i <= position; i++)
	    randomObject = iter.next();

	iter.remove();

	return (randomObject);
    }

}


