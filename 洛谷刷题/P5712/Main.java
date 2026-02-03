package 洛谷.P5712;

import java.util.Scanner;

class Main{
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

      int n = sc.nextInt();

      if (n==1){
          System.out.println("Today, I ate 1 apple.");
      } else if (n==0) {
          System.out.println("Today, I ate 0 apple.");
      } else {
            System.out.println("Today, I ate "+n+" apples.");
        }
    }
    }