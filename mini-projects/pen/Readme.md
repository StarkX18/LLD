Happy 2023, everyone! I hope this year brings us all our dream jobs :)

Agenda:

1. Types of LLD interviews
2. Approach different LLD interviews
3. Design a pen

Types of interviews:

theoritical (only theory) -> Design (all except working code) -> machine coding (all)

(MS/Amazon/Oracle/MMT) => (FAANG) => (Top startups - Flipkart/PhonePe/Scaler/Cred/Curefit/Scaler) 

Case study

Steps for design rounds -> (~ 45m)
- lead the design, let interviewer be on mute

#1. Single line problem statement -> GATHER requirements (~12-15m)

    example -> Design BMS
    expectation -> 
     *1 define scope, what exactly to 
           do.
           - COD? diff cities? wallet? events? partial 
              payments etc

     *2. Clarify and ask questions. 

#2 Use case diagram (sometimes): ask 
       interviewer (~5-8m)

#3 Class diagram (vv imp):  (~10-12m)
       - focus on classes to represent entities, 
          interfaces, design patterns
       - less on helper classses, 3rd party etc

#4 Schema Design (sometimes): (~5-8m)
       - ask interviewers

#5 Write on paper - some part of code (remaining time)

Steps for machine coding interview  (2h 30m) ->
#0 Detailed doc problem statement mostly.
 - example: 
https://docs.google.com/document/d/1JE2zuEWXF3ex5cuEde6rqyMYo338xhGF7oVvQMgW8ls/edit?usp=sharing

30m - 1h 30m - 30m

#1 Clarify (vvv important)  (5-10m) - requirements, edge cases -> leave no scope for ambiguity"

#2 Class diagram (no use case) (10-15m) 

#3 Schema Design (Db tables) (8-10m) 

#4 Complete working code (1h 30m) 

#5 QnA (interviewer to candidate) (30m)


How we learn -
1. single line problem
2. gather requirements
3. clarifying questions
4. class diagram
    (DIY) -> use case diagram
5. Schema design
6. Code

Deep dive on each step:

sample problem -> design a pen -> single line statement

1. Clarity:
     A. overview 
           - what problem statement is the system 
              solving? 
               - what kind of system?  
                  - entity(pen)
                     -> focus on classes and structure/  
                          interactive system (stateless, like 
                          chrome games)  
                     -> system (BMS/Splitwise)
           - expectations from interviewer  
                - tell what you know.
                - ask interviewer about problem 
                   statement
                - interview specific questions 
                   - only theoritical, design, or code.
                   - entity, interactive or system
                   - what all do you need? class? schema? 
                      use case diagrams? am I coding?
                   - if you are coding - how to take input? 
                       cli(no framework) or 
                   web(REST/gRPC etc)

Design a pen -> getting clarity:

1. don't do questions which are endless tunnels 
     -> which exactly - drawing pen or notebook.
          - instead: I HAVE used a pen but I don't 
             understand the problem statement.          
          - Do you want me to represent classes to 
             represent the varieties of pen out there? 
        
2. Gathering requirements:
     - suggest ideas, do NOT ask for requirements 
        blatantly. Do a POC. 
     - focus very strongly on core features (3-4). 
        and then secondary features (5-8 net)
     - visualise via overview

     Example: now the problem statement is 
     - represent the diversity of pens around you.
     - what qualifies as a pen? anything that can 
        write
      - what diff kinds? ball, gel, fountain
      - always ask top down questions
      - diff colors of ink
      - what info to be stored? brand, name, price.
      - can we change refills? for some 
      - pen/nib of the refill - does radius need to be 
         stored?
      - durability, salient features, etc.. (suggestion)
      - ink features?

Gathering requirements : was about features.
Clarifying requirements : behaviours 
 - how are the different features going to behave 
    in different cases, 
 - edge cases 
 - future modifications to a feature

- Purpose of entity design : Can you take a 
   simple entity and translate it into class 
   diagrams etc?

---------------------------------------------------------------
- what were the diff behaviours a pen has? write 
   and refill -> any questions on these 
   behaviours?
   - Can multiple entities share the same 
      behaviour? which DP are we talking about?
      - flyweight, strategy or factory
      - its about behaviour so def behavioural
      - when you hear multiple ways to do 
         something -> strategy.

Creational DP :
- Creating an object of pen with multiple 
   attributes: builder
- Based on input - correct type : factory

Use Case Diagram / Class Diagram:

How to come up with class diagram?
- visualisation (entity, interactive)
- finding nouns in requirements (machine coding)

Only expectation: show classes for entiites - no helpers, no controllers, services, db, loggers or helper classes (which help the code run) etc

Show classes and interfaces if using any DP.

How to visualise?
#1 (entity/interactive)
-> Mental model / Sketch of a system
-> go top-down

#2 (system)
-> User journeys (working of behaviour)

#3 Class diagram of pen:
-> why abstract/interface/class? abstract - coz we 
     dont want to create objects of pen directly - 
     only variants.
-> write will be method of all pens - so only write 
     in pen. Not refill coz some pens might not be 
     refillable 
-> create specific child classes 

Diff entities:

ball, gell, fountain
refill
ink
nib

-> dont go with booleans: to describe features of ink:  istransparent, isWaterproof etc -> non extensible.

instead consider ENUMS! -> extensible -> features enum
not even int!

write behaviour - strategy DP, why?
pen -> Pen factory DP. why?

one core requirement: refill or not:

interface: refillablePen : refill()
<br>
Schema Design and code : left