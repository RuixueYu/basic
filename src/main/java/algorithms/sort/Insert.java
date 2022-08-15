package algorithms.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: YuRuixue
 * @Description: 插入排序 O(n^2)
 * @date 2022/4/13 16:33
 */
public class Insert {
    public static void main(String[] args) {
        int[] num = {67,3, 24, 5, 14, 54,3};
        System.out.println(Arrays.toString(InsertionSort(num)));
    }
    public static int[] InsertionSort(int[] num){
        for (int i = 1; i < num.length; i++) {
            for (int j = i; j > 0; j--) {
               if(num[j] < num[j-1]){
                   int temp = num[j];
                   num[j] = num[j-1];
                   num[j-1] = temp;
               }else {
                   break;
               }
            }
        }
        return num;
    }
}
