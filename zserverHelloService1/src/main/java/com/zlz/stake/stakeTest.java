package com.zlz.stake;

/**
 * @Title :
 * @Description :
 * @Author : zhanglz
 * @Date : 2018-07-29 1:12
 */
public class stakeTest {


    public static void f(int i) {
        System.out.println("Initializationthat requires cleanup");
        try {
            System.out.println("Point1");
            if (i == 1) return;
            System.out.println("Point2");
            if (i == 2) return;
            System.out.println("Point3");
            if (i == 3) return;
            System.out.println("End");
            return;
        } finally {
            System.out.println("Performingcleanup");
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            f(i);
        }



    }



}
