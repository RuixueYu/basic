package likou;

/**
 * @Author: YuRuixue
 * @Description: 有序数组中的单一元素
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 * 请你找出并返回只出现一次的那个数
 * @date 2022/2/14 14:09
 */
public class LiKou540 {
    public static void main(String[] args) {
        int[] nums = {0,1, 1, 2,2, 3, 3,3,3,4,4,7};
        System.out.println(singleNonDuplicate(nums));
    }
    static public int singleNonDuplicate(int[] nums) {
        for (int i = 0; i < nums.length ; i += 2) {
            if(i  == nums.length - 1 || (float)(nums[i]+nums[i+1]) / 2 != (float) nums[i]) {
                return nums[i];
            }
        }
        return -1;
    }
}
