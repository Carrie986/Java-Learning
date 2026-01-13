package 洛谷.P1009;

import java.math.BigInteger;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

      int n = sc.nextInt();

        BigInteger fact = BigInteger.ONE;
        BigInteger sum = BigInteger.ZERO;

        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
            sum = sum.add(fact);
        }

        System.out.println(sum);

        }
    }