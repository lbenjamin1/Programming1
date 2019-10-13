package edu.cscc.drivers;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertEquals;

public class MarioTest extends TestHelpers {

    private static final String PLAYER_NAME = "Jonathan";
    private static final String MARIO_CLASSNAME = "edu.cscc.drivers.Mario";

    @Test
    public void marioWith1BonusModifierHas10Coins() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object mario = createObjectForClass(PLAYER_NAME, 1, MARIO_CLASSNAME);

        assertEquals(10, callGetCoins(mario));
    }

    @Test
    public void marioHas10CoinsPerBonusModifier() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object mario = createObjectForClass(PLAYER_NAME, 5, MARIO_CLASSNAME);

        assertEquals(50, callGetCoins(mario));
    }

    @Test
    public void marioWith1BonusModifierGetsPlus1BonusToAttack() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object mario = createObjectForClass(PLAYER_NAME, 1, MARIO_CLASSNAME);

        assertEquals(10, callCalculateTotalAttackRoll(mario, 9));
    }

    @Test
    public void marioGetsPlus1BonusToAttackPerBonusModifier() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object mario = createObjectForClass(PLAYER_NAME, 5, MARIO_CLASSNAME);

        assertEquals(10, callCalculateTotalAttackRoll(mario, 5));
    }

    @Test
    public void marioWith1BonusModifierDeals2PointsOfCoinLossPerAttack() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object mario = createObjectForClass(PLAYER_NAME, 1, MARIO_CLASSNAME);

        assertEquals(2, callCoinLoss(mario));
    }

    @Test
    public void marioDeals2PointsOfCoinLossPerBonusModifier() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object mario = createObjectForClass(PLAYER_NAME, 5, MARIO_CLASSNAME);

        assertEquals(10, callCoinLoss(mario));
    }

    @Test
    public void marioWith1BonusModifierHasADodgeScoreOf9() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object mario = createObjectForClass(PLAYER_NAME, 1, MARIO_CLASSNAME);

        assertEquals(9, callCalculateDodgeScore(mario));
    }

    @Test
    public void mariosDodgeScoreGoesDown1PointPerBonusModifier() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object mario = createObjectForClass(PLAYER_NAME, 5, MARIO_CLASSNAME);

        assertEquals(5, callCalculateDodgeScore(mario));
    }
}
