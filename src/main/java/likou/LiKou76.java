package likou;

import java.util.HashMap;

/**
 * @Author: YuRuixue
 * @Description: 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * @date 2022/6/10 17:03
 */
public class LiKou76 {
    public static void main(String[] args) {
        String s = "qwehwrewtet";
        String t = "ewr";
        System.out.println(minWindow(s, t));
    }
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> need =new HashMap<>();
        HashMap<Character, Integer> window =new HashMap<>();
        //将目标子串存入map中
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i),need.getOrDefault(t.charAt(i), 0) + 1);
        }
        //窗口左右指针
        int left = 0;
        int right = 0;
        //符合的字母个数
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        while(right < s.length()) {
            //当前要判断的字母
            char c = s.charAt(right);
            right ++;
            if(need.containsKey(c)) {
                //如果目标字符串包含此字符则加入窗口中
                window.put(c, window.getOrDefault(c,0) + 1);
                //判断此字符的个数是否符合目标字符串的要求
                if(window.get(c).equals(need.get(c))) {
                    //若符合，有效字符 + 1
                    valid++;
                }
            }

            //当所有字符符合要求了， 判断左窗口是否要收缩
            while(valid == need.size()) {
                if(right - left < len){
                    start = left;
                    len = right - left;
                }

                //左边要移除的字符
                char d = s.charAt(left);
                left++;

                if(need.containsKey(d)) {
                    if(window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d,window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
