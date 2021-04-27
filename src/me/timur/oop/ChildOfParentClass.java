package me.timur.oop;

/**
 * Created by Timur on 27.04.2021
 */

public class ChildOfParentClass extends MyParentClass {

    /**
     * child has no access to private fields and methods of its parent
     */

    public ChildOfParentClass(){
        this.protectedInt = 0;
        this.publicInt = 0;
        this.protectedMethod();
        this.publicMethod();
    }
}
