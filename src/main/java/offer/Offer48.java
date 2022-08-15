package offer;

import java.util.HashSet;

/**
 * @Author: YuRuixue
 * @Description: 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * @date 2022/4/13 8:49
 */
public class Offer48 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("qweaeqw"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int maxSubLength = 0;
        int start = -1;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if(i != 0){
                set.remove(s.charAt(i - 1));
            }
            while (start + 1 < s.length() && !set.contains(s.charAt(start + 1))){
                set.add(s.charAt(start + 1));
                ++start;
            }
            maxSubLength = Math.max(maxSubLength, start - i + 1);
        }
        return maxSubLength;
    }
}
