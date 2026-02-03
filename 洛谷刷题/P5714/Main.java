package 洛谷.P5714;

import java.util.Scanner;

class Main{
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

      double m = sc.nextDouble();
      double h = sc.nextDouble();

      if (m/(h*h)<18.5){
          System.out.println("Underweight");
      } else if (m/(h*h)>=24) {
          System.out.printf("%.6g%n",m/(h*h));
          System.out.println("Overweight");
      } else {
            System.out.println("Normal");
        }
    }
    }