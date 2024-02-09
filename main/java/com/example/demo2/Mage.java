/**
 * @author James Burriss, Daniel Valencia, Thomas Miller, Taylor Anna
 * @date 03/07/2023
 * @section CSC 331-001
 * @purpose Mage class. Will inherit from Characters.
 */

package com.example.demo2;

/**
 * Creates the Mage and stats.
 */
public class Mage extends Characters {

    Mage(int str, int dex, int con, int inte, int wis, int cha) {

        super(str, dex, con, inte, wis, cha);
    }

    // Methods

    public int Attack() {
        return dTen.roll() + getInte();
    }

    public int Health() {
        return dSix.roll() + getCon();
    }
}
