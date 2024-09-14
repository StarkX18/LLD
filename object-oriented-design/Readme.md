The SOLID principle helps in reducing tight coupling. 

// https://www.geeksforgeeks.org/solid-principle-in-programming-understand-with-real-life-examples/

1. Tight coupling means a group of classes are highly dependent on one another which you should avoid in your code. 
    - Opposite of tight coupling is loose coupling and your code is considered as a good code when it has loosely-coupled classes. 
    - Loosely coupled classes minimize changes in your code, helps in making code more reusable, maintainable, flexible and stable.
-----------------------------------------------------------------------------------------------------------------------------------------
# SOLID Principles

1. Single Responsibility Principle: This principle states that “a class should have only one reason to change” which means every class should have a single responsibility or single job or single purpose.
    - Most of the time it happens that when programmers have to add features or new behavior they implement everything into the existing class which is completely wrong. 
    - It makes their code lengthy, complex and consumes time when later something needs to be modified. 
    - Use layers in your application and break God classes into smaller classes or modules.

2. Open/Closed Principle: This principle states that “software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification” which means you should be able to extend a class behavior, without modifying it.
    - Suppose developer A needs to release an update for a library or framework and developer B wants some modification or add some feature on that.
    - Then developer B is allowed to extend the existing class created by developer A but developer B is not supposed to modify the class directly. 
    - Using this principle separates the existing code from the modified code so it provides better stability, maintainability and minimizes changes as in your code.

3. Liskov’s Substitution Principle: Derived or child classes must be substitutable AS-IS or their base or parent classes.
    - any class that is the child of a parent class should be usable in place of its parent without any unexpected behavior.
    - You can understand it in a way that a farmer’s son should inherit farming skills from his father and should be able to replace his father if needed. If the son wants to become a farmer then he can replace his father 
    ?? - but if he wants to become a cricketer then definitely the son can’t replace his father even though they both belong to the same family hierarchy.

4. Interface Segregation Principle: do not force any client to implement an interface which is irrelevant to them.
    -  Here your main goal is to focus on avoiding fat interface and give preference to many small client-specific interfaces. 
    - You should prefer many client interfaces rather than one general interface and each interface should have a specific responsibility.
    - Using this principle helps in reducing the side effects and frequency of required changes.

5. Dependency Inversion Principle: 
    - High-level modules/classes should not depend on low-level modules/classes. Both should depend upon abstractions.
    - Abstractions should not depend upon details. Details should depend upon abstractions.
    - if a high module or class will be dependent more on low-level modules or class then your code would have tight coupling and if you will try to make a change in one class it can break another class which is risky at the production level. 
    - So always try to make classes loosely coupled as much as you can and you can achieve this through abstraction.
    
-----------------------------------------------------------------------------------------------------------------------------------------