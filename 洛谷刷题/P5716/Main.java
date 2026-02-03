package 洛谷.P5716;

import java.util.Scanner;

class Main{
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

      int y = sc.nextInt();
      int m = sc.nextInt();

      if (m==2){
          if (y%4 == 0 && y%100 != 0 || y%400 == 0) {
              System.out.println(29);
          } else {
              System.out.println(28);
          }
      } else if (m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12) {
          System.out.println(31);
      } else {
          System.out.println(30);
      }
        }
    }