package com.company;

import java.util.Random;

public class MountainArray {

    /*
     * (Task Found from Google interview questions)
     *
     * Algorithm counts how much "water" the pools in the mountain could hold.
     * Mountain : array of integers
     * Pools : sum of integers in indices
     *
     * For example mountain of [2,0,2] would hold water for 2 units
     * Or
     * mountain of [1, 4, 2, 5] would hold 2 units because 4> 1 so there would be no pool and
     * 4 < 5 which would cause the pool of 4, 2, 5 be the max of 2
     * */

    public static void main(String[] args) {
        int size ;
        int depth ;

        if (args.length > 0) {
            size = Integer.parseInt(args[0]);
            depth = Integer.parseInt(args[1]);
        } else {
            size = 6; // Define array six
            depth = 10; // define max depth e.g array values
        }

        int[] mountain = createMountain(size, depth);
        int[] array = mountain.clone(); // new int[mountain.length];

        // Results
        System.out.println("Original array");
        System.out.print("[");
        for (int i : mountain)
            System.out.print(i + " ");
        System.out.print(']');

        int result = countPoolSizes(array);
        System.out.println("Result: " + result);
    }

    //Array takes the capacity of each index
    private static int countPoolSizes(int[] array) {
        int left = 0;
        int index = 0;
        int result = 0;

        //Start recursion - in the first index the right boundary doesn't matter
        checkRightBound(left, array, index);

        // count the capacities and return the result
        for (int i : array)
            result += i;
        return result;
    }

    static int checkRightBound(int heightLeft, int[] mount, int index) {
        //initialize heights. Left is passed, right is 0

        int heightRight  ;
        int heightCurrent = mount[index];
        // the last index gets max capacity of default 0, because it cannot generate a pool,
        // but it returns its height as boundary
        if (index == mount.length - 1) {
            mount[index] = 0;
            return heightCurrent;
        }
        heightRight = checkRightBound(Math.max(heightLeft, heightCurrent), mount, index + 1);
        //with right and left boundaries, count the current index capacity
        int min = Math.min(heightLeft,heightRight);
        if(min > heightCurrent)
            mount[index] = min - heightCurrent;
        else mount[index] = 0;

        //return boundary
        return Math.max(heightCurrent, heightRight);
    }

    // Creates a mountain
    static int[] createMountain(int size, int maxDepth) {
        int[] mount = new int[size];
        Random r = new Random();
        for (int i = 0; i < mount.length; i++)
            mount[i] = r.nextInt(maxDepth);
        return mount;
    }
}

