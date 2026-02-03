package 洛谷.P5718;

import java.util.Scanner;

class Main{
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
        int min = sc.nextInt();
        for(int i=0; i<n-1;i++){
            int m = sc.nextInt();
            if (m<min){
                min = m;
            }
        }
        System.out.println(min);
    }
}