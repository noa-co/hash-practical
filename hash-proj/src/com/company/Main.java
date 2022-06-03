package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;


public class Main {



    public static void main(String[] args) {
        //QUESTION3 PART 1
        int q = 6571;
        HashSet q1 = new HashSet<>();
        HashSet q2 = new HashSet<>();
        for (int i = 0; i < q; i++){
            q1.add((i*i) % q);
            int sign = (int) Math.pow(-1,(i));
            q2.add((sign * (i*i)) % q);
        }
//        System.out.println("size of group Q1: " + q1.size());
//        System.out.println("size of group Q2: " + q2.size());



//        long p = 17;
//        int m = 11;
//        Random random = new Random();
//        IHashTable doubleHash = new DoubleHashTable(m, p);
//        for (int i = 0; i < 11; i ++){
//            int bi = random.nextInt(100);
//            long ai = (100 * i) + bi;
//            HashTableElement hte = new HashTableElement(ai,ai);
//            try {
//                doubleHash.Insert(hte);
//            } catch (IHashTable.TableIsFullException e) {
//                System.out.println("table is full");
//            } catch (IHashTable.KeyAlreadyExistsException e) {
//                System.out.println("key already exists");
//            }
//        }


        ///QUESTION 4

        int m = 10000019;
        long p = 1000000007;
        int n = (19 * m)/20;
        Random random = new Random();
//        IHashTable aqpHash = new AQPHashTable(m, p);
//        IHashTable qpHash = new QPHashTable(m, p);
        IHashTable doubleHash = new DoubleHashTable(m, p);
//        IHashTable lphHash = new LPHashTable(m,p);
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            int bi = random.nextInt(100);
            long ai = (100 * i) + bi;
            HashTableElement hte = new HashTableElement(ai,ai);
            try {
                doubleHash.Insert(hte);
            } catch (IHashTable.TableIsFullException e) {
                System.out.println("table is full");
            } catch (IHashTable.KeyAlreadyExistsException e) {
                System.out.println("key already exists");
            }
//
        }
        long finish = System.nanoTime();
        System.out.println(finish - start);
    }
}
