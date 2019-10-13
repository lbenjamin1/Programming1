package edu.cscc;

import org.junit.Test;

import static org.junit.Assert.*;

public class CircleTest {
    @Test

    public void givenRadiusItCalculatesArea() {
        Circle circle = new Circle(3);

        assertEquals(28.274333882308138, circle.calculateArea(), 0.01);
    }
}