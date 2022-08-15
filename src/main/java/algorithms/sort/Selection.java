package algorithms.sort;

import java.util.Arrays;

/**
 * @Author: YuRuixue
 * @Description: 选择排序 O(n^2)
 * 每次选择数组中最小数的下标，放在数组的第一位
 * @date 2022/4/13 16:07
 */
public class Selection {
    public static void main(String[] args) {
        int[] num = {67,3, 24, 8,5, 14, 54,3};
        System.out.println(Arrays.toString(SelectionSort(num)));
    }
    public static int[] SelectionSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }
}
