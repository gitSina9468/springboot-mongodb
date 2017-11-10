package com.zzm.demo.utils;

/**
 * Created by ${sq} on 2017/10/16.
 */
public enum Enum {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);
    private int i;

    Enum(int i) {
        this.i = i;
    }

    public int getI(){
        return this.i;
    }

    public static void main(String[] args) {
        System.out.println(Enum.MONDAY.getI());
    }
}
