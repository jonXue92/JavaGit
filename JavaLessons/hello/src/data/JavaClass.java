package data;

import java.util.*;
import java.lang.*;
import java.io.*;
class Ideone {
public static void main(String[] args) throws java.lang.Exception {
        System.out.println("Expected # = 0 1 2 2 1");
        Cat c = new Cat();
        c.setClaws(0);
        System.out.println("Initial value is " + c.getClaws());
        // prints 0 obviously
        clawsAreOne(c);
        System.out.println("Accessor changes value to " + c.getClaws());
        // prints 1 because the value 'referenced' by the 'pointer' is changed using an accessor.
        makeNewCat(c);
        System.out.println("Final value is " + c.getClaws());
        // prints 1 because the pointer is not changed to 'kitten'; that would be a reference pass.
    }
public static void clawsAreOne(Cat kitty) {
        kitty.setClaws(1);
    }
public static void makeNewCat(Cat kitty) {
        Cat kitten = new Cat();
        kitten.setClaws(2);
        kitty = kitten;
        System.out.println("Value in makeNewCat scope of kitten " + kitten.getClaws());
        //Prints 2. the value pointed to by 'kitten' is 2
        System.out.println("Value in makeNewcat scope of kitty " + kitty.getClaws());
        //Prints 2. The local copy is being used within the scope of this method.
    }
}
class Cat {
private int claws;
public void setClaws(int i) {
        claws = i;
    }
public int getClaws() {
        return claws;
    }
}