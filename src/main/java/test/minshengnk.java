package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: YuRuixue
 * @Description: 一个长度为n的数组，数字范围1-n,每个数只出现一次，
 * 输出一组满足要求的数：其中恰好有k对相邻的数满足前一个数大于后一个数
 * 例 输入：5 2
 * 输出：1 4 2 5 3
 * @date 2022/8/14/0014 11:07
 */
public class minshengnk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        for(int i = 0; i < k; i++) {
            System.out.print(n - i);
            if(n - i != 1) {
                System.out.print(" ");
            }
        }
        for(int i = 1; i <= n - k; i++) {
            System.out.print(i);
            if(i != n - k) {
                System.out.print(" ");
            }
        }
    }
}
