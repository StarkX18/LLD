Similar problems ->

Movie booking System - Hotel / Plane / parking Lot / Taxi booking system

All similar.

First step in design?
------------------------------------------
#1 Overview : we know or we don't - about the system.

1. align on problem statement.
2. type of system - web API or 
     interactive.
------------------------------------------

------------------------------------------
#2 Requirement Gathering and Clarifications

1. features? 
2. scope of features?
3.  visualise flows? User journey 
      and physical entities!

------------------------------------------
CORE FEATURES ONLY - other things might just hurt you later in an interview

1. notifiications?
2. 10 tickets per person
3. one seat only one person
4. cancellation
5. refunds
6. partial payments
7. features in movies? 2d/3d
8. concureency at various points - how to handle?
... so on

ASS-U-ME : 3 words
never assume anything :P

-----------------------------------
#3 Class diagram

Nouns + Visualisation
-----------------------------------
7 minutes pls!
-----------------------------------
List of classes of entities in my design?

Visualisation of user's journey : 
mine:
- city 
- ticket,
- movie/shows,
- notifications
- seat
- payment
- theatre,
- cinema-hall

-----------------------------------
neeraj:
BMS,Admin,User,City,CompanyOfTheater,Theater,TheaterAdmin,TheaterLocation, Audi,Movie,Shows,Seat,Payment,Invoice,Ticket

should BMS be a class? why or why not?

naman: class diagram:

1. city: id, name,  + (list<theatre> or city in theatre, 
     or city theatre -> when do we do? when 
     relationship has attributes OR not m:m 
     relationships, which are sparse relations)
2. theatre: id, name, address, list(auditoriums>, 
     company
3. auditorium: id, name,  list<features enum>, 
     list<shows>(not rqd 
    here - there should be audi in show class!)
4. show: id, name, audi, start, end , movie, 
      list<features>
5. seat: id, status, seat-Type - can vary, name
6. seat-Type: because too many diff types 
..

still contd!


*** status will NOT be a prop of seat!!!!!

status is a property of a seat for a particular show - ie it is an attribute of a relation!

# how to store seating arrangement? how do they do this??
- position of screen??
--- 

movie: id, name, list<actor>, genre, etc
actor: id, name

now we have represented all the enitites in the flow, but we need extra classes to provide some fxn

show-seat: because relation has attributes!
- id, show, seat, status enum.


*** status will NOT be a prop of seat!!!!!

status is a property of a seat for a particular show - ie it is an attribute of a relation!

# how to store seating arrangement? how do they do this??
- position of screen??
--- 

movie: id, name, list<actor>, genre, etc
actor: id, name

now we have represented all the enitites in the flow, but we need extra classes to provide some fxn

show-seat: because relation has attributes!
- id, show, seat, status enum.

payment: id, status, txn_id, 3rdPartyId, 
ticket: id, show, list<payment> coz partial 
               payments supported, list<show-seats>, bookdBy, bookingTime


--- ticket price calculation? clarifying question - how is it calculated!

- for every show, every seat type might have diff price.
ie price is a prop of show for a particular seattype in a particular auditorium

hence:
class show-seattype : id, show, seattype, price ...
1 VIP 150

class diagram done!

why this new class? why not showSeat class? Because, seatType can also be driven from Seat ?

redundancy is eliminated. how?


For cancel/refund, do we need separate PaymentRefundClass ?

in the refund: might need a class 

schema design:

what do we do about enums in db schema?
- option1: store string value as it is - too much storage and db inconsistencies in case of modification of values
- conversion to int: might lead to corruption if change in enum values
- hence: mapping table: id and value

for every enum create a table and consider it as a seperate class during schema design!

show-seat-type
show-seat-status
feature

ORM to handle problems with enums...

why is seat type not an enum but a seperate class

whatever is left after represengting all classes in db:

are associations - relations:

find cardinality and represent!

hw:

1. complete schema design of bms. - if not revise parking lot

2. create a java project and represent all classes as per above in models following good pracgtises

- like id in every base model
- all attributes in private
etc
