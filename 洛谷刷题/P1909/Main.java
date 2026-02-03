package 洛谷.P1909;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long ans = Long.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            long a = sc.nextLong(); // 每包铅笔数
            long p = sc.nextLong(); // 每包价格

            long packs = (n + a - 1) / a; // 向上取整
            long cost = packs * p;

            if (cost < ans) ans = cost;
        }

        System.out.println(ans);
    }
}