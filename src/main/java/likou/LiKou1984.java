package likou;

import java.util.Arrays;

/**
 * @Author: YuRuixue
 * @Description: 学生分数的最小差值
 * @date 2022/2/11 20:32
 */
public class LiKou1984 {
    public static void main(String[] args) {
        int[] score = {87063,61094,44530,21297,95857,93551,9918};
        System.out.println(minimumDifference(score,6));
    }
    static public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        //固定窗口长度为k
        for (int l = 0, r = k - 1; r < nums.length; ){
            res = Math.min(res, nums[r++] - nums[l++]);
        }
        return res;
    }
}
