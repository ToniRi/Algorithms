package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int size =0 ;
        int depth = 0 ;

        if(args.length >0){
            size = Integer.parseInt(args[0]);
            depth = Integer.parseInt(args[1]);
        }
        else{
            size = 6; // Vaihda taulukon pituutta
            depth = 10;
        }
        
        int[] mountain = createMountain(size,depth);

        int [] array = new int[mountain.length];

        //Luodaan kopio alkuperäisestä taulukosta
        for (int i = 0; i< mountain.length;i++
             ) {
            array[i] = mountain[i];
        }
        // Katsotaan tuloksia
        System.out.println("Alkuperäinen oli");
        System.out.print("[");
        for (int i : mountain)
            System.out.print(i + " ");
        System.out.print(']');

       int result  = countPoolSizes(array);

        System.out.println("tulos: " + result);
    }

    private static int countPoolSizes(int [] array) {

        int left = 0;
        int index = 0;
        int result = 0;

        checkRightBound(left, array, index);

        for(int i :array)
            result += i;

        return result;
    }
    /*
    Aloittaa rekursion ja laskee altaiden vetoisuuden
     */

    static int checkRightBound(int leftPassed, int[] mount, int index){

        int nodeLeft = leftPassed;
        int nodeRight = 0;
        int node = mount[index];

        //Taulukon viimeinen alkio on oikea raja aluksi, itse saa arvon 0
        if(index == mount.length-1) {
            mount[index] = 0;
            return node;
        }
        //jos vasen raja on pienempi kuin nykyinen solmu annetaan nykyinen solmu seuraavalle rajaksi
        // Muutoin annetaan tullut vasen raja seuraavalle eteenpäin

        if(leftPassed <= node)
           nodeRight =  checkRightBound(node, mount, index + 1);
        else
           nodeRight = checkRightBound(leftPassed,mount,index+1);


        if(nodeLeft > node && nodeRight > node) {
            mount[index] = Math.min(nodeLeft,nodeRight) - node;
        }
        else mount[index] = 0;

        // Jos oikea raja rekursiosta pienempi tai yhtä suuri,
        // annetaan eteenpäin oikeaksi rajaksi solmun arvo,
        //koska allasta ei voi muodostua tälle solmulle

        if(nodeRight <= node) {
            return node;
        }else
        return nodeRight;

        // Lasketaan solmun indeksiin allas

    }


    // Luo "vuoren"
    static int[] createMountain(int size, int maxDepth){
        int [] mount = new int[size];
        Random r = new Random();

        for(int i = 0 ; i <mount.length; i++)
            mount[i] = r.nextInt(maxDepth);

        return mount;

    }
}
