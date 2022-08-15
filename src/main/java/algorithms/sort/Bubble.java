package algorithms.sort;

import java.util.Arrays;

/**
 * @Author: YuRuixue
 * @Description: 冒泡排序 O(n^2)
 * 相邻的两两比较将最大的放在后面
 * @date 2022/4/13 15:58
 */
public class Bubble {
    public static void main(String[] args) {
        int[] num = {67,3, 24, 5, 14, 54,3};
        System.out.println(Arrays.toString(bubbleSort(num)));
    }
    public static int[] bubbleSort(int[] nums){
        for(int i = nums.length -1;i >=0;i--){
            for (int j = 0; j < i; j++) {
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }
}
