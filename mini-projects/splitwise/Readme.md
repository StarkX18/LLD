1. Design splitwise
2. coding splitwise
3. spl case in splitwise <DSA>

recap:

1. pen - class diagram
2. tic tac toe: interactive
3. parking lot: mvc
4. BMS: mvc +springboot+hibernate
5. splitwise

#0 overview
- align with interviewer
- understand problem, headfirst
- identify type of system
   - class diagram
   - interactive
   - backend/web - models, controllers, services, repositories

- already aware of the system or not
- explain the system in one line/30 words

problem of different ui.

requirement gathering

1. draw a sketch
2. visualise user journey

https://docs.google.com/document/d/1JE2zuEWXF3ex5cuEde6rqyMYo338xhGF7oVvQMgW8ls/edit

transaction algo!
hint: using graphs: leetcode!


class diagram during break:

nouns:
-----------------------------------
groups,
users,
transactions,
expense

behaviours
-----------------------------
add,
remove
pay,
settle
------------------------------
https://github.com/Naman-Bhalla/bookMyShowJuly2022/tree/master/src/main/java/com/scaler/bookmyshow
Naman Bhalla10:29 PM
https://www.udemy.com/course/spring-boot-and-spring-framework-tutorial-for-beginners/
Naman Bhalla10:28 PM
https://www.udemy.com/course/spring-hibernate-tutorial/
Naman Bhalla9:33 PM
https://docs.jboss.org/hibernate/orm/current/userguide/html_single/Hibernate_User_Guide.html


1. design - done
2. algo for settlement ***
3. code later

Agenda:

# brief recall:
1. models
2. schema
 
# algos for settlement
 2 algos

# strategy for design

recall:

6 frnds ; Q W E R T Y
2 grps: 
roommates: Q W E R
office:  E R T Y


user: id, name, password
groups: id, name, list<user> participants, list<user> admins


schema design: TDB yourself
1. design class as separate tables
2. rest are relations - focus on cardinality and design accordingly

user-> group:

user: grp - createdby relation
1:1 - a group is created by one user
1:m - a user may make m groups

so pk on one side, fk on other
pk strored on m side, fk on side...<missed - check again>


user:grp - participants relation
1:m
m:1
= m:m

create mapping table: 
NOT user-grp because many user-grp relations!
grp-members
- grpId and userId
- seperate id as pk
- if no pk - combine data is pk


user-grp: admin relation
1:m
m:1
= m:m

another mapping table: group_admins

I have one confusion. If we have list of members in group, do we need list of admins as well? because admin is also a member of group. We can have user type in User or subclass of User.
Isn't that makes sense?

answered by people:

one user wont be admin for all groups!

schema design (contd):

class expense:
id,
name,
description
amount,
list<paidBy>,
list<sharedBy>

class paidBy:
// which user paid how much for each expense
id,
amount,
user,
expense

similarly seperate class for sharedBy

again why separate class for paidBy and sharedBy when we can have enum there in single class like user_expense? like 'paid' or 'shared'.

group expense: relation
1:m - 1 group has m expenses
1:1 - 1 expense belongs to 1 grp only
= 1:m relation

on expense side, store group id
ie pk of expense and fk of grp
- but then table will be sparse since all expenses are not part of group!

so seperate mapping table groupID and expenseId ?

because sparse tables waste space...

right now:

for each group expense: you modify 4 tables...

for each user expense, you modify 3 tables...

What level of normalization we should follow 2NF is fine ??
3NF
rememeber : 3nf vs 2nf

very very imp: Settlement!!!

1. user-user
2. user-group

take some examples for both and see!

example in class:
+ if they have to receive
- if they have to pay

A: 500-250-300-750= -800
B: 3500-750-300-250= 1200
C: 1000-250-700-750= -700
D: 1000-250-750-700= -700


sum always comes to zero.

anyways what we want:
exact WHO pays HOW MUCH to WHOM?!

to justify the need for splitwise: we need:

1. who pays, how much, to whom

IN

2. minimum transactions

-- to calculate min transactions for a settlement is an NP HARD problem!!!

Its never linear or polynomial - exponential !!!!

- so we will NOT be able to find min transactions but our algo will work in polynomial time!

algorithm :
1. find everyone's balance
2. produce transactions

focus on (2):

#1 - round trip:
pay to the next person - making your balance zero!
n people = n-1 transactions

#2 - heaps: 2 heap problem - see if you can find an algo -  otherwise check the steps here


# actual splitwise algo from the founder:

https://www.quora.com/What-algorithm-or-solution-do-the-people-at-Splitwise-use-for-its-debt-simplification-feature

doubt:
backtracking are np-hard?

sudoku,
hameltonian cycles/paths,
travelling salesman

where are we impolementing the algos?
models? no
controllers? no
services! yes - in which 
strategy = algorithms

do NOT call strategy from repository

Shouldn't we pass the expenses list to the strategy? because it might be the case that they don't require hashmap aggregation logic. What are your thoughts on this?

how was this addressed

here is a problem . we need to call twice db if we take two table one is for pb and one is for shared by...

even joins decreased

DIY:

1. return list<transaction> - another class
- code up the transaction generation logic
- params: map(string: uid, int: bakance)

- using both algos mentioned

2. read splitwise algo