package 洛谷.P5705;

import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        double n = 123.4;
        int d1 = (int)(10*(n%1));
        System.out.println(d1);
        int n1 = (int)n;
        int d = 0;
        while (n1>0){
            int i = n1%10;
            d = d*10+i;
            n1/=10;
        }
        System.out.println(d);
        System.out.println(d1+"."+d);



       Scanner sc = new Scanner(System.in);
      String cstr = "";
      cstr = sc.next();
      // 123.4 -> 4.321,数一定是3位数，小数部分1位
        char c1 = cstr.charAt(4);
        char c2 = cstr.charAt(2);
        char c3 = cstr.charAt(1);
        char c4 = cstr.charAt(0);
        System.out.println(c1+"."+c2+c3+c4);
    }
}