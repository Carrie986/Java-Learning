package 洛谷.P1980;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int count=0;

        for (int i = 1; i <=n; i++) {
            int m=i; // 复制一份i
            while(m>0){
                int l = m%10;// 取到个位
                if(l==x){
                    count++;
                }
                m/=10;// 每次取完个位之后除以10，让下一位变成个位
            }
        }
        System.out.println(count);
    }
}