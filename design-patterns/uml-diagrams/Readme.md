UML Diagrams:

Agenda - 
1. class diagram
2. use case diagram
------------------------------------------------------------------------------------------------------------------------------
UML diagrams:

SDE pain points -
hard skill - coding
soft skill - communication
Sample SDE - code review, architect, manager etc

pics > words : "a picture is worth a thousand words"
but technical communication isnt art -> standards help our cause -> so no misinterpretation

UML -> Unified Modelling Language
- Allows to represent things uniformly
- standardization on how to represent diff SWE concepts via diagrams
- multiple types for multiple things

Types:
- structural: how a codebase is structured
- behavioural: how a system behaves
------------------------------------------------------------------------------------------------------------------------------
Structural UML:
1. class
2. package digram
3. object
4. component
------------------------------------------------------------------------------------------------------------------------------
Behavioural UML:
1. Use Case
2. Activity
3. Sequence Diagram
------------------------------------------------------------------------------------------------------------------------------
Use Case :
1. Different features and functionalities provided  
     in  a software system.
2. Who uses those functionalities.

5 concepts:
1. <rectangle> system boundary - in and out.
2. <oval> use case - fxn/ft/action/service that is provided - verbs generally
3. <stick diagram> actor - someone who uses our use case - nouns
4. <arrow> includes - see again
5. <specific/child to generic/parent arrow> extends - functionality where there would be multiple variants
------------------------------------------------------------------------------------------------------------------------------
DIY:

create a use case diagram for scaler:

1. 5 use-case
2. atleast 2 actors
3. atleast one use case muyst have specific types
4. atleast one use case must use another use case
5. no login use case

https://miro.com/app/board/uXjVP303sjM=/?share_link_id=492449005590
class diagram - more important, much easier
problem statement- represent diff entities in the software system.
represent relations between diff entities : is-a, has-a
-----------------------------------------------------------------------------------------------------------------------------------------
How to represent entities:
see video

access modifiers,
return type,
params,
name,
static words,
class,
attributes,
methods,
interfaces,
abstract classes,
enum
-----------------------------------------------------------------------------------------------------------------------------------------
representing relations between entities - 
2 types of relations - 

IS-A : inheritance : child is also a parent : child extends parents + also interface implementation...
HAS-A : association: have an attribute of another class...

Representing Inheritance: arrow from child to parent, class to interface etc
Representing Association <arrow ending in rhombus>: two types again - composition (strong association) <solid rhombus> and agggregation (weak association)<empty rhombus>
Aggregation : collecting the other entiites which existewd and made sense even without you.

Composition: opp of aggregation : eg shows -> tickets : tickets HAVE to be associated with a show. 
Hence a simple question to decide:
If A->B and B doesnt make sense without A - composition.

https://miro.com/app/board/uXjVP303sjM=/?share_link_id=492449005590
-----------------------------------------------------------------------------------------------------------------------------------------
