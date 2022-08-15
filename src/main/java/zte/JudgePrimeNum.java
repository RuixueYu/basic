package zte;

/**
 * @Author: YuRuixue
 * @Description: 判断素数
 * 题目描述：给定一个数n，要求判断其是否为素数（0,1，负数都是非素数）。输入描述： 测试数据有多组，每组输入一个数n。输出描述： 对于每组输入,若是素数则输出yes，否则输入no。
 * @date 2022/3/31 11:29
 */
public class JudgePrimeNum {
    public static final int MIN_NUM = 2;
    public static void main(String[] args) {
        System.out.println(judgePrime(51));
    }
    public static String judgePrime(int num){
        if (num >= MIN_NUM) {
            for (int i = MIN_NUM; i <= (num / 2); i++) {
                if (num % i == 0) {
                    return "no";
                }
            }
        }
        return "yes";
    }

}
