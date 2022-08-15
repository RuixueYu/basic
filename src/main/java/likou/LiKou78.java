package likou;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: YuRuixue
 * @Description: 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * @date 2022/6/08 19:22
 */
public class LiKou78 {
    /**
     * 存返回值
     */
    static List<List<Integer>> res = new LinkedList<>();
    /**
     * 存当前回溯的列表
     */
    static LinkedList<Integer> track = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));

    }
    public static List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    /**
     * 回溯方法
     * @param nums 数组
     * @param start 起始位置
     */
    public static void backtrack(int[] nums, int start) {
        res.add(new LinkedList<>(track));
        for(int i = start; i < nums.length; i++) {
            track.addLast(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }
}
