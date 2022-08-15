package zte;

import java.util.Scanner;

/**
 * @Author: YuRuixue
 * @Description: 亲和串
 * 输入描述：本题有多组测试数据，每组数据的第一行包含输入字符串s1,第二行包含输入字符串s2，s1与s2的长度均小于100000。
 * 输出描述： 如果s2是s1的亲和串，则输出"yes"，反之，输出"no"。每组测试的输出占一行。
 * 输入： AABCD CDAA
 * 输出： yes
 * @date 2022/3/31 16:10
 */
public class AffinityString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        System.out.println(isAffinityString(s1,s2));
    }
    public static String isAffinityString(String s1,String s2){
        if(s1.equals(s2) || s1.contains(s2)){
            return "yes";
        }else if(s1.length() >= s2.length()){
            for (int i = 1; i < s1.length(); i++) {
                StringBuilder builder = new StringBuilder();
                String string = builder.append(s1.substring(i)).append(s1, 0, i).toString();
                if(string.contains(s2)){
                    return "yes";
                }
            }
        }

        return "no";
    }
}
