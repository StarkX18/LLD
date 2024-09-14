Agenda:
1. How to approach schema design - best practises
2. How to code
3. Design tic tac toe
-----------------------------------------------------------------------------------------------------------------------------------------
Schema Design: 

Pre know:
cardinalities of relationships

one to one: put id of one on another side
one to many: put id of N side in one side
many to one: mapping table

just before schema design - class diagrams was made

#1 For all classes - create table
#2 Put primitive attributes (not relationships to other classes) - seperate cols (BMS ticket example)
#3 For all Relations:
      1. find cardinality
      2. based on cardinality represent accordingly
      3. edge case: too many nulls - sparse relations - mapping table
-----------------------------------------------------------------------------------------------------------------------------------------
How to code:
interview metrics:

1. project structure - pkg, classes etc
2. atleast something runs! 
      - not all requirements -> finish ONE AT A TIME -> not parallel
      - code all the models (classes in diagrams)

Running code is important!

Model controllers and services - project structure

Restaurant:
1. waiter - take order, pass to chef - in big restro - may go to multiple chefs! 
2. chef - cooking -> main work
3. ingredients -> inventory

client: user
controller - waiter: part of codebase that directly server the request
services - chef : main work done here using ingredients
db - inventory: models/entities - repository

models/ - all classes in class diagram
daos or repositories/ - all classes that query the db
services/ - hardwork
controller/ - waiter classes

Django springboot js express 

follows conventions across all languages
-----------------------------------------------------------------------------------------------------------------------------------------
Design tic tac toe:

#0: overview - align with problem and its type :

1. align :  this is what I know about the game: 1-2 line about the statement.

2. type: what exactly do you want me to design? 
- entities?
- system around it? interactive  or web?
- ui or cli
-----------------------------------------------------------------------------------------------------------------------------------------
#1 gathering requirements:

1. ideas and features: take charge - 
    - is size variable? yes
    - start from outside - players -> board.
    - players? - N-1
    - how many symbols? N-1 ofc!
    - what the criteria for winning
    - every player can choose their symbol - no same symbol
    - who will play first? randomise list and play in that order
    - is list randomised after each round?
    - only bots or humans? (***) - bots too
    - how many bots? all bots? no only 1 bot.
    - diff levels for bot? E/M/H
    - timer between moves? no
    - when and how does game start?
   - when and how does the game end? either one won, or all except one have won - only one winner here or draw
   - tournaments? no
   - pause/resume/exit? no
   - leaderboard
   - how to decide vixtory? multiple ways -       
                    - 5 algos (say)
   - num playersz? atleast 2
   - blocked cells?

any more features?  - Naman
   - undo moves? anyone can do any time and any
      number of times!
   - coinbase/cred etc (design problem+DSA!!!!)

naman's requirements:

rewatch? no
-----------------------------------------------------------------------------------------------------------------------------------------
Clarifying questions:

1. whose turn is next?
2. making a move question? when will someone win.
3. multiple behaviours
4. how many undo?
5. themes? no wtf? no ui!

next step -> use case diagram: only web apps
next step -> class diagram! - 

nouns or visualisation - outer to inner 
for games: visualisation is always better

class Board {
     char[n][n] -> what if empty : null, empty or         space? but its a hack - why?
      cell[n][n]   
}

class Cell {
     Player // if null cell also null
     int row, col
      bool iBlocked.  /// but not serving this rqmt plus no bool
     int cell state // improv over isBloclked just in case
}

class Player{
     - symbol
     - name
     - type (human, bot)
}

but we missed the outermost entry!

class Moves{
    - player
    - cell    
}

class Game {
    board[n][n]
    player[n]
    state // paused, in progress, over
    nxtPlayerIdx
}

In class diagram you ALSO tell about design patterns!

-----------------------------------------------------------------------------------------------------------------------------------------
#1. Game - singleton? no - multiple games might or might not be running concurrently!

** insight: when will you get list of players?
when will you chweck if 2 players have same symbol?
when player is init? no - then you dont know if symbols for all players

when game begins? YES! so when game object created!

so game ois a class has too many attributes, and also validations before object created!
hence: builder!

suggestions: 
flyweight to store lightweight player? 
- flyweght is used for repeated attributes! so NO

factory for players? not reallly needed

go through requirements! again!
only 1 bot per game: so validate on game builder!

bots have diff levels: not done
make bot child of player with only attr diff level enum

diff ways to decide vixtory!! -> ways -> strategy DP
- interface game winning strategy implemented by diff strategies by classes

similarly bot may play moves according to difficulty: bot playing strategy implemented by easy, mefium, hard classes
+ strategy factory <as discussed>

do we need observer pattern? when a player makes a move, Game should be notified to append in List<Move>

observer doesnt force - here it will make complex - if player move did a lot of things - then observer!
-----------------------------------------------------------------------------------------------------------------------------------------
How to implement undo?

1. remove move from list of moves
2. update board or other game states!

Here its easy but in game like chess which is complex?
NO! updating state might become very complex!
-----------------------------------------------------------------------------------------------------------------------------------------
lol ways 

KKHH ->

OmShantiOm -> undo = clear all states, except the last one ! done for chess!

computationally expensive! but not a lot of moves! 

this is how db manage data too -> transaction and commit laws!
-----------------------------------------------------------------------------------------------------------------------------------------
doraemon -> time machine
list moves, and list boards -> space wise complex!
if facebook stores ONLY info which is online status ->128GB -> not a lot -> space is cheap!

space time trade off!

what if redo: suggestion
note - undo is a global button!
-----------------------------------------------------------------------------------------------------------------------------------------
DIY:

- class diagrams yourself
- code all classes
- implement checking a winner in O(1) TC given board and last move
-----------------------------------------------------------------------------------------------------------------------------------------