package 洛谷.P1035;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();

        double sum = 0.0;
        int n = 0;

        while (sum <= k) {
            n++;
            sum += 1.0 / n;
        }

        System.out.println(n);
    }
}