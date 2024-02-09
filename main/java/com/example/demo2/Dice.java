/**
 * @author James Burriss, Daniel Valencia, Thomas Miller, Taylor Anna
 * @date 03/07/2023
 * @section CSC 331-001
 * @purpose Dice class.
 */

package com.example.demo2;

public class Dice {

    private int numSides;
    private int[] sideValues;

    /**
     * Creates Die.
     * @param numSides
     * @param sideValues
     */
    Dice(int numSides, int[] sideValues) {
        this.numSides = numSides;
        this.sideValues = sideValues;
    }

    /**
     * Rolls the dice.
     * @return
     */
    public int roll() {
        int randRoll = (int)(Math.random()*sideValues.length);
        System.out.printf("d%d: %d\n", numSides, sideValues[randRoll]);
        return sideValues[randRoll];
    }
}
