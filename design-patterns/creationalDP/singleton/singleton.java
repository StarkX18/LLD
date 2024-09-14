/*
    singleton design pattern - 
    1. only one instance of the class should exist
    2. global access to the instance
    3. lazy loading
    4. thread safe

    Singleton pattern is used for logging, drivers objects, caching and thread pool.
    Singleton design pattern is also used in other design patterns like Abstract Factory, Builder, Prototype, Facade etc.
    
    Common steps across approaches:
    1. create a private constructor
    2. create a private static instance of the class
    3. create a public static method to return the instance

    #1 eager loading - pre-load the object at the time of class loading
    pros:
    1. thread safe
    2. easy to implement
    3. If dynamic configs are NOT a problem - stick with the solution!

    cons:
    1. instance is created even if it is not used
    2. can't do dynamic configurations of the singleton object, during runtime 
*/

class singleton {
    private static singleton instance = new singleton();

    private singleton() {
        System.out.println("Singleton created");
    }

    public static getInstance(){
        return instance;
    }
}

/*
 * lazy loading - with concurrency issues - load the object when it is required
 * pros:
 * 1. instance is created only when it is required
 * 2. dynamic configurations of the singleton object, during runtime
 * 
 * cons:
 * 1. not thread safe
 * 2. relatively complex(elusive) to implement
 */
class singleton_lazy {
    private static singleton_lazy instance = null;

    private singleton_lazy() {
        System.out.println("Singleton created");
    }

    /*
     * if two threads - t1 and t2 - call getInstance() at the same time,
     * both threads will get null and both will create a new instance.
     */
    public static singleton_lazy getInstance() {
        if (instance == null) {
            instance = new singleton_lazy();
        }
        return instance;
    }
}

/*
 * lazy loading - without concurrency issues - load the object when it is
 * required
 * 
 * how to implement: what's different this time?
 * 1. private static instance is initialized with null
 * 2. double check locking mechanism is used
 * 3. synchronized keyword is used
 * 
 * pros:
 * 1. instance is created only when it is required
 * 2. dynamic configurations of the singleton object, during runtime
 * 3. thread safe
 * 
 * cons:
 * 1. relatively harder to implement
 * 2. relatively slow plus synchronized keyword is relatively expensive -
 * synchronized keyword can reduce performance by a factor of 100
 * 3. only one thread can access the method at a time - only the first case is
 * helpful, the rest times sync adds additional overhead
 * 4. synchronized keyword can cause deadlocks
 */

class singleton {
    private static singleton instance = null;

    private singleton() {
        System.out.println("Singleton created");
    }

    /*
     * if two threads - t1 and t2 - call getInstance() at the same time,
     * handle by using in-built java synchronized keyword.
     */
    public static getInstance(){
        if(instance == null){
            // what to use inside synchronized parentheses?
            synchronized(singleton.class){
                // double check locking - in case two threads arrive just outside sync at the same time
                if(instance == null){
                    instance = new singleton();
                }
            }
        }
        return instance;
    }
}

/*
 * addressing problems with synchronised keyword:
 * # suggestions:
 * 1. volatile variable
 * 2. static helper class
 * 
 * # another problem: serialization and deserialization
 * 
 * # Actual solution to solve everything:
 * => singleton using enum
 */