package me.timur.oop;

/**
 * Created by Timur on 27.04.2021
 */

public class ChildOfAbstractParentClass extends MyAbstractParentClass {
    /**
     * child has no access to private fields of its parent
     */
    public ChildOfAbstractParentClass(){
        this.protectedInt = 0;
        this.publicInt = 0;
        this.protectedAbstractMethod();
        this.publicAbstractMethod();
    }

    @Override
    public void publicAbstractMethod() {}

    @Override
    protected void protectedAbstractMethod() {}
}
