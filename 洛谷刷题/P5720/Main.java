package 洛谷.P5720;

import java.util.Scanner;

class Main{
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

      int a = sc.nextInt();

      int cntA = 1;

      for(int i=a; i>1; i/=2){
          cntA++;
      }


        System.out.println(cntA);
        }
    }