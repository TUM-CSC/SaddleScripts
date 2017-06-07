package edu.stanford.multiagent.gamer.graphs;

/**
 * Implements an Edge data structure for graphs.  Any
 * Object can be stored in the edge
 */
 
public class Edge
{
    private int to;
    private int from;
    private Object data;
    
    // ---------------------------------------

    
    public Edge(int from, int to)
    {
	this.from=from;
	this.to=to;
	data=null;
    }

    public int getSource() { 
	return from;
    }

    public int getDest() { 
	return to; 
    }

    public Object getData() { 
	return data; 
    }
    
    public void setData(Object d) { 
	data=d; 
    }
}

