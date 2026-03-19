Adaptor DPs:

Adaptor - Power adaptors and converters
- It adapts one form to other
- If apple wanted all ports - it would write code to support all of them
- but now it designs only C type - the rest is done by adaptors!

Problem Statement for Adaptor DP:

Our sw might always use 3rd party - their APIs/libraries/SDKs .... etc

1. their code might become unusable - non maintainable
2. you might want to switch due to any issues - performance/debugging/security or just cost


baseline: want ot migrate to some other 3rd party - like PhonePe's shift to ICICI from YesBank


Adaptor design pattern solves maintainability issues when we are talking to 3rd party APIs/SDKs/libraries!

How?

1. If codebase directly talking to 3rd party APIs - it needs alot of TIGHT coupling between them

- anyways two classes should be directly talking to each other - Design Inversion principle!
- they always talk via an Interface!

Just like USB to thunderbolt adaptor - interface being the adaptor!

#1 when you connect tio 3rd partry - create an interface first - saying what you need from the third party 

- Eg : In case of phonepe
getBalance, sendMoney, checkUser etc

#2 who implements this? We! Since 3rd party wont create it for us.
Now you must create a wrapper class -> implements our interface and uses 3rd party library...

YesBank API adaptor - sample class implementing Bank API interface!
 
 Benefits:
Now when you want to migrate and use ICICI adaptor - you just need to point your interface to ICICI API Adaptor class - implements using the available APIs.

What it addresses?
- OCP and DIP while using 3rd party APIs
- regressions - features that might be working earlier dont work now
- reusable and maintanable

When to use?
- Talking to 3rd party API - and major uses

How to?
see next

Implementation:

-------------------------- earlier -------------------
class PHonePe{
    YesBank yb = new YesBank()
}

--------------------------- later ------------------------
class PHonePe{
    BankAPI bank;    // whoa!
}
use dependency injection to create rqd bank objects from client side

Why is this structural and not creational DP?
creational DPs solve constrained problems wrt creation of objects
- how to create a class so only one object can be created
- how to create objects in more descriptive way
- how to have a class which can create objects for me!
...
etc


This solves the problem of how to maintain your codebase for talking to third party APIs

Case study 2: Calendly :)

- Allows users to create meeting scheduling links.
- eg: getSchedule, setSchedule etc

Problem STatements:
1. what 3rd party APIs might it be using?
 - ms, google and apple calendars?
 - zoom/meet/teams etc

Another point!
If I am using AWS services like s3, sqs, rds - Can I design my classes using Adapter design patterns instead of calling them directly from any class?

Facade Design Pattern:
Facade - boundayr/outside of a building

Facade >> inner turmoil
-> provides a cleaner/simplified view of a complex env

Use case: Bank relationship manager for premium accounts! -> acts a s a facade by simplyfying banking experiencwe.
-> if he wasnt there - he might have to do itself?

Amazon use case: INSANE! - why flipkart lost :)

orderPlaced(){
    - inventory update
    - notify seller
    - notify user
    - notify logistics
    - app notifications
    - schedule delivery    
etc 
}

Each might use a seperate object! With a LOT of bulk work!
- It will be a VERY complex class!

FACADE DP 
- when you find a method or class that does a lot of work - create a wrapper class/helper class to do it!

Why use it? Because it provides a simplified interface to client

Its like simnple utils class - delegating work

All of us must have used without even knowing it

Can you use adaptor and facade together?
PhonePe example:

DIY:

1. Video on facade
2. Proxy and Bridge DPs
3. See the pinned messages :P

https://www.youtube.com/watch?v=K4FkHVO5iac
https://github.com/calcom/cal.com
https://github.com/Naman-Bhalla/lldSept2022/tree/master/src/main/java/designpatterns/adapter
https://refactoring.guru/design-patterns/proxy https://refactoring.guru/design-patterns/bridge
https://calendly.com/naman-scaler/scaler-student-catch-up