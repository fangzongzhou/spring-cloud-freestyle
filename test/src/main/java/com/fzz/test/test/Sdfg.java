package com.fzz.test.test;

/**
 * @author 73956
 */

public class Sdfg {
    public static void main(String[] args) {
        System.out.println(1);
        Sdfg sdfg = new Sdfg();
        for(int i=0;i<10;i++) {
           for(int j=0;j<10;j++) {
               int a = i;
               int b = j;
               System.out.println(sdfg.sum(a,b));
           }
        }


    }

    public int sum(int a, int b) {
        return a + b;
    }
}

/*    object Main {
@JvmStatic
  fun main(a:Array<String>){
        println("Hello World")
        }
        }*/
