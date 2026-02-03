package 洛谷.P5704;

import java.util.Scanner;

class Main{
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
      String cstr = "";
      cstr = sc.next();
      //转成字符
        char c = cstr.charAt(0);
        c=(char)(c-32); //将数字再转换为字符
        System.out.println(c);
    }
}