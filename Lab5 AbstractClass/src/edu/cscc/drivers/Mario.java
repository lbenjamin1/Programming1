package edu.cscc.drivers;

public class Mario extends Driver {
    public Mario(String playerName, int bonusModifier) {
        super(playerName, bonusModifier);
    }

    @Override
    protected void calculateCoins() {
        coins = bonusModifier * 10;
    }

    @Override
    public int calculateTotalAttackRoll(int roll) {
        return roll + bonusModifier;
    }

    @Override
    public int coinLoss() {
        return bonusModifier * 2;
    }

    @Override
    public int calculateDodgeScore() {
        return 10 - bonusModifier;
    }
}