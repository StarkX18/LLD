Design a real world system: Parking lot

#0 overview - align, type of system.
      - know or dont know? know
      - there should be a slot booking system
      - fees based on time
      - do you want this kind of system? what kind of 
         app do I want to design? - online mgmt system    

similar to Airport mgmt , learner mgmt system(moodle)

#1 gathering requirements: sketch / visualise or use cases? 

visualise the entities and core use cases of it - opinions - start with the MOST minimal things
- what constitutes a parking lot? - ask! 
- multiple floors?, yes
- any type to slots based on vehicles? yes, 
- multiple entry points or single? multiple
- diff charges? to be asked later!
- admin can block slots? floors? yes
- curr status of lot? yes
- how to park the cars? any different ways?
- slot IDs with ticket IDs? too technical! 
- when a ticket is issued, a spot is assigned.
- fees? f(type of car, duration)

minimum set of questions! Naman's opinion
- floors
- entry gates
- are spots equal or position-based
- get ticket at entry with fixed fees or dynamic fees at exit?
- parking lot is operator driven!
- type of payment modes supported?
- any parking passes?

- spot is assigned at time of generating ticket
- for now - any random spot is assigned but maybe diff ways to assign in future
------------------------------------------------------------------------------------------------------------
whenever online payments -
- partial payment 
    - wallet + card
    - emi/loans
    - advance/complete at the end
----------------------------------------------------

- pasy later

use case skipped
class diagram -> visualise entity, user journey, all classes + DPs you might use!
-------------------------------------------------------------
Vishal Sharma
To: Everyone
10:11 PM
Classes that might be there:
Parking Lot
Spot
Operator
Floor
Vehicle <<interface>> + SubTypes
SpotState (enum - EMPTY, FILLED)
Ticket
DisplayBoard
PaymentMode (enum - CASH, ONLINE)
Payment/Bill
Gate
User
Design Patterns that might get utilized:
Strategy (for spot assigning - random or nearest first)
Strategy (for Payment modes - ONLINE, CASH, Partial)
Practical Factory (for implementing strategy for both payment and spot)
Builder - (for creating a parking lot which can have multiple attributes)
Adapter (for 3rd party integration for payments)
--------------------------------------------------------------

entities:

#1 parking lot -> floors -> spots -> vehicles
#2 gate -> enum -> entry or exit - if very simple 
      but here class otherwise too many nulls and 
      sparse table

now user journey for more:
#3 operator -> ticket -> bill
#4 display board

diff DPs:
1. assigning a spot, calculating fees - might be possible in many ways -> strategy - 2x
2. payment -> adaptor for 3rd party handling
----------------------------------------------------
Attributes:

0. in all of entities - ID is a must (why?)
1. parking lot: id, name, address, floors,list<gates>
2. floor: id, name, list<parking slots>
3. gate: id, name, type
     - entry gate - display board
4. parking slot: list<vechicle_types>, status enum, 
     name, vehicle-present
5. vehicle: type, number, owner<not required>, type 
     enum

- reserved parking spot for disability parking
- when we create parking spot object only one 
   value will be there

6. ticket: id, entry_time, operator, gate, spot
7. operator: name, emp_id
8. bill: id, amt, exit type, <ticket>, list<payments>, duration or exit time -> ticket has entry time, bill shouldnt have exit time or even duration , status enum

-- good design: once ticket created, ideally not want to edit the ticket!
9. payments: id, mode-> cash or online, provider, status, reference, one bill may have multiple amount! -> if bill already has amt, why would payment have an amt too?
10. display board: id, display()

Restaurant example:
- all these classes will be in models!

DIY:
1. write down requirement of PL and do class diagram yourslef
2. create a plain java project, package/modules and class for each entity identified above
3. 9-1 : interview or class time

Tip for coping with DSA and system design:

1. 2 problems atleast
2. dont spend more than 30 mins thinking ! its a waste of time