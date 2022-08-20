package algorithms.sort.test;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: YuRuixue
 * @Description: 将密码按照一定的规则转换
 *abc-2,def-3,ghi-4 jkl-5 mno-6 pqr-7 stuv-8 wxyz-9
 * 大写字母转为小写再向前一位再按照前面规则转为数字
 * 特殊A转为小写a再向前一位为z，z对应9
 * 其他字符不变
 * @date 2022/8/18/0018 18:15
 */
public class PasswordTransfer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        System.out.println(transfer(password));
        System.out.println(f(3,4));
    }

    public static int f(int a ,int b) {
        if (a < b) {
            return f(b,a);
        }else if(b!=0) {
            return a + f(a,b-1);
        }else{
            return 0;
        }
    }

    public static String transfer(String password) {
        StringBuilder builder = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>(10);
        int num = 2;
        char c = 'a';
        while (c < 's') {
            for(int j = 0; j < 3; j++) {
                map.put(c++, num);
            }
            num++;
        }
        while (c < 'z') {
            for(int j = 0; j < 4; j++) {
                map.put(c++, num);
            }
            num++;
        }
        for (int i = 0; i < password.length(); i++) {
            char temp = password.charAt(i);
            if(temp >= 'a' && temp <= 'z') {
                builder.append(map.get(password.charAt(i)));
            }else if(temp >= 'A' && temp <= 'Z') {
                //字符加数字隐式向上转型为int 需要字符型需要再强制向下转型为char
                int ch = temp + 32 - 1;
                builder.append(temp == 'A' ? '9' : map.get((char) ch));
            }else{
                builder.append(temp);
            }
        }
        return builder.toString();
    }
}
