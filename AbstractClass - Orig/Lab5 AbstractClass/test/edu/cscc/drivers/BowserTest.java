package edu.cscc.drivers;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BowserTest extends TestHelpers {
    private static final String PLAYER_NAME = "Stella";
    private static final String BOWSER_CLASSNAME = "edu.cscc.drivers.Bowser";

    @Test
    public void bowserWith1BonusPointHas4HitPoints() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object bowser = createObjectForClass(PLAYER_NAME, 1, BOWSER_CLASSNAME);

        assertEquals(4, callGetCoins(bowser));
    }

    @Test
    public void bowserHas4HitPointsPerBonusModifier() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object bowser = createObjectForClass(PLAYER_NAME, 5, BOWSER_CLASSNAME);

        assertEquals(20, callGetCoins(bowser));
    }

    @Test
    public void bowserWith1BonusModifierGetsNoBonusToAttack() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object bowser = createObjectForClass(PLAYER_NAME, 1, BOWSER_CLASSNAME);

        assertEquals(10, callCalculateTotalAttackRoll(bowser, 10));
    }

    @Test
    public void bowserWith1BonsusPointDeals2PointsOfCoinLossPerAttack() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object bowser = createObjectForClass(PLAYER_NAME, 1, BOWSER_CLASSNAME);

        assertEquals(2, callCoinLoss(bowser));
    }

    @Test
    public void bowserDeals2PointsOfCoinLossPerBonusModifier() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object bowser = createObjectForClass(PLAYER_NAME, 5, BOWSER_CLASSNAME);

        assertEquals(10, callCoinLoss(bowser));
    }

    @Test
    public void bowserWith1BonusModifierStartsWithADodgeScoreOf10() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object bowser = createObjectForClass(PLAYER_NAME, 1, BOWSER_CLASSNAME);

        assertEquals(10, callCalculateDodgeScore(bowser));
    }

    @Test
    public void BowsersDodgeScoreGoesDown1PointPerFourBonusModifiers() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object bowser = createObjectForClass(PLAYER_NAME, 8, BOWSER_CLASSNAME);

        assertEquals(8, callCalculateDodgeScore(bowser));
    }

    @Test
    public void bowserAttacksAreAlwaysSuccessful() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object bowser = createObjectForClass(PLAYER_NAME, 1, BOWSER_CLASSNAME);

        Object opponent = createObjectForClass("Jill", 2, BOWSER_CLASSNAME);
        assertTrue(callAttackIsSuccessful(bowser, opponent, 2));
    }

    @Test
    public void coinLossTakenFromAnotherBowserIsHalved() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object bowser = createObjectForClass(PLAYER_NAME, 4, BOWSER_CLASSNAME);
        Object opponent = createObjectForClass("Jill", 4, BOWSER_CLASSNAME);

        int roll = 20;
        Driver driver = (Driver) opponent;
        driver.attack((Driver)bowser, roll);

        assertEquals(12, callGetCoins(bowser));
    }
}