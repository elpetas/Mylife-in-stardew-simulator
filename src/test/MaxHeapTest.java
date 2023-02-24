import java.util.NoSuchElementException;

/**
 * Unit Test class to test the methods of MaxHeap. 
 * 
 * @author Johann Vargas
 *
 * @param <T>
 */
@SuppressWarnings("rawtypes")
public class MaxHeapTest <T extends Comparable<T>> {
    
	private enum Result{IndexOutOfBounds, HeapException, NoSuchElement,
		NoException, Exception, True, False, WrongElement}

	private final static Integer ELEMENT_A = 1;
	private static final Integer ELEMENT_B = 2;
	private static final Integer ELEMENT_C = 3;
	private static final Integer ELEMENT_E = -1;
		
	/**
	 * runTest is called and the results a printed to the console.
	 * 
	 * @param args
	 * @throws HeapException
	 */
	public static void main(String[] args) throws HeapException {
		MaxHeapTest test = new MaxHeapTest();

		test.runTest();
	}

	/**
	 * Default constructor.
	 * 
	 */
	public MaxHeapTest() {

	}

	/**
	 * Runs all tests 
	 * 
	 */
	private void runTest(){
		Comparable[] singleElement = {ELEMENT_A};
		Comparable[] twoElement = {ELEMENT_A, ELEMENT_B};
		Comparable[] threeElement = {ELEMENT_A, ELEMENT_B, ELEMENT_C};
		Comparable[] getelement = {ELEMENT_C, ELEMENT_A, ELEMENT_E};
		
		MaxHeap<T> emptyHeap = new MaxHeap<>();
		MaxHeap<T> singleElementHeap = new MaxHeap<>(singleElement);
		MaxHeap<T> twoElementHeap = new MaxHeap<>(twoElement);
		MaxHeap<T> threeElementHeap = new MaxHeap<>(threeElement);
		MaxHeap<T> getElementHeap = new MaxHeap<>(getelement);
		
		System.out.println("-------------------------- Starting Tests ------------------------------------ \n");
		
		testEmptyList(emptyHeap);
		testSingleElementList(singleElementHeap, singleElement);
		testTwoElementList(twoElementHeap, twoElement);
		testThreeElementList(threeElementHeap, threeElement);
		testGetElement(getElementHeap ,ELEMENT_E, ELEMENT_C, ELEMENT_A);
		System.out.println("-------------------------- End of Tests ------------------------------------ \n");

	}

	/**
	 * tests for an empty list
	 * 
	 * @param heap
	 */
	private void testEmptyList(MaxHeap<T> heap){
		
		if(isEmptyTest(heap, Result.True) && testSize(heap, 0, Result.NoException) && insertTest(heap, ELEMENT_E, Result.NoException) ){
			System.out.println("Empty Heap isEmpty, testSize and insertTest succesful \n");
		}
		else{
			System.out.println("Empty Heap tests unsuccesful \n");
		}
		heap = new MaxHeap<>(); // returning heap to its original state
		if(heapifyTest(heap, 0, Result.IndexOutOfBounds) && extractMaxTest(heap, ELEMENT_A, Result.HeapException) && increaseKeyTest(heap, 0, Result.NoSuchElement) && buildMaxHeapTest(heap, Result.IndexOutOfBounds)){
			System.out.println("Empty Heap IndexOutOfBounds, HeapException and NoSuchElement exception tests succesful \n");
		}
		else{
			System.out.println("Empty Heap IndexOutOfBounds, HeapException and NoSuchElement exception tests unsuccesful \n");
		}
		System.out.println("------------------------------------------------------------------------------------- \n");
	}

	/**
	 * tests for a single element list
	 * 
	 * @param heap
	 * @param list
	 */
	private void testSingleElementList(MaxHeap<T> heap, Comparable[] list){

		if(isEmptyTest(heap, Result.False) && testSize(heap, 1, Result.NoException) && insertTest(heap, ELEMENT_E, Result.NoException)){
			System.out.println("Single element heap isEmpty, testSize and insertTest succesful \n");
		}
		else{
			System.out.println("Single element heap isEmpty, testSize and insertTest unsuccesful \n");
		}

		heap = new MaxHeap<>(list);	//returning heap to its original state

		Integer max = (Integer) heap.getElement(0);

		if(extractMaxTest(heap, max, Result.NoException)){
			System.out.println("Single element heap extractMax test succesful \n");
		}
		else{
			System.out.println("Single element heap extractMax test unsuccesful \n");
		}
		heap = new MaxHeap<>(list); //returning heap to its original state
		if(heapifyTest(heap, 0, Result.NoException) && increaseKeyTest(heap, 0, Result.NoException) && buildMaxHeapTest(heap, Result.NoException))  {
			System.out.println("Single element heap heapifyTest, increaseKeyTest and buildMaxHeapTest succesful \n");
		}
		else{
			System.out.println("Single element heap heapifyTest, increaseKeyTest and buildMaxHeapTest unsuccesful \n");
		}
		if(heapifyTest(heap, 1, Result.IndexOutOfBounds) &&  increaseKeyTest(heap, 1, Result.IndexOutOfBounds)){
			System.out.println("Single element Heap IndexOutOfBounds exception test succesful \n");
		}
		else{
			System.out.println("Single element Heap IndexOutOfBounds exception test unsuccesful \n");
		}
		System.out.println("------------------------------------------------------------------------------------- \n");
	}

