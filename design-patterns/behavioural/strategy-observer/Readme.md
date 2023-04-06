# Strategy DP

Use case: Google Maps -> car bike walk -> if else violates SRP
#1 When there are multiple different ways to do something 
- chances are our codebase might violate SRP and OCP

#2 strategy DP: 
- instead of implementing them in seperate methods -> implement them in seperate classes! why the fuck?

#3 where will these classes be called from? same if-else phenom? NO, wont solve either SRP or OCP
- create an interface (DIP) for these classes (parent and child) to talk to each other!
- use factory DP (a very wide used coupling) -> because now we want the correct implementation of the interface based on the param! - so you get the right implementation.
- now gmaps -> 
findPath(to, from,mode){
    PC pc = new PCFactory(mode)
}
-----------------------------------------------------------------------------------------------------------------------------------------
Strategy DP rephrased:

When multiple diff ways to do something - use an interface and implement it using diff classes for the diff behaviours!
Rainwater trapping problem:

1. brute force: n**2, 1
2. bit optimal: n,n
3. most optimal: n,1

DIY!
implement the solution using which solution you want
https://github.com/Naman-Bhalla/lldSept2022/tree/master/src/main/java/designpatterns/strategy
-----------------------------------------------------------------------------------------------------------------------------------------
Observer Design Pattern:
In amazon order placing service - you have a lot of different services which you have segregated using facade DP.
But now - orders are dynamic ie you might want to disable notifications, live tracking or offer some premium service for premium customers.
Pub/Sub Model -> you want to register services which are being enabled and not those that are disabled.

#1 Create register/deregister methods in Amazon Service class, add them to list of subscribers, thats all - why? 
#2 Register the subs -> NOT in main class - NEITHER via dependency injection but in their own constructors! - why?
-----------------------------------------------------------------------------------------------------------------------------------------
Observer DP:
When you may want to change what happens on occurrence of an event and decouple the code from where the event is generated to what gets done on event - consider using observer!

This is very much like Pub/Sub model- > producer/consumer too - hence ensuring loose coupling between them amazon class acts a registry here?
Note - amazon is a global singleton object

DIY: read about observer
doubts:
If polymorphism pillar was not there, most of the design pattern wouldn't have existed
-----------------------------------------------------------------------------------------------------------------------------------------
DIY:

1. Rainwater trapping problem - using strategic
2. Pinned messages
3.  Observer DP

https://refactoring.guru/design-patterns/observer/typescript/example
https://github.com/Naman-Bhalla/lldSept2022/tree/master/src/main/java/designpatterns/observer
https://github.com/Naman-Bhalla/lldSept2022/tree/master/src/main/java/designpatterns/strategy
-----------------------------------------------------------------------------------------------------------------------------------------