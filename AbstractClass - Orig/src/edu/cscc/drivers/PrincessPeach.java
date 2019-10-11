package edu.cscc.drivers;

public class PrincessPeach extends Driver{
    public PrincessPeach (String playerName, int bonusModifier) {super(playerName, bonusModifier);}

    @Override
    protected void calculateCoins() {
        coins = bonusModifier * 6;
    }

    @Override
    public int calculateTotalAttackRoll(int roll) {
        return 0;
    }

    @Override
    public int coinLoss() {
        return 0;
    }

    @Override
    public int calculateDodgeScore() {
        return 0;
    }
}
