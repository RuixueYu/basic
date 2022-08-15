package offer;

import java.util.ArrayList;

/**
 * @Author: YuRuixue
 * @Description: 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分
 * @date 2022/4/26 16:54
 */
public class Offer21 {
    public static void main(String[] args) {
        int[] nums = {11,9,3,7,16,4,2,0};
        for (int i : exchange(nums)) {
            System.out.println(i);
        }
    }
    public static int[] exchange(int[] nums) {
        /*//自己方法
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            //奇数
            if(num % 2 != 0){
                list.add(0,num);
            }else{
                list.add(num);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();*/

        //双指针
        int left = 0,right = nums.length - 1;
        while (left <= right){
            //奇数
            while (left < right && nums[left] % 2 != 0){left ++;}
            //偶数
            while (left < right && nums[right] % 2 == 0){right --;}
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left ++;
            right --;
        }
        return nums;
    }
}
