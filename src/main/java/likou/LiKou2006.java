package likou;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: YuRuixue
 * @Description: 差的绝对值为 K 的数对数目
 * @date 2022/2/9 23:17
 */
public class LiKou2006 {
    public static void main(String[] args) {
        int[] arr = {1,6,7,8,13,18,12,6,11};
        System.out.println(countKDifference(arr,5));
    }
    static public int countKDifference(int[] nums, int k) {
        /*//方法一：暴力 两层循环
        if(nums.length < 2) {
            return 0;
        }
        else {
            int count = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if(Math.abs(nums[i]-nums[j]) == k){
                        count ++;
                    }
                }
            }
            return count;
        }*/

        //方法二：哈希表 + 一次遍历
        int res = 0, n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int j = 0; j < n; ++j) {
            res += cnt.getOrDefault(nums[j] - k, 0) + cnt.getOrDefault(nums[j] + k, 0);
            cnt.put(nums[j], cnt.getOrDefault(nums[j], 0) + 1);
        }
        return res;

    }
}
