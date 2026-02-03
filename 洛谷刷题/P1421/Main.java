package 洛谷.P1421;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int n = (int) ((a+0.1*b)/1.9);

        System.out.println(n);
    }
}