/**
 * @author James Burriss, Daniel Valencia, Thomas Miller, Taylor Anna
 * @date 03/07/2023
 * @section CSC 331-001
 * @purpose Thief class. Will inherit from Characters.
 */

package com.example.demo2;

public class Thief extends Characters {

    private int health;

    /**
     * Creates the Thief and stats.
     */
    Thief(int str, int dex, int con, int inte, int wis, int cha) {

        super(str, dex, con, inte, wis, cha);

        this.health = Health();
    }

    // Getters / Setters / Methods

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int Attack() {
        return dFour.roll() + getDex();
    }

    public int Health() {
        return dEight.roll() + dEight.roll() + getCon();
    }

    public int Sneak() {
        return dTwenty.roll() + this.getDex();
    }
}
