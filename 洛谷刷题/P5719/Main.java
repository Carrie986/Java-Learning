package 洛谷.P5719;

import java.util.Scanner;

class Main{
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

      int n = sc.nextInt();
      int k = sc.nextInt();

      long sumA = 0, sumB = 0;
      int cntA = 0, cntB = 0;

        for(int i=1; i<n+1; i++){
            if (i%k == 0){
                sumA += i;
                cntA ++;
            }
            else {
                sumB += i;
                cntB ++;
            }

            }
        double avgA = (double) sumA / cntA;
        double avgB = (double) sumB / cntB;

        System.out.printf("%.1f %.1f", avgA, avgB);
        }
    }