	/**
	 * tests for a two element list.
	 * 
	 * @param heap
	 * @param list
	 */
	private void testTwoElementList(MaxHeap<T> heap, Comparable[] list){
		

		if(isEmptyTest(heap, Result.False) && testSize(heap, 2, Result.NoException) && insertTest(heap, ELEMENT_E, Result.NoException)){
			System.out.println("Two element heap isEmpty, testSize and insertTest succesful \n");
		}
		else{
			System.out.println("Single element heap isEmpty, testSize and insertTest unsuccesful \n");
		}
		heap = new MaxHeap<>(list);	

		Integer max = (Integer) heap.getElement(0);	
		

		if(extractMaxTest(heap, max, Result.NoException)){
			System.out.println("Two element heap extractMax test succesful \n");
		}
		else{
			System.out.println("Two element heap extractMax test unsuccesful \n");
		}
		
		heap = new MaxHeap<>(list);	
		if(heapifyTest(heap, 0, Result.NoException) && heapifyTest(heap, 1, Result.NoException) && increaseKeyTest(heap, 0, Result.NoException) && increaseKeyTest(heap, 1, Result.NoException) && buildMaxHeapTest(heap, Result.NoException)){
			System.out.println("Two element heap heapifyTest, increaseKeyTest and buildMaxHeapTest succesful \n");
		}
		else{
			System.out.println("TWo element heap heapifyTest, increaseKeyTest and buildMaxHeapTest unsuccesful \n");
		}
		if(heapifyTest(heap, 2, Result.IndexOutOfBounds) &&increaseKeyTest(heap, 2, Result.IndexOutOfBounds)){
			System.out.println("Two element Heap IndexOutOfBounds exception test succesful \n");
		}
		else{
			System.out.println("Two element Heap IndexOutOfBounds exception test unsuccesful \n");
		}
		System.out.println("------------------------------------------------------------------------------------- \n");
	}

	/**
	 * tests for a three element list.
	 * 
	 * @param heap
	 * @param list
	 */
	private void testThreeElementList(MaxHeap<T> heap, Comparable[] list){

		if(isEmptyTest(heap, Result.False) && testSize(heap, 3, Result.NoException) && insertTest(heap, ELEMENT_E, Result.NoException)){
			System.out.println("Three element heap isEmpty, testSize and insertTest succesful \n");
		}
		else{
			System.out.println("Three element heap isEmpty, testSize and insertTest unsuccesful \n");
		}

		heap = new MaxHeap<>(list);	

		Integer max = (Integer) heap.getElement(0);
		
		if(extractMaxTest(heap, max, Result.NoException)){
			System.out.println("Three element heap extractMax test succesful \n");
		}
		else{
			System.out.println("Three element heap extractMax test unsuccesful \n");
		}
		heap = new MaxHeap<>(list);	
		if(heapifyTest(heap, 0, Result.NoException) && heapifyTest(heap, 1, Result.NoException) && heapifyTest(heap, 2, Result.NoException) && increaseKeyTest(heap, 0, Result.NoException) &&increaseKeyTest(heap, 1, Result.NoException) && increaseKeyTest(heap, 2, Result.NoException) && buildMaxHeapTest(heap, Result.NoException)){
			System.out.println("Three element heap heapifyTest, increaseKeyTest and buildMaxHeapTest succesful \n");
		}
		else{
			System.out.println("Three element heap heapifyTest, increaseKeyTest and buildMaxHeapTest unsuccesful \n");
		}
		if(heapifyTest(heap, 3, Result.IndexOutOfBounds) && increaseKeyTest(heap, 3, Result.IndexOutOfBounds)){
			System.out.println("Three element Heap IndexOutOfBounds exception test succesful \n");
		}
		else{
			System.out.println("Two Three element Heap IndexOutOfBounds exception test unsuccesful \n");
		}
		System.out.println("------------------------------------------------------------------------------------- \n");
	}
	
	/**
	 * Runs the tests for inserting elements to give us a sorted heap. 
	 * 
	 * @param heap
	 * @param firstInt
	 * @param secondInt
	 * @param thirdInt
	 */
	private void testGetElement(MaxHeap<T> heap, Integer firstInt, Integer secondInt, Integer thirdInt) {

		if(getElementTest(heap, firstInt, secondInt, thirdInt)){
			System.out.println("get element at a fixed index test succesful\n");
		}
		else{
			System.out.println("get element at a fixed index test unsuccesful\n");
			
		}
	}
	
