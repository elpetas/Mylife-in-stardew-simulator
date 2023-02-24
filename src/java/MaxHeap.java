import java.util.NoSuchElementException;

/**
 * Defines a max-heap with an array.
 * Includes the methods heapify,max,extractMax,insert,increaseKey,isEmpty and buildMaxHeap
 * @author Johann Vargas
 */
public class MaxHeap <T extends Comparable<T>>{
	private final int DEFAULT_SIZE = 10;
	private T[] elements;
	private int count=0;
	
	/**
	 * Default constructor;
	 * 
	 */
    @SuppressWarnings("unchecked")
	public MaxHeap(){
    	elements = (T[]) new Comparable[DEFAULT_SIZE];
    	count = 0;
    }

/**
 * Builds Max Heap with the parameter provided 
 * @param list
 */
    @SuppressWarnings("unchecked")
	public MaxHeap(T[] list){
		int listLenght=list.length;
    	elements = (T[]) new Comparable[listLenght];
    	count = 0;

    	for(T t: list) {
    		insert(t); // adds element to the heap
    	}
    }

	/** 
	 * Hepify Down method
	 * 
	 * @param index
	 * @throws HeapException 
	 */
	public void heapify(int index) throws HeapException{
		if(index < 0 || index >= size()){
			throw new IndexOutOfBoundsException();
		}
		
		int largest;
    	int left = left(index);
    	int right = right(index);
    	
    	if(left >= size() || right >= size()) {
    		return;
    	}
    	
    	if(left < count && elements[left].compareTo(elements[right]) < 0) {
    		largest = left;
    	}
    	else {
    		largest = index;
    	}
    	
    	if(right <= count && elements[right].compareTo(elements[largest]) > 0) {
    		largest = right;
    	}
    	
    	if(largest != index) {
    		
    		swap(index, largest);
    		heapify(largest);	//recursive call
    	}
    }
    
	/** 
	 * Returns the object with the highest priority (with the index 0). 
	 * 
	 * @return T
	 * @throws HeapException
	 */
	private T max() throws HeapException{
    	if(count < 1) {
    		throw new HeapException("Heap underflow: No objects are within the heap.");	
    	}
    	
    	return elements[0];	//returns the element with the highest priority.
    }
    
	/** 
	 * Removes the max element from the heap
	 * 
	 * @return T
	 * @throws HeapException
	 */
	public T extractMax() throws HeapException{
    	T max = this.max();

    	elements[0] = elements[count - 1]; // The last element is then moved to index 0
    	elements[count - 1] = null;
		count--;
		
		if(isEmpty()) {	
			return max;
		}
		
		heapify(0);  // builds a max heap
		
    	return max;
    }
    
	/** 
	 * Inserts the object into the heap. Calls upon increase key so that 
	 * the object finds its correct spot within the heap. 
	 * 
	 * @param x
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void insert(Comparable x) {
    	int elementsLenght=elements.length;
		if(count == elementsLenght) { 
    		resize();	//increase size if the size is full
    	}

    	count++;
    	elements[count - 1] = (T) x;
    	
    	try {
			increaseKey(count - 1);
		} catch (HeapException e) {
			e.printStackTrace();
		}
    }
    
	/** 
	 * Increases the key of the value at the specified index.
	 * @param index
	 * @throws HeapException
	 */
	public void increaseKey(int index) throws HeapException {
		if(isEmpty()){
			throw new NoSuchElementException();
		}

		if(index < 0 || index >= size()){
			throw new IndexOutOfBoundsException();
		}

		while(elements[index].compareTo(elements[parent(index)]) == 1){
			
			swap(index, parent(index)); // Switches the parent node with the current node until

			index = parent(index);
		}
    }
    
	/**
	 * Checks if the heap is empty.
	 *  
	 * @return boolean
	 */
	public boolean isEmpty(){
		if(count == 0){
			return true;
		}

		return false;
    }

	/**
	 * Converts the heap into a max-heap.
	 * @throws HeapException 
	 */
    public void buildMaxHeap() throws HeapException{
    	for(int i = count / 2; i >= 0; i--) {
    		heapify(i);
    	}
    }
	
	/** 
	 * Returns the size of the heap.
	 * 
	 * @return count
	 */
	public int size(){
		
		return count;
	}

	/**
	 * Resizes the array by creating a clone and copying the elements.
	 */
	@SuppressWarnings("unchecked")
	private void resize(){

		T[] copy = elements.clone();
		
		elements = (T[])new Comparable[copy.length * 2];
		
		for(int i = 0; i < copy.length; i++) {	
			elements[i] = copy[i];
		}
	}
	
	/**
	 * Return the element at a given array
	 * @param index
	 * @return element[index]
	 */
	public T getElement(int index) {

		return elements[index];
	}
    
	/** 
	 * Swaps two values in the array. 
	 * 
	 * @param firstIndex
	 * @param secondIndex
	 */
	private void swap(int firstIndex, int secondIndex) {
    	
    	T swapVal = elements[firstIndex];
    	elements[firstIndex] = elements[secondIndex];
    	elements[secondIndex] = swapVal;
    }
  
	/** 
	 * Shifts the bits right by 1 bit.
	 * 
	 * @param index
	 * @return int
	 */
	private int parent(int index) {
    	
    	return index >> 1;
    }
    
	/** 
	 * Shifts the bits left by 1 bit
	 * 
	 * @param index
	 * @return int
	 */
	private int right(int index) {
    	
    	return index << 1 | 1;
    }
    
	/** 
	 * Shifts the bits left by followed by bitwising or-ing 1 to add 1
	 * 
	 * @param index
	 * @return int
	 */
	private int left(int index) {
    	
    	return index << 1;
    }
}
