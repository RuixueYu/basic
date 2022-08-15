package offer;

/**
 * @Author: YuRuixue
 * @Description: 0～n-1中缺失的数字
 * @date 2022/3/22 14:39
 */

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OfferII53 {
    public static void main(String[] args) {
//        int[] nums = {0, 1, 2, 3,4, 5, 6,8};
        int[] nums = {0};

        System.out.println(missingNumber(nums));
    }
    public static int missingNumber(int[] nums) {
        int sum = 0;
        int real = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            real += i;
            if(sum != real){
                return i;
            }
        }
        return 0;
    }
}
