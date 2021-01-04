package com.company;

import java.util.Random;

public class Equllibrium {

    /*
    * Finds the index of an element from an array where sum of each element in the
    * lef side of the array equals the sum of right side elements
    * */

    public static void main(String[] args) {

        boolean[] equib = new boolean[1];
        //int [] array = { 8, 2, 1,6,1}; // comment out if random
        // for random uncomment
        int [] array = createArray(5,10);

        recursiveEqulib(array,0,0,equib);
        System.out.println("Is equillibbrium= "+equib[0]);

        System.out.println("Testattava taulukko : ");
        System.out.print("{");
        for (int i : array){
            System.out.print(i+ ",");
        }
        System.out.print("]");

    }

    static int recursiveEqulib(int[] array,int index,int sum,boolean[] equib){

        int currentElement =array[index];
            if(index == array.length-1)
                return array[index];

        int sumRight = recursiveEqulib(array,index+1,sum+currentElement,equib);

        if(sumRight == sum) {
            System.out.println("Found Equilibrium index: " + index + " left: " + sum +
                    " right " + sumRight);
            equib[0] = true;
        }

        return sumRight+currentElement;
    }

    static int[] createArray(int size, int maxNumber){
        int [] mount = new int[size];
        Random r = new Random();

        for(int i = 0 ; i <mount.length; i++)
            mount[i] = r.nextInt(maxNumber);

        return mount;

    }
}
// [1, 2, 3, 2,1 ]
// int [] eqibArr = [1, 2, 3, 2,1 ]
//int [] eqibArr = { 8, 2, 1,6,1}