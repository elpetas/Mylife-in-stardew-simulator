/**
 * Implements a Priority Queue to the max heap implements PriorityQueueInterface
 * 
 * @author Johann Vargas
 */
public class MyPriorityQueue extends MaxHeap<Task> implements PriorityQueueInterface {
	
	/**
	 * Default constructor for a priority queue.
	 */
	public MyPriorityQueue(){
		
	}
	/**
	 * Inserts a new task in to the heap
	 */
	@Override
	public void enqueue(Object task) {
		
		insert((Task) task);
	}
	/**
	 * Returns the element with the highest priority
	 * @return max
	 */
	@Override
	public Task dequeue() {
		Task max;

		try{
			max = extractMax();
			return max;
		}
		catch(Exception e){
			System.out.println(e.toString());
		}

		return null;
	}
	/**
 	* Checks if the heap is empthy 
	* @return size 
 	*/
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}
	/**
	 * Updates the priority of an element
	 * @param timeToIncrementPriority
	 * @param maxPriority
	 */
	@Override
	public void update(int timeToIncrementPriority, int maxPriority) {


		for(int i = 0; i < size(); i++) {	

			Task task = getElement(i);
			task.incrementWaitingTime();
			
			if(task.getWaitingTime() >= timeToIncrementPriority){
				task.resetWaitingTime();
			
				if(task.getPriority() < maxPriority){
					task.setPriority(task.getPriority() + 1);

					try{
						increaseKey(i);
					}
					catch(Exception e){
						System.out.println(e.toString());
					}
				}
			}
		}
	} 

}
