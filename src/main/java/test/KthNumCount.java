package test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: YuRuixue
 * @Description: 第k大数的个数
 * @date 2022/8/14/0014 17:32
 */
public class KthNumCount {
    public static void main(String[] args) {
        int[] nums = {5,1,1,4,2,4,3,4,5,5,5};
        System.out.println(getKthNumCount(nums, 5));

    }
    public static int getKthNumCount(int[] nums, int k) {
        int index = 1;
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(index,1);
        for (int i = nums.length - 1; i > 0 ; i--) {
            if(nums[i - 1] == nums[i]) {
                map.put(index,map.get(index)+1);
            }else {
                index++;
                map.put(index,1);
            }
        }
        if(index < k) {
            return 0;
        }
        return map.get(k);
    }
}
