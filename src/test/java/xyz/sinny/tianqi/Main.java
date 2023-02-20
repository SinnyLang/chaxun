package xyz.sinny.tianqi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String str;

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入英文句子，按回车结束：");
        str = scanner.nextLine();

        int sp = 0;
        int alf= 0;
        int num= 0;
        int oth= 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' '){
                sp++;
            }else if (c>='0' && c<= '9'){
                num++;
            }else if ((c>='A' && c<='Z') || (c>='a' && c<='z')){
                alf++;
            }else {
                oth++;
            }
        }

        System.out.println("数字个数："+num);
        System.out.println("英文字母个数："+alf);
        System.out.println("空格个数："+sp);
        System.out.println("其它字符个数："+oth);

    }
}
