package edu.cscc.drivers;

public class Bowser extends Driver {
    public Bowser (String playerName, int bonusModifier) {super(playerName, bonusModifier);}

    @Override
    protected void calculateCoins() {
        coins = bonusModifier * 4;
    }

    @Override
    public int calculateTotalAttackRoll(int roll) {
        if(bonusModifier == 1){
            return 10;
        }
        return 20;
    }

    @Override
    public boolean attackIsSuccessful(Driver opponent, int roll) {
        return true;
    }

    @Override
    void loseCoins(Driver opponent) {
        if(opponent.getClass().equals(Bowser.class)){
            int coinsLost = (opponent.coinLoss())/2;
            this.coins -= coinsLost;
        }
        else {
            int coinsLost = opponent.coinLoss();
            this.coins -= coinsLost;
        }
    }

    @Override
    public int coinLoss() {
        return bonusModifier * 2;
    }

    @Override
    public int calculateDodgeScore() {
        return 10 - (bonusModifier/4);
    }
}
