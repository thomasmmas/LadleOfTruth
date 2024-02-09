/**
 * @author James Burriss, Daniel Valencia, Thomas Miller, Taylor Anna
 * @date 03/07/2023
 * @section CSC 331-001
 * @purpose Ghost class. Will inherit from Characters.
 */

package com.example.demo2;

public class Ghost extends Characters { // Ghost inherits Characters

    private int health;

    // Constructor

    /**
     * Setting instance variables and inheriting class.
     * @param str
     * @param dex
     * @param con
     * @param inte
     * @param wis
     * @param cha
     */
    Ghost(int str, int dex, int con, int inte, int wis, int cha) {

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

    /**
     * Ghost attacks
     * @return
     */
    public int Attack() {
        return dSix.roll() + getInte();
    }

    /**
     * Ghost's Health
     * @return
     */
    public int Health() {
        return dEight.roll() + dEight.roll() + dEight.roll() + this.getCon();
    }
}
