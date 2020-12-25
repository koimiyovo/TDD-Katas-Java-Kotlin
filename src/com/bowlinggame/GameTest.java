package com.bowlinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game g;

    @BeforeEach
    void setup() {
        g = new Game();
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            g.roll(pins);
        }
    }

    @Test
    void givenGutterShouldReturn0() {
        rollMany(20, 0);
        assertEquals(0, g.score());
    }

    @Test
    void givenAllOnesShouldReturn20() {
        rollMany(20, 1);
        assertEquals(20, g.score());
    }

    @Test
    void givenOneSpareWith3PinsInTheNextRollShouldReturn16() {
        rollSpare();
        g.roll(3);
        rollMany(17, 0);
        assertEquals(16, g.score());
    }

    @Test
    void givenOneStrikeWith3And4PinsInTheNextFrameShouldReturn24() {
        rollStrike();
        g.roll(3);
        g.roll(4);
        rollMany(16, 0);
        assertEquals(24, g.score());
    }

    @Test
    void givenAPerfectGameShouldReturn300() {
        rollMany(12, 10);
        assertEquals(300, g.score());
    }

    private void rollSpare(){
        g.roll(5);
        g.roll(5);
    }

    private void rollStrike() {
        g.roll(10);
    }
}