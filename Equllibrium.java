package com.company;

import java.util.Random;

public class Equllibrium {

    /*
     * Finds the index of an element from an array where sum of each element in the
     * lef side of the array equals the sum of right side elements
     * */

    public static void main(String[] args) {
        int[] array;
        int found;
        // comment out if fixed array is wanted
        //  array = { 8, 2, 1,6,1};

        // uncomment if don't want random
        if (args.length != 2)
            array = createArray(5, 10);
        else
            array = createArray(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

        found = recursiveEqulib(array);

        //Print results
        System.out.println("Is equillibbrium = " + (found != -1) +
                ", index is : " + found);
        System.out.println("Original array : ");
        System.out.print("[");
        for (int i : array) {
            System.out.print(i + ",");
        }
        System.out.print("]");
    }
        //start recursion
    static int recursiveEqulib(int[] array) {
        int[] found = {-1};
        recursiveEquilibrium(array, 0, 0, found);
        return found[0];
    }


    static int recursiveEquilibrium(int[] array, int index, int sum, int[] found) {

        int currentElement = array[index];
        if (index == array.length - 1)
            return array[index];

        int sumRight = recursiveEquilibrium(array, index + 1, sum + currentElement, found);

        if (sumRight == sum) {
            found[0] = index;
        }
        return sumRight + currentElement;
    }

    static int[] createArray(int size, int maxNumber) {
        int[] mount = new int[size];
        Random r = new Random();

        for (int i = 0; i < mount.length; i++)
            mount[i] = r.nextInt(maxNumber);
        return mount;

    }
}

//Test cases for example
// int [] eqibArr = [1, 2, 3, 2,1 ]
//int [] eqibArr = { 8, 2, 1,6,1}