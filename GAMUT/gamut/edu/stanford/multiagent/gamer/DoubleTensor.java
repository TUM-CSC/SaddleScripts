package edu.stanford.multiagent.gamer;

/**
 * The DoubleTensor class can be used to store matrices
 * of any dimension.
 */

public class DoubleTensor {

    private int numDimensions;
    private int[] dimensionSize;
    private double values[];


    /**
     * Constructor
     *
     * @param dimSize an array holding the size of the tensor 
     * in each dimension.
     */
    public DoubleTensor(int[] dimSize) {
	int valueArraySize = 1;

	numDimensions = dimSize.length;
	dimensionSize = new int[numDimensions];

	for (int i = 0; i < numDimensions; i++) {
	    dimensionSize[i] = dimSize[i];
	    valueArraySize *= dimensionSize[i];
	}

	values = new double[valueArraySize];
    }


    /**
     * Translate an array of indices in the tensor into
     * an index of the underlying values array.  Assumes
     * that each index in the array is between 1 and the size
     * of that dimension.
     */
    private int translateIndices(int[] indices) {

	int valueIndex = 0;

	for (int i = 0; i + 1 < numDimensions; i++) {
	    valueIndex += indices[i] - 1;
	    valueIndex *= dimensionSize[i+1];
	}
	valueIndex += indices[numDimensions-1] - 1;

	return valueIndex;
    }


    /**
     * Set the value stored at the indexed spot in the tensor
     */
    public void setValue(double value, int[] indices) {
	int valueIndex = translateIndices(indices);
	values[valueIndex] = value;
    }

    
    /**
     * Get the value stored at the indexed spot in the tensor
     */
    public double getValue(int[] indices) {
	int valueIndex = translateIndices(indices);
	return values[valueIndex];
    }

    public int getNumDimensions() {
	return numDimensions;
    }

    public int getSizeOfDim(int dim) {
	return dimensionSize[dim];
    }

    public int[] getSizeOfDim()  {
	return dimensionSize;
    }
    
    /**
     * Probably won't use this much, but occasionally may be
     * useful to get all values returned in one array.
     */
    public double[] getValues() {
	return values;
    }
}
