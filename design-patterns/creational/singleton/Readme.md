Singleton DP:
Allows you to restrict a class to have only one instance/object of it created at max.

1. Why would we want this?
- suggestions: global configs, DB connections, Loggers.
- discussion on why loggers - single object required.
- discussion on why db object - only one is required.
    - in case - db hosted on another server - needs 
       network connection -> TCP/UDP. TCP -> 
       consistency and stability -> uses in memory 
       and hence memory leaks.


- Answer:
1. Shared resources: DB, Logger - every object does same thing - why use many objects - revisit.
2. Stateless classes - no attributes. -  revisit.
3. When objects are expensive to create ->
     - DB connections:  3 handshakes, network 
        objects...etc
4. When objects are immutable (And you need only one object)

--------------------------------------------------------------------------------------------------------------------------

# How to make a class singleton?
* Till the time a class has a public constructor - it cant be singleton.

- suggestion: make the constructor return same object. Cant do - why?

- but if pvt - you cant create a single object. because pvt cant be accessed from outside.
- only way to create new obj is with new() and call constructor.
-> call constructor from some public fxn
-> add static - allows fxn to be called without obj.
- but now anyone can call it many times.
- store a "static" ptr : first time - allot the ptr to new obj, else return same obj. SIMPLE! 


Still a problem: concurrency is a bitch!
How to handle?
1.  set the static ptr to new object at class load time -> even before a constructor is called!
-> even handles concurrency!

But class load times becaomes slow - > and 

P1 --- application startup time increases

Eager loading - our case - create in advance - even before application runs!
Lazy loading - earlier cases! - creating attributes when. needed
Problem - conc urrency

P2 --- configs can not be passed at startup time!

If this is NOT a problem - stick with the solution!

But this factor alone makes eager loading - as incomplete solution to our singleton problem.


If eager loading isnt a feasible solution  to address concurrency - address it directly! :

"Synchronized" keyword! : makes  your fxn synchronous.
- which fxn? The public static fxn which is calling our private constructor!

What does "synchronized" keyword do?
If threads t1 and t2 arrive at same time - only one of them is allowed in.

- using locks - while one thread is in the fxn - no other thread can enter - until after it exits this fxn!
 

 Sync is still a problem!
T1 and T2 threads clashing - is only a possibility ther FIRST time -  but later on - everytime our public fxn is called, the fxn is locked!


How to solve it?
My idea: 
instead of making the whole public fxn synchronised - can we make only the constructor as synchronous?

Suggestion:
1. Sync block can be placed before if - wrong - again correct but overkill since the issue we are trying to address isnt addressed
2. Place it AFTER "if (instance==null)"- naman - fast but incorrect - 2 DBs will be created!


How to solve this problem?
check inside as well!
ie
place sync within if - but also place ANOTHER if - right inside the sync block - in case 2 threads. are waiting outside the block!

This method called - "double check locking" is an industrywide stdd to solve concurrency problems.

Approach?
First check result without taking lock
Take lock
Again check for result.


volatile variable?


STILL a problem!
Serialization / Deserialization issue:
Converting an object into a stream of bytes / and back.
python: pickle - save ML models.

Issue: existence of two objects at the same time!

Solution:: Learn how to implement singletons using enums



homework:

1. Singleton using enum - best implementation
2. Visit the links
3. Code singleton DB yourself.

links:
https://stackoverflow.com/questions/137975/what-are-drawbacks-or-disadvantages-of-singleton-pattern
https://refactoring.guru/design-patterns/singleton
https://github.com/Naman-Bhalla/lldSept2022/tree/master/src/main/java/designpatterns/singleton
https://twitter.com/Piwai/status/1530057291549921282/photo/1
