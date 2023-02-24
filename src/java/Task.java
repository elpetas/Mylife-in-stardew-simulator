/**
 * Creates a task object. Implements the TaskInterface and Comparable.
 * @author Johann Vargas
 */
public class Task implements TaskInterface, Comparable<Task>{
	private int priority;
	private int hourCreated;
	private TaskInterface.TaskType taskType;
	private int waitingTime;
	private String taskDescription;
	
	/**
	 * Creates a task with the hour it was created at, the task type, and a task description.
	 * The task type is an enumerator inherited from the Task Interface.
	 * 
	 * @param hourCreated
	 * @param taskType
	 * @param description
	 */
	public Task(int hourCreated, TaskInterface.TaskType taskType, String taskDescription) {
		this.priority = 0;
		this.hourCreated = hourCreated;
		this.taskType = taskType;
		waitingTime = 0;
		this.taskDescription = taskDescription;
	}
	/**
	 * 
	 */
	@Override 
	public int compareTo(Task object) {
		
		if(priority != object.getPriority()) {
			
			return Integer.compare(priority, object.getPriority());
		}
		
		if(Integer.compare(hourCreated, object.getHourCreated()) < 0) {		//if two task have the same priority the one that was cerated before have the highest priority 
			return 1;
		}
		else if(Integer.compare(hourCreated, object.getHourCreated()) != 0) {
			return -1;
		}
		else {
			return 0;
		}
	}
	/**
	 * Returns the priotiry of the task
	 * @return priority
	 */
	@Override
	public int getPriority() {
		return priority;
	}
	/**
 	* Returns the type of a task 
	* @return taskType  
 	*/
	@Override
	public TaskInterface.TaskType getTaskType() {
		return taskType;
	}

	/**
	* Sets the priority of a task with a given integer
	* @param priority
	*/
	@Override
	public void setPriority(int priority) {
		this.priority = priority;
	}
	/**
	 * Increases the waiting time by 1
	 */
	@Override
	public void incrementWaitingTime() {
		waitingTime++;
	}
	/**
	 * Sets the waiting time to 0
	 */
	@Override
	public void resetWaitingTime() {

		waitingTime = 0;
	}
	/**
	 * Returns the current waiting time
	 * @return waitingTime
	 */
	@Override
	public int getWaitingTime() {
		return waitingTime;
	}
	/**
	 * Returns the hour that the task was created.
	 * 
	 * @return hour created
	 */
	public int getHourCreated() {
		
		return hourCreated;
	}
	/**
	 * Gets the task description.
	 * 
	 * @return description
	 */
	public String getTaskDescription(){
		return taskDescription;
	}
	@Override
	public String toString(){
		String returnStr = "";
		
		returnStr += taskType + " " + taskDescription + " at Hour: " + hourCreated + ":00";

		return returnStr;
	}
	

	

}
