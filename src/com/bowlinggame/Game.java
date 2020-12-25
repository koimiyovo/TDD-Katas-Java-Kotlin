package com.bowlinggame;

public class Game {
    private final int[] rolls = new int[21];
    private int currentRoll = 0;
    private final int FRAME_MAX_SCORE = 10;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(frameIndex)) {
                score += FRAME_MAX_SCORE + strikeBonus(frameIndex);
                frameIndex++;
            }
            else if (isSpare(frameIndex)) {
                score += FRAME_MAX_SCORE + spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                score += sumOfPinsInFrame(frameIndex);
                frameIndex += 2;
            }
        }
        return score;
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == FRAME_MAX_SCORE;
    }

    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    private int spareBonus(int frameIndex) {
        return rolls[frameIndex+2];
    }

    private int sumOfPinsInFrame(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex+1];
    }

    private boolean isSpare(int frameIndex) {
        return sumOfPinsInFrame(frameIndex) == FRAME_MAX_SCORE;
    }
}
