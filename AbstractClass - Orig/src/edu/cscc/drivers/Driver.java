package edu.cscc.drivers;

import static edu.cscc.combat.Combat.*;

/**
 * This is the base class that all driver classes extend from.
 */
public abstract class Driver {

    private String playerName;
    protected int bonusModifier;
    protected int coins;

    /**
     * Constructor a new Driver.
     *
     * @param playerName
     * @param bonusModifier
     */
    public Driver(String playerName, int bonusModifier) {
        this.playerName = playerName;
        this.bonusModifier = bonusModifier;
        calculateCoins();
    }

    public int getCoins() {
        return coins;
    }

    public String getPlayerName() {
        return playerName;
    }

    /**
     * Applies damage received from the opponent's coinLoss() method.
     * May be overridden when necessary.
     * @param opponent The opponent Driver.
     */
    void loseCoins(Driver opponent) {
        int coinsLost = opponent.coinLoss();
        System.out.println(playerName + " lost " + coinsLost + " coins from " + opponent.getPlayerName());
        this.coins -= coinsLost;
    }

    /**
     * Method to be called during racing combat. It orchestrates the attack and damage process between
     * a character and their opponent. Do not modify this method.
     * @param opponent The target character to be attacked. This character will lose coins on a successful attack.
     * @param roll The attack roll before modifiers have been applied.
     */
    public void attack(Driver opponent, int roll) {
        System.out.println(playerName + " is now attacking " + opponent + "!");
        if (roll == AUTOMATIC_FAILURE) {
            System.out.println(playerName + " fumbled and missed!");
            return;
        }

        if (roll == AUTOMATIC_SUCCESS || attackIsSuccessful(opponent, roll)) {
            System.out.println(playerName + " scored a hit!");
            opponent.loseCoins(this);
        }
    }

    /**
     * This method determines if an attack was successful based on the total attack roll and
     * dodge score of the opponent. May be overridden when necessary.
     * @param opponent
     * @param roll The attack roll before modifiers have been applied.
     * @return true if the attack is successful, false otherwise.
     */
    protected boolean attackIsSuccessful(Driver opponent, int roll) {
        return calculateTotalAttackRoll(roll) >= (MAX_ATTACK_ROLL - opponent.calculateDodgeScore());
    }

    /**
     * TODO Override this method in the PrincessPeach, Mario, and Bowser classes which will extend this class.
     * This method should set the coins property based on the driver and bonus modifier of the driver.
     */
    protected abstract void calculateCoins();

    /**
     * TODO Override this method in the PrincessPeach, Mario, and Bowser classes which will extend this class.
     * @param roll A random number between 1 and 20.
     * @return The total attack roll, which is the combination of roll and any modifiers that may be applied.
     */
    public abstract int calculateTotalAttackRoll(int roll);

    /**
     * TODO Override this method in the PrincessPeach, Mario, and Bowser classes which will extend this class.
     * @return The amount of coin loss that the driver deals based on their class and any modifiers.
     */
    public abstract int coinLoss();

    /**
     * TODO Override this method in the PrincessPeach, Mario, and Bowser classes which will extend this class.
     * @return The calculated Dodge Score for a driver. The base dodge score starts at edu.cscc.drivers.Combat.BASE_DODGE_SCORE
     * and goes down from there based on the class and level of a driver.
     */
    public abstract int calculateDodgeScore();
}
