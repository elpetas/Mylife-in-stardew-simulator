import java.util.Random;

/**
 * Randomly generates task at a given hour. Implements TaskGenerator Interface
 * 
 * @author Johann Vargas
 */
public class TaskGenerator implements TaskGeneratorInterface {
    private int currentEnergyStorage = DEFAULT_ENERGY;
    private Random random;
    private double probability;
    
    /**
     * generates a new random task given a certain probability and without a seed
     * @param taskGenerationProbablity
     */
    public TaskGenerator(Double taskGenerationProbablity){
        probability = taskGenerationProbablity;
        random = new Random();
    }

 /**
     * generates a new random task given a certain probability with a seed
     * @param taskGenerationProbablity
     * @param seed
     */
    public TaskGenerator(Double taskGenerationProbablity, long seed){
        probability = taskGenerationProbablity;
        random = new Random(seed);
    }
    /**
     * Returns a new task
     * @param hourCrated
     * @param taskType
     * @param taskDescription
     * @return Task
     */
    @Override
    public Task getNewTask(int hourCreated, TaskInterface.TaskType taskType, String taskDescription) {
    	
        return new Task(hourCreated, taskType, taskDescription);
    }
    /**
     * Reduces the current energy based on the current task type 
     * @param taskType
     */
    
    @Override
    public void decrementEnergyStorage(TaskInterface.TaskType taskType) {

        currentEnergyStorage =currentEnergyStorage- taskType.getEnergyPerHour();
    }
    /**
     * Reserts the current energy by the default value(200)
     */
    @Override
    public void resetCurrentEnergyStorage() {
        currentEnergyStorage = DEFAULT_ENERGY;
    }
    /**
     * returns the current energy storage
     * @return currentEnergyStorage
     */
    @Override
    public int getCurrentEnergyStorage() {
        return currentEnergyStorage;
    }
    /**
     * Set the current level of energy to a new given integer 
     * @param newEnergy
     */
    @Override
    public void setCurrentEnergyStorage(int newEnergy) {
        currentEnergyStorage = newEnergy;
    }
    /**
     * Generates a random probality and compares it to the given one
     * @return True if the random number is less than or equal to.
     */
    @Override
    public boolean generateTask() {
        return random.nextDouble() <= probability;   
    }
    /**
     * Determines the probability of passing out while perfoming a task
     * @param task
     * @param unluckyProbability
     */
    @Override
    public int getUnlucky(Task task, double unluckyProbability) {
        if(unluckyProbability <= task.getTaskType().getPassingOutProbability()){
            if(unluckyProbability <= task.getTaskType().getDyingProbabilityProbability() && task.getTaskType() == TaskInterface.TaskType.MINING){
                currentEnergyStorage = (75*currentEnergyStorage)/100;
                task.setPriority(0);
                return 2;   
            }
            else{
                currentEnergyStorage =currentEnergyStorage/ 2;
                return 1;   
            }
        }

        return 0;   
    }
    /**
     * Given toString method
     * @param task
     * @param taskType
     */
    @Override
    public String toString(Task task, TaskInterface.TaskType taskType) {
        if(taskType == Task.TaskType.MINING) {
            return "     Mining " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
        }
        if(taskType == Task.TaskType.FISHING) {
            return "     Fishing " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")" ;
        }
        if(taskType == Task.TaskType.FARM_MAINTENANCE) {
            return "     Farm Maintenance " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
        }
        if(taskType == Task.TaskType.FORAGING) {
            return "     Foraging " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")" ;
        }
        if(taskType == Task.TaskType.FEEDING) {
            return "     Feeding " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
        }
        if(taskType == Task.TaskType.SOCIALIZING) {
            return "     Socializing " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
        }
        else { return "nothing to see here..."; 
        }
    }
}
