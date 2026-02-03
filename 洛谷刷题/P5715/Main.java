package 洛谷.P5715;

import java.util.Scanner;

class Main{
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      if (a>b) {
          int t =a; a=b; b=t;
      }

      if (b>c) {
          int t=b; b=c; c=t;
      }

        if (a>b) {
            int t =a; a=b; b=t;
        }
        System.out.println(a + " " + b + " " + c);
        }
    }