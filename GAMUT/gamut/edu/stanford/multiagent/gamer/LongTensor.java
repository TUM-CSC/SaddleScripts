package edu.stanford.multiagent.gamer;

/**
 * The LongTensor class can be used to store matrices
 * of any dimension
 */

public class LongTensor {

    private int numDimensions;
    private int[] dimensionSize;
    private long values[];


    /**
     * The constructor for a LongTensor 
     *
     * @param dimSize an array holding the size of the tensor in 
     * each dimension
     */
    public LongTensor(int[] dimSize) {
	int valueArraySize = 1;

	numDimensions = dimSize.length;
	dimensionSize = new int[numDimensions];

	for (int i = 0; i < numDimensions; i++) {
	    dimensionSize[i] = dimSize[i];
	    valueArraySize *= dimensionSize[i];
	}

	values = new long[valueArraySize];
	for (int i = 0; i < valueArraySize; i++) values[i] = 0;
    }


    /**
     * Translate an array of indices in the tensor into
     * an index of the underlying values array.  Assumes
     * that each index in the array is between 0 and the size
     * of that dimension - 1.
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
    public void setValue(long value, int[] indices) {
	int valueIndex = translateIndices(indices);
	values[valueIndex] = value;
    }

    /**
     * Get the value stored at the indexed spot in the tensor
     */
    public long getValue(int[] indices) {
	int valueIndex = translateIndices(indices);
	return values[valueIndex];
    }

    public int getNumDimensions() {
	return numDimensions;
    }

    public int getSizeOfDim(int dim) {
	return dimensionSize[dim];
    }

    /**
     * Probably won't use this much, but occasionally may be
     * useful to get all values returned in one array.
     */
    public long[] getValues() {
	return values;
    }
}
