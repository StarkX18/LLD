Recap :  singleton
What - a class somehow allows creation of only one instance
Why - we don't need multiple objects - idk why - check again!
--------------------------------------------------------------------------------------------------------------------------
# How? 
1. lazy loading - with if cases -> cant handle concurrency.
2. eager loading - before class loads, already create -> cant handle configs/ environment variables -> but otherwise a good solution
3. lazy loading WITH Double check locking -> handles configs, low compile time too.

--------------------------------------------------------------------------------------------------------------------------
# Builder design pattern :

Problem statements?
1. Class has too many attributes!
2. Need to apply validations before creating an object of this class.

Picking the second point first! -> need to apply validations BEFORE creating an object.
eg Scaler student
1. grad_year<2022
2. email, name and phone number
*3. validations of combination attributes - grad_yr-age>1990 etc
--------------------------------------------------------------------------------------------------------------------------
How CAN we do this?

1. In constructor : throw exceptions in constructor after validating!
   - problem - object is ALREADY created (not mentioned) in 1st line of constructor.
   - But if you throw exception - the xcreated object is not reall assigned aqnd ois then collected by GC!

2. static method - class itself WONT do the validation but some outer fxn - like either client side etc!
- might or might NOT be a good idea - so not generalisable

3. Do validation in SETTER methods!
- called AFTER an  object is created, first of all
- what for the case of multiple attribute validation?
- if we want class to be immutable? cant use this! as setters are NOT created for such classes (along with pvt attributes)
--------------------------------------------------------------------------------------------------------------------------
* Too many attributes - 

1. Client side needs our object - potential for errors since sequence of attributes important!
2. Readability! - have to keep checking documentation if reading this code.

Solution?
1. constructor overloading -  
     - telescopic constructor concept - not a good 
        design choice!
     - problems :
        - might not compile - same signatures- thus 
           might not be possible to create these 
           combiis!
        - too many comniis of constructor
- question - doesn't it create a object? each time a 
   constructor is called?

Basically not even a single problem is solved!
--------------------------------------------------------------------------------------------------------------------------
# Takeaways:

1. Whatever validation - do before object creation.
2. The solution of telescopic constructor made client code unreadable!
--------------------------------------------------------------------------------------------------------------------------
# Problems:

1. Potentially lead to bugs
2. Understandability
3. Lots of nulls

To solve it: in the constructor ->
1. We need values to be recognisable!
2. Allows you to pass multiple values!

HashMap : everything is an object! There are object variations of the primitive types too!
Eg Student(Map<String, Object>Args); 
--------------------------------------------------------------------------------------------------------------------------
Problem with map:

1. Type safety - which will happen at runtime - if you self implement otherwwise not. This should ideally automatically happen at compile time!
2. Typos : key typos, etc

But a better approach than telescopic constructors.
Onto the next and best

1. Something with multiple values, 
2. each might be of different type, and
3. name of the "key" of values should be recognisable at "compile time"

Any language construct that supports this stuff? YES
Class! It can help with all the stuff -> Helper/Builder class!
Student s = new Student(Helper);
--------------------------------------------------------------------------------------------------------------------------
// ideally your codebase should be so elegant - that you keep drooling over :P

Problems:
1. To create main obj, you firwst neeed to create another object.
2. client can call main constructor with null as well!
     - will keep happening as long as the builder constructor is public   

Solution:
- make the constructor of main object private
- use a static getBuilder method to get a new Builder object -> until we can create a builder obj - we cant create the main object!

but STILL doesnt work because -
main object is not created as constructor is private for the builder!
can it somehow happen that builder is able to call the main object constructor?
who can call the private method of a class ? its own object / fxns only...
DIY -> concept of "inner" classes and "static" classes!
--------------------------------------------------------------------------------------------------------------------------
- what is psvm? in client code? public static void main()!

inner class -> same attributes as outer class
 - public static class Builder{}

public <mainType> build(){
    Builder b = <mainObj>.getBuilder()
     <mainObj> s = b.build();
}

Where do we want to reach?
<mainObj> x = <mainObj>.getBuilder().setName(name).setAge(age).build();

How to reach there? 
<mainObj> x = <mainObj>.getBuilder().setName(name).setAge(age).build();

code sample - check out! - "conversational" code...
good code is like a good conversation... :)
important points:

1. public static builder 
2. all setter methods return Builder object - here "this" -> makes the code beautiful, rather conversational!
3. take care of getBuilder and the validation wrapper
-------------------------------------------------------------------------------------------------------------------------------
When to use builder?
1. Class with too many attributes
2. Immutable class with many attributes - ALWAYS and STRICtzly
3. Class with validation - 90% time you use builder

Professional examples:
1. API calls - setting parameters 
2. QueryBuilders in SQL etc

Practical example:
Firebase: API reference - 87 builders
-------------------------------------------------------------------------------------------------------------------------------
RequestConfiguration
1. No setters in main class - coz immutable.
2. methodNames should ideally be verbs

Builders should ideally own validations, preprocessing etc...
-------------------------------------------------------------------------------------------------------------------------------
# DIY

1. Read about builder from refactoring.guru - 
    - https://refactoring.guru/design-patterns/builder
    - codebase in other languages too!
2. Implement builder in primary language + Java
3. Explore Firebase API and find why builders were used?
4. statuc and inner classes (optional) 
5. https://refactoring.guru/design-patterns/builder/csharp/example
6. https://firebase.google.com/docs/reference
-------------------------------------------------------------------------------------------------------------------------------
Cons - Singleton Design Pattern :

1. Makes testing difficult - while mocking or stuff
2. <optional> people wrap global variables in these classes - but not exactly a use case for singleton - so here the problem is with you!
-------------------------------------------------------------------------------------------------------------------------------
