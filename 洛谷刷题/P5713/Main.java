package 洛谷.P5713;

import java.util.Scanner;

class Main{
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

      int n = sc.nextInt();

      int local = 5*n;
      int luogu = 3*n+11;

      if (luogu>local){
          System.out.println("Local");
      } else {
            System.out.println("Luogu");
        }
    }
    }