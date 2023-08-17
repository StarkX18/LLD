Decorator and Flyweight Design Pattern
1 - ice cream, coffee, pizza,
    - html, spring

2. pubg

Decorator Design Pattern -

Ice Cream App: for assembled ice cream
- custom configs
- requirements:
    - build
    -  cost
    - description

How to build?

Approach 1:

ice cream class -> interface or abstract class

-> two subcklasses: cones, toppings

Problem:

1. Must be list oif cones and ice creams
2. But wont be able to mix and intermix cones and toppings
3. for cost and desc -> both classes will have samer fxns of getcost and getdesc

--- To address problems -----
Interface Ingredient - has both cone and toppings - can intermix, implements both the methods and solves our problem

Decorator DP comes in ...

For our ice cream problem - the ingredient interface solved our problem - but some specific use cases might not - lets see them later. For now...

Steps:

#1 Design an interface/ abstract class that defines the thing we are constructing

#2 Two types of things we might want to add.

- base add ons: cant make the object without them
- normal add ons: to be added on base!

- For each of these create a class that implements the interface like cones, syrups, scoops, berries - ALL of their subclasses

- if ONLY a base enitity - return cost/desc directly
- else append/add normal add ons too

### if a scenario's final output depends on the features/props/add-ons and base entities  both: 
consider decorator DP

- if you want to change behaviour/add etc at runtime: consider decorator DP

think of it as wrapping the object with more layers!

You are simply appending/adding to returned/base object

Examples -  
- HTML: create button -> add margin -> add padding etc
- SpringBoot : springboot.run -> secure_app.run -> webapp.run -> app.run <base class>
- Python: @lru_cache annotation and the concept of decorators in flask

- It means add to behaviour of something without changing the main thing

corner case:

if a class is both base and add on - like cone:
2 constructors -> one for add-on(with param of interface as input) and one for base(no param)

ALSO -> handle nulls properly! in case of params..!

DIY:

https://docs.google.com/document/d/1WJPCFDSCGlH3ZpK3vSdg23SIwH_042bBszY901fJP8k/edit?usp=sharing

https://docs.google.com/document/d/1aGMknAFiz4LSUuMMxZ8gJOoXWl166QLVsdcaCpB-UV0/edit?usp=sharing

https://docs.google.com/document/d/1aGMknAFiz4LSUuMMxZ8gJOoXWl166QLVsdcaCpB-UV0/edit?usp=sharing

https://refactoring.guru/design-patterns/decorator

can u give small demo for draw.io

Flyweight design pattern:

Eg -> online multiplayer game <battle royales> - mainly UI

at the end only one player will be alive - 2 guns/player, 300 bullets/player

- why this scenario? complete state of the game is downloaded ot the machine of each individual player
- after starting game - only the deltas are transferred! fuck!
- diff classes?
- bullet , gun, player, playground etc...

Focus on bullet class.
- radius, color, direction, wt, damage, speed, max range, current coordinates, target coordinate etc
- for UI - shape/image

how many bullets? 100*300
do I need to store only in use, or all. ALL.

now calculate size of 1 Bullet : 

8B radius, 4B color, weight 8B, max-damage 4B, direction (8+8+8)B, speed 8B, max_range 4B, curr coord (8+8+8)B, target coord 24B, image 1kB

-> 1 bullet object = 1.1kB
-> 300*100 objects = 1.1 * 10^5B = 0.11 GB = 100MB !

-> not feassible - for phones specially plus gaming - s optimisation rqd!

->now all bullets are NOT very different from each other - how to optimise!

Dealing with bullets:

- Intrinsic (wont change) and extrinsic(will change) props of a class.
- radius, color, wt, max damage etc will be intrinsic to bullet and be same for same type of bullets
- doubt: Intrinsic are like static class constants & Extrinsic are like class attributes....? - NO - coz diff type obj will have diff intrinsic props

Flyweight DP to the rescue
 

 Flyweight: 

USE CASE -> If you have a class where obj demo both instrinsic plus extrinsic AND with considerable side effects on memeory or performance

#1 Divide it into two classes : only intrinsic and only extrinsic props classes.

doubt: is intrinsic class going to be singleton? NO coz we need diff types of bullets!

#2 Now you need images of bullet - so flying bullet needs an attribute - Bullet

But now we are just storing reference to a bullet object! 

So only one object of bullet per type of bullet -> say 10 types of bullets ->  say 30k bullets in game

30k flying bullet objects, and 10 objects of bullets
vs
30k (flying bullet + bullet) generic class
 
we now have watered down the space from 100mb to 10mb

Now our class is not singleton - since we need atleast 10 objects accordsing to bullet types.

So this isnt a singleton bullet but -which one?
Registry DP! yaaaaaayyyy

DIY:
Design Pizza: 
https://docs.google.com/document/d/1aGMknAFiz4LSUuMMxZ8gJOoXWl166QLVsdcaCpB-UV0/edit?usp=sharing
https://refactoring.guru/design-patterns/decorator
https://github.com/Naman-Bhalla/lldSept2022/tree/master/src/main/java/designpatterns/decorator
https://docs.google.com/document/d/1WJPCFDSCGlH3ZpK3vSdg23SIwH_042bBszY901fJP8k/edit?usp=sharing https://docs.google.com/document/d/1aGMknAFiz4LSUuMMxZ8gJOoXWl166QLVsdcaCpB-UV0/edit?usp=sharing

H/W:
Design Pizza: https://docs.google.com/document/d/1aGMknAFiz4LSUuMMxZ8gJOoXWl166QLVsdcaCpB-UV0/edit?usp=sharing
https://refactoring.guru/design-patterns/decorator
Naman Bhalla10:20 PM
https://github.com/Naman-Bhalla/lldSept2022/tree/master/src/main/java/designpatterns/decorator
Naman Bhalla10:18 PM
https://docs.google.com/document/d/1WJPCFDSCGlH3ZpK3vSdg23SIwH_042bBszY901fJP8k/edit?usp=sharing https://docs.google.com/document/d/1aGMknAFiz4LSUuMMxZ8gJOoXWl166QLVsdcaCpB-UV0/edit?usp=sharing