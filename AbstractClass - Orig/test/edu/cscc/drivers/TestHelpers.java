package edu.cscc.drivers;

import java.lang.reflect.InvocationTargetException;

public class TestHelpers {

    protected Object callGetCoins(Object object) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return object.getClass().getMethod("getCoins").invoke(object);
    }

    protected Object callCoinLoss(Object object) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return object.getClass().getMethod("coinLoss").invoke(object);
    }

    protected Object callCalculateDodgeScore(Object object) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return object.getClass().getMethod("calculateDodgeScore").invoke(object);
    }

    protected Object callCalculateTotalAttackRoll(Object object, int roll) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return object.getClass().getMethod("calculateTotalAttackRoll", int.class).invoke(object, roll);
    }

    protected boolean callAttackIsSuccessful(Object object, Object opponent, int roll) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return (boolean) object.getClass().getMethod("attackIsSuccessful", Driver.class, int.class).invoke(object, opponent, roll);
    }

    protected Object createObjectForClass(String name, int bonusModifier, String className) throws ClassNotFoundException, NoSuchMethodException {
        Class klass = Class.forName(className);
        try {
            return klass.getConstructor(String.class, int.class).newInstance(name, bonusModifier);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
