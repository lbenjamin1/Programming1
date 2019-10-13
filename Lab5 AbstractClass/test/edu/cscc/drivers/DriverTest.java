package edu.cscc.drivers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DriverTest {

    private TestDriver testDriver;
    private TestDriver opponent;

    @Before
    public void setUp() {
        testDriver = new TestDriver("Rolo", 1);
        opponent = new TestDriver("Martin", 1);
    }

    @Test
    public void charactersCanLoseCoins() {
        testDriver.loseCoins(opponent);

        assertEquals(9, testDriver.getCoins());
    }

    @Test
    public void whenAnAttackIsSuccessfulThenTheOpponentLosesCoins() {
        testDriver.attack(opponent, 15);

        assertEquals(9, opponent.getCoins());
    }

    @Test
    public void whenAnAttackFailsThenTheOpponentDoesNotLoseCoins() {
        testDriver.attack(opponent, 1);

        assertEquals(10, opponent.getCoins());
    }

    @Test
    public void aRollOf1AlwaysFails() {
        opponent.setDodgeScore(25);

        testDriver.attack(opponent, 1);

        assertEquals(10, opponent.getCoins());
    }

    @Test
    public void whenARollOf20OccursTheAttackAutomaticallyHits() {
        opponent.setDodgeScore(-20);
        testDriver.attack(opponent, 20);

        assertEquals(9, opponent.getCoins());
    }

    class TestDriver extends Driver {

        private int dodgeScore = 10;

        public TestDriver(String name, int level) {
            super(name, level);
        }

        @Override
        protected void calculateCoins() {
            this.coins = 10;
        }

        @Override
        public int calculateTotalAttackRoll(int roll) {
            return roll;
        }

        @Override
        public int coinLoss() {
            return 1;
        }

        @Override
        public int calculateDodgeScore() {
            return dodgeScore;
        }

        public void setDodgeScore(int dodgeScore) {
            this.dodgeScore = dodgeScore;
        }
    }
}