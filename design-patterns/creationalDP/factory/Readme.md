# Factory Design Pattern

1. Factory method design pattern
2. Abstract factory design pattern
3. (unofficial) Practical FP DP
------------------------------------------------------------------------------------------------------------------------------
Factory Method Design Pattern:

Eg - simple user service 
1. How to register a user? Where will it go?
2. (A) if DB used is a real class -> DIP
   (B) if DB is interface
   (C) if DB is abstract class

(A) will it support migration?
(B) will the queries  be uniform across DBs? Now will someone also implement Query interface?

Violates SRP as well as OCP! -> will you change it everywhere? where everywhere?
- purpose of createQuery - based on DB type: create a query object...
what is "Factory" ? create a new object of class based on some parameter!
------------------------------------------------------------------------------------------------------------------------------
# What is FM DP?
- use case: We might need to get one object from some other corresponding object (DB->Query)
- A method in a class that returns nothing but the method of corresponding class - factory method! -> here createQuery!
?? - In builder design pattern -> get Builder - was it factory? Why?

If a class has a method which does nothing except give you an associated object of another class -> factory method
If it wasn't present -> SRP and OCP violated.
------------------------------------------------------------------------------------------------------------------------------
Dependency Injection!
Factory method thus prevents you from storing the mapping between two classes  in a third external class.
See code sample!
------------------------------------------------------------------------------------------------------------------------------
New real problem statement :

On the client side, do we need to cast Query?
What if we require JSON queries that are not supported by MySQL?
> Query q = db.createQuery();
> q.executeJSONQuery();
> Should all DB have to implement this method ? What if they don't support this functionality?

How will our code look like or change?
What if some other functionality other than queries also required?

SRP would be violated! setUrl, setHostName, setConfig. .. etc is fine but the other functionalities dont!
Breakup the classes -> 
the second set are abstract factory methods: createQuery, createTransaction...etc
if a class starts having alot of factory methods -> violation of SRP -> put all methods in seperate class!

comment : Interface segrergation of two classes? what was that?
-----------------------------------------------------------------------------------------------------------------------------------------
So now we have two classes:
interface DB{}
interface DBFactory{}

class MySQL and also -> MySQLFactory
How to get a query in registerUser?

vvv important!
have a factory method in interface DB!
-----------------------------------------------------------------------------------------------------------------------------------------
# use case
flutter/reactNative : multiplatform UI dev
- these create android, iOS, web apps from same code!
- eg: return button object! 
    -> violates SRP
 - see the example!
-----------------------------------------------------------------------------------------------------------------------------------------
# using abstract Factory design pattern

What will abstract factory method return?

same datatype or some other type?
what can you say about factory methods now?
-----------------------------------------------------------------------------------------------------------------------------------------
# Practical Factory DP:

use case: create correct type of an object based on a given parameter!
- dont put the code in client -> why?
1. OCP
2. code duplication

- while implementing flying behaviour -too many if else - SRP and OCP violations!
- but here it isnt! because its part of business logic!

# Practical factory:
create an object of correct subtype of a class/interface based on a param
class DBFactory -> client main psvm : public static void main.
When you see inheritance relation = think if you may need practical factory.

Diff from factory? In factory you have a class alrready aznd you need an object!
Here you dony have a class even - which class to create!
Practical factory : Most relevant and imp

Factory method and abstract factory: You already haver an object - based on it you want another objecty of snother class
- bad way: if elsae in client
- good way: factory methods!
-----------------------------------------------------------------------------------------------------------------------------------------
# DIY
code a UI in flutter!
https://refactoring.guru/design-patterns/factory-method
https://refactoring.guru/design-patterns/abstract-factory
https://github.com/Naman-Bhalla/lldSept2022/tree/master/src/main/java/designpatterns/abstractfactory
-----------------------------------------------------------------------------------------------------------------------------------------
