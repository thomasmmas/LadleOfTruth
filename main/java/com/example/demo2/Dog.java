/**
 * @author James Burriss, Daniel Valencia, Thomas Miller, Taylor Anna
 * @date 03/07/2023
 * @section CSC 331-001
 * @purpose Dog class. Will inherit from Characters.
 */

package com.example.demo2;

public class Dog extends Characters { // Dog inherits class

    // Constructor
    private int health;

    /**
     * Setting instance variables and inheriting class.
     * @param str
     * @param dex
     * @param con
     * @param inte
     * @param wis
     * @param cha
     */
    Dog(int str, int dex, int con, int inte, int wis, int cha) {

        super(str, dex, con, inte, wis, cha);

        this.health = Health();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Dog attacks
     * @return
     */
    public int Attack() {
        return dFour.roll() + getStr();
    }

    /**
     * Dog's Health
     * @return
     */
    public int Health() {
        return dFour.roll() + dFour.roll() + dFour.roll() + dFour.roll() + this.getCon();
    }
}