	/**
	 * Runs the tests for extractMax to give us a sorted list.
	 * 
	 * @param heap
	 * @param expected
	 * @param firstInt
	 * @param secondInt
	 * @param thirdInt
	 */

	
	/**
	 * test getting an element at a fixed index
	 * 
	 * @param heap
	 * @param first
	 * @param second
	 * @param third
	 * @return
	 */
	private boolean getElementTest(MaxHeap<T> heap, Integer first, Integer second, Integer third) {
		MaxHeap<T> tempHeap = new MaxHeap<T>();
		
		tempHeap.insert(first);
		tempHeap.insert(second);
		tempHeap.insert(third);
		
		if(heap.getElement(0) == tempHeap.getElement(0) && heap.getElement(1) == tempHeap.getElement(1)
				&& heap.getElement(1) == tempHeap.getElement(1)) {
			
			return true;
		}
		
		return false;
	}
	

	/** 
	 * insert the element and checks if an exception is thrown
	 * 
	 * @param heap
	 * @param element
	 * @param expected
	 * @return boolean
	 */
	private boolean insertTest(MaxHeap<T> heap, Comparable element, Result expected) {
		Result result;
		
		try {
			heap.insert(element);
			result = Result.NoException;
		}
		catch(Exception e){
			System.out.print(e.toString() +  ": ");
			result = Result.Exception;	//Can throw one of three Result.
		}

		return result == expected;
	}
	
	/** 
	 * extract the Max element on the heap and checks if the results match the expected results
	 * 
	 * @param heap
	 * @param expectedVal
	 * @param expected
	 * @return boolean
	 */
	private boolean extractMaxTest(MaxHeap<T> heap, Comparable expectedVal, Result expected) {
		Result result;
		
		try {
			
			if(expectedVal == heap.extractMax()) {
				result = Result.NoException;
			}
			else {
				result = Result.WrongElement;
			}
		}
		catch(HeapException t){
			result = Result.HeapException;
		}
		catch(Exception e) {
			result = Result.Exception;
			System.out.println("Unexpected Exception: " + e.toString());
		}
		
		return result == expected;
	}
	
	/** 
	 * Checks if the heap is empty and compares the results to the expected results
	 * 
	 * @param heap
	 * @param expected
	 * @return boolean
	 */
	private boolean isEmptyTest(MaxHeap<T> heap, Result expected) {
		Result result;
		
		try {
			if(heap.isEmpty() == true) {
				result = Result.True;
			}
			else {
				result = Result.False;
			}
			
		}
		catch(Exception e){
			System.out.print(e.toString() +  ": ");
			result = Result.Exception;
		}
		
		
		return result == expected;
	}
	
	/** 
	 * check if the size of the heap is correct.
	 * 
	 * @param heap
	 * @param heapSize
	 * @param expected
	 * @return boolean
	 */
	private boolean testSize(MaxHeap<T> heap, Integer heapSize, Result expected) {
		Result result;
		
		if(heapSize == heap.size()) {
			result = Result.NoException;
			
		}
		else {
			result = Result.False;
		}
		
		return result == expected;
	}
	
	/** 
	 * Calls heapify at a specific index and checks if an exception is thrown. 
	 * 
	 * @param heap
	 * @param index
	 * @param expected
	 * @return boolean
	 */
	private boolean heapifyTest(MaxHeap<T> heap, int index, Result expected) {
		Result result;
		
		try {
			heap.heapify(index);
			result = Result.NoException;
		}
		catch(IndexOutOfBoundsException e){
			result = Result.IndexOutOfBounds;
		}
		catch(Exception e) {
			System.out.print("Caught unexpected exception: " + e.toString());
			result = Result.Exception;
		}
		
		return result == expected;
	}
	
	/** 
	 * Call increaseKey on the heap at a specified index and checks if an exception is thrown.
	 * 
	 * @param heap
	 * @param index
	 * @param expected
	 * @return boolean
	 */
	private boolean increaseKeyTest(MaxHeap<T> heap, int index, Result expected) {
		Result result = null;
		
		try {
			heap.increaseKey(index);
			result = Result.NoException;	//only catches exceptions for now. Will eventually check if increase key worked.
		}
		catch(NoSuchElementException e){
			result = Result.NoSuchElement;
		}
		catch(IndexOutOfBoundsException e) {
			result = Result.IndexOutOfBounds;
		}
		catch(Exception e){
			System.out.print("Caught unexpected exception: " + e.toString());
			result = Result.Exception;
		}
		
		
		return result == expected;
	}

	/** 
	 * builds a Max Heap on the heap and checks the results are correct.
	 * 
	 * @param heap
	 * @param expected
	 * @return boolean
	 */
	private boolean buildMaxHeapTest(MaxHeap<T> heap, Result expected) {
		Result result;
		
		try {
			heap.buildMaxHeap();
			result = Result.NoException;
		}
		catch(IndexOutOfBoundsException e) {
			result = Result.IndexOutOfBounds;
		}
		catch(Exception e) {
			System.out.print("Caught unexpected exception: " + e.toString());
			result = Result.Exception;
		}
		
		return result == expected;
	}
}
