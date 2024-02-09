/**
 * @author James Burriss, Daniel Valencia, Thomas Miller, Taylor Anna
 * @date 03/07/2023
 * @section CSC 331-001
 * @purpose Fighter class. Will inherit from Characters.
 */

package com.example.demo2;

public class Fighter extends Characters {

    private int health;

    /**
     * Creates the Fighter and stats.
     * @param str
     * @param dex
     * @param con
     * @param inte
     * @param wis
     * @param cha
     */
    Fighter(int str, int dex, int con, int inte, int wis, int cha) {
        super(str, dex, con, inte, wis, cha);

        this.health = Health();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int Attack() {

        return dSix.roll() + getStr();
    }

    public int Health() {
        return dTwelve.roll() + dTwelve.roll() + this.getCon();
    }

    public int Sneak() {
        return dTwenty.roll() + this.getDex();
    }
}
