package writtenquestions;

/**
 * @Author : YuRuixue
 * @Description: 长城数组例如{1,9,1,9,1}呈锯齿状，给定一个数组，数组中的每个数每次操作只能加1，
 * 求一个数组变为长城数组的最少操作次数 例{1，1，4，5，1，4}变为{4,5,4,5,4,5}至少需要11次
 * @date :   2022-08-20 16:42
 */
public class GreatWallArray {
    public static void main(String[] args) {
//        int[] nums = {1,1,4,5,1,4};
        int[] nums = {4,4,4,4,4,4,4};
        System.out.println(changeToGreatWallArray(nums));

    }
    static int changeToGreatWallArray(int[] nums) {
        //记录奇偶数位最大值
        int evenMax = 0;
        int oddMax = 0;
        //记录操作次数
        int operationCount = 0;
        //获取偶数位、奇数位最大值 因为数只能进行加操作，所以要使每位数向最大位靠齐
        for (int i = 0; i < nums.length; i ++) {
            if(i % 2 == 0) {
                evenMax = nums[i] > evenMax ? nums[i] : evenMax;
            }
            if(i % 2 == 1) {
                oddMax = nums[i] > oddMax ? nums[i] : oddMax;
            }
        }

        //每一位的数补到对应的最大值需要的操作数
        for (int i = 0; i < nums.length; i ++) {
            if(i % 2 == 0) {
                operationCount += (evenMax - nums[i]);
            }
            if(i % 2 == 1) {
                operationCount += (oddMax - nums[i]);
            }
        }

        //如果奇偶数位最大值相等，需要将奇数位或偶数位的值再增加1，确保数据为交错状态
        if(evenMax == oddMax) {
            operationCount += nums.length / 2;
        }
        return operationCount;
    }
}
