package 洛谷.P5711;

import java.util.Scanner;

class Main{
    public static void main(String[] args) {
       double d = 1.23456;
        System.out.println(d);
        System.out.println(String.format("%.4f",d)); //
        System.out.printf("%.2f%n",d);
        System.out.printf("%.2f",d);
        Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
        if (n%4 == 0 && n%100 != 0 || n%400 ==0){
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }
}