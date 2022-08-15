package likou;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: YuRuixue
 * @Description: 三数之和
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2022/6/14 16:17
 */
public class liKou15NSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 2, 3, -1, -4};
        System.out.println(nSumTarget(nums,4, 0, 2));
    }

    /**
     * 返回nums中n数之和为target的所有组合列表
     * @param nums 所使用的数组
     * @param n n个数之和
     * @param start 从数组什么位置开始
     * @param target n数之和的目标值
     * @return 所有符合条件的列表
     */
    public static  List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
        //先给数组排序
       Arrays.sort(nums);

       //获取数组长度
       int length = nums.length;

       //存放返回值
       List<List<Integer>> res = new LinkedList<>();

       //至少是2sum,且数组大小不应该小于n
       if(n < 2 || length < n) {
           return res;
       }

       //如果是2sum
       if(n == 2) {
           int lo = start, hi = length - 1;
           while (lo < hi) {
               int sum = nums[lo] + nums[hi];
               int left = nums[lo], right = nums[hi];
               if(sum < target) {
                   while (lo < hi && nums[lo] == left) {
                       lo++;
                   }
               }else if(sum > target) {
                   while (lo < hi && nums[hi] == right) {
                       hi--;
                   }
               }else {
                   List<Integer> list = new LinkedList<>();
                   list.add(left);
                   list.add(right);
                   res.add(list);
                   while (lo < hi && nums[lo] == left) {
                       lo++;
                   }
                   while (lo < hi && nums[hi] == right) {
                       hi--;
                   }
               }
           }
       }else {
           //n > 2时，递归计算（n-1）Sum 的结果
           for(int i = start; i < length; i++) {
               List<List<Integer>> sub = nSumTarget(nums,n - 1, i + 1, target - nums[i]);
               for (List<Integer> integers : sub) {
                   integers.add(nums[i]);
                   res.add(integers);
               }
               while (i < length - 1 && nums[i] == nums[i + 1]) {
                   i++;
               }
           }
       }

    return res;
    }

}
