package 洛谷.P2669;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();   // 剩余天数
        long sum = 0;
        int n = 1;              // 当前每天发 n 枚

        while (k > 0) {
            int days = Math.min(k, n); // 这一组实际发 days 天（不够就发剩余天数）
            sum += (long) n * days;    // 累加：每天n枚 * days天
            k -= days;                 // 用掉这些天
            n++;                       // 下一组每天多发1枚
        }

        System.out.println(sum);
    }
}