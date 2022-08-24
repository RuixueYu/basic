package writtenquestions;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author : YuRuixue
 * @Description: 从一个数组中找出最长连续子串的界限
 * 例{100,4,200,1,3,2} 连续字串{1，2，3，4} 返回[1,4]
 * @date :   2022-08-24 19:37
 */
public class LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = {99,100,200,1,3,2,2,5,6,7,8,9,101,102,103,6};
        int[] ints = longestConsecutive(nums);

        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
    static int[] longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int[] array = new int[set.size()];
        int in = 0;
        for (Integer integer : set) {
            array[in++] = integer;
        }
        Arrays.sort(array);
        int startIndex = 0;
        int meetIndex = 0;
        int length = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i + 1] == array[i] + 1){
                //符合要求
            }else{
                if(i - startIndex + 1 > length) {
                    length = i - startIndex + 1;
                    meetIndex = startIndex;
                }
                startIndex = i + 1;
            }
            if(array[i + 1] > array[i] + 1){
                //不符合要求
                if(i - startIndex + 1 > length) {
                    length = i - startIndex + 1;
                    meetIndex = startIndex;
                }
                startIndex = i + 1;
            }

        }
        int[] ints = new int[2];
        ints[0] = array[meetIndex];
        ints[1] = array[meetIndex + length - 1];
        return ints;
    }
}
