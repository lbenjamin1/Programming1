package edu.cscc.drivers;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertEquals;

public class PrincessPeachTest extends TestHelpers {

    private static final String PLAYER_NAME = "Robin";
    private static final String PRINCESS_PEACH_CLASSNAME = "edu.cscc.drivers.PrincessPeach";

    @Test
    public void princessPeachWith1BonusModifierHas6Coins() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object princessPeach = createObjectForClass(PLAYER_NAME, 1, PRINCESS_PEACH_CLASSNAME);

        assertEquals(6, callGetCoins(princessPeach));
    }

    @Test
    public void princessPeachHas6CoinsPerBonusModifier() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object princessPeach = createObjectForClass(PLAYER_NAME, 5, PRINCESS_PEACH_CLASSNAME);

        assertEquals(30, callGetCoins(princessPeach));
    }

    @Test
    public void princessPeachWith1BonusModifierGetsNoBonusToAttack() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        Object princessPeach = createObjectForClass(PLAYER_NAME, 1, PRINCESS_PEACH_CLASSNAME);

        assertEquals(9, callCalculateTotalAttackRoll(princessPeach, 9));
    }

    @Test
    public void princessPeachGetsPlus1BonusToAttackPerTwoPointsOfBonusModifier() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object princessPeach = createObjectForClass(PLAYER_NAME, 4, PRINCESS_PEACH_CLASSNAME);

        assertEquals(7, callCalculateTotalAttackRoll(princessPeach, 5));
    }

    @Test
    public void princessPeachWithBonusModifierOf1Causes1CoinLossPerAttack() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object princessPeach = createObjectForClass(PLAYER_NAME, 1, PRINCESS_PEACH_CLASSNAME);

        assertEquals(1, callCoinLoss(princessPeach));
    }

    @Test
    public void princessPeachDeals2CoinLossPerLevel() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object princessPeach = createObjectForClass(PLAYER_NAME, 5, PRINCESS_PEACH_CLASSNAME);

        assertEquals(5, callCoinLoss(princessPeach));
    }

    @Test
    public void princessPeachWithBonusModifierOf1HasADodgeScoreOf10() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object princessPeach = createObjectForClass(PLAYER_NAME, 1, PRINCESS_PEACH_CLASSNAME);

        assertEquals(10, callCalculateDodgeScore(princessPeach));
    }

    @Test
    public void princessPeachsDodgeScoreGoesDown1PointPer2PointsOfBonusModifier() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object princessPeach = createObjectForClass(PLAYER_NAME, 5, PRINCESS_PEACH_CLASSNAME);

        assertEquals(8, callCalculateDodgeScore(princessPeach));
    }
}