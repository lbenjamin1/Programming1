# Lab Description
This lab involves writing code for a game engine. It supports competency development and master. Upon completion of this lab
the student will:
* Implement the inheritance pattern with an abstract class.

## Directions
1. Complete the steps in the assignment below
2. Save your code (.java file) and your results output into a .ZIP file with the following format:
firstname-lastname-abstractclass-date
EXAMPLE: mary-smith-abstractclass-08272019
3. Then, upload (submit) the file to the corresponding assignment link.

## Java Abstract Class Assignment
In this lab we will be implementing part of a game engine for a Mario Kart simulator. Players can choose one of three characters 
to play: Mario, Princess Peach, and Bowser. Each of these character types can attack and deal damage to other characters, and each of the
characters have specific rules around these actions. Your job will be to implement these character types. 

## General Game Rules
Each character can attack, deal damage, and take damage. 

### Coins
Each character has a number of coins in the game. Coins are calculated when the character
is created based on their character type and bonus modifier.

### Attacking
* An attack's success is determined by a roll (a random number between 1 and 20) plus a potential attack bonus. If the roll plus the attack bonus
is higher than (20 - the calculated armor class (see below)) then the attack is successful. Successful attacks cause the target to take lose coins.
* A roll of 20 (the highest possible roll value) indicates an automatic successful hit for the attacker, causing the target to lose coins.
* A roll of 1 (the lowest possible roll value) indicates an automatic miss for the attacker, which causes no loss of coins.

### Causing loss of coins
* When a successful attack has been made then the attacking character can cause their opponent to lose coins. The amount of coins lost
is subtracted from the the opponents total coins. 

### Losing Coins
* Coin loss subtracts from a characters total coins.

(You don't have to implement this rule as it has already been implemented in the base class).

### Dodge Score
Each character has a dodge score, which represents how hard it is to hit them. The dodge score starts at 10 and goes down based on the
character.



### Mario
#### Coins
* Mario receives 10 hit points per level upon character creation.

#### Attacking
* Mario get a +1 attack bonus per bonus modifier. So if Mario has a bonus modifier of 3 they get +3 to the their
attack roll.

#### Causing Coin Loss
* Mario deals 2 points of coin loss per attack per bonus modifier.

#### Dodge Score
* Mario's Dodge Score decreases by 1 point per bonus modifier.



### Princess Peach
#### Coins
* Princess Peach receives 6 coins per bonus modifier upon character creation.

#### Attacking
* Princess Peach get a +1 bonus for every 2 bonus modifiers. So Princess Peach with 4 bonus modifier points gets +2 to their attack roll.

#### Causing Coin Loss
* Princess Peach deals 1 point of coin loss per attack per bonus modifier.

#### Dodge Score
* Princess Peach's Dodge Score decreases by 1 point per 2 bonus modifiers.



### Bowser
#### Coins
* Bowser receives 4 hit points per bonus modifier upon character creation.

#### Attacking
* Bowser cheats, and automatically hits his target, causing the target to lose coins.

#### Causing Coin Loss
* Bowser deal 2 points of coin loss per attack per bonus modifier. If the target is another Bowser then divide the coin loss by 2 (Hint: use the `.equals()` or `.getClass()` methods
to determine if the target is a Bowser or not).

#### Dodge Score
* Bowser's Dodge Score decreases by 1 point per four bonus modifier.

##Tasks

* Implement three classes which extend from `Driver`:
    * Mario
    * Bowser
    * Princess Peach
    
The class names **must** match exactly, and **must** be in the `edu.cscc.drivers` package.
* Override the `.calculateCoins()` method for each subclass from the base abstract class.
* Override the `.calculateTotalAttackRoll()` method for each subclass from the base abstract class.
* Override the `.coinLoss()` method for each subclass from the base abstract class.
* Override the `.calculateDodgeScore()` method for each subclass.

## Testing
A suite of tests have been provided for each class to be implemented. Initially all of these tests will fail. As you implement each class
the tests will begin to pass (Assuming you have named your classes correctly and they are in the correct package.). Once all of the tests
are passing you have completed the assignment. You are free to add additional tests as you see fit.

## Additional Notes
* You may need to override one or two additional methods on the Driver class when implementing the Bowser rules. Consider the rules
about automatically hitting their targets and only doing half damage to other Bowsers. Read the `Driver` class to get an idea of which 
methods to override in Bowser.