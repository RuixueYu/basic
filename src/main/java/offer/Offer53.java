package offer;

/**
 * @Author: YuRuixue
 * @Description: 在排序数组中查找数字 I
 * @date 2022/3/22 14:25
 */

/**
 * 统计一个数字在排序数组中出现的次数,数组为非递减数组
 */
public class Offer53 {
    public static int search(int[] nums, int target) {
        int n = 0;
        for (int num : nums) {
            if(num == target){
                n++;
                continue;
            }
            if(num > target){
                break;
            }
        }
        return n;
    }

    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,5,5,6,6,6,7};
        int[] nums = {1};
        System.out.println(search(nums,1));
    }
}
