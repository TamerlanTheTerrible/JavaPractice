package me.timur.oop;

/**
 * Created by Timur on 27.04.2021
 */

public abstract class MyAbstractParentClass {

    /**
     * 1) Fields cannot be abstract
     * 2) private method cannot be abstract
     */

    public int publicInt;
    private int privateInt;
    protected int protectedInt;

    public abstract void publicAbstractMethod();
    protected abstract void protectedAbstractMethod();

}
