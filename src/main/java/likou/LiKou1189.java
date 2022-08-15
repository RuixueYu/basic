package likou;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: YuRuixue
 * @Description: “气球” 的最大数量
 * 给你一个字符串text，你需要使用 text 中的字母来拼凑尽可能多的单词"balloon"（气球）。
 *字符串text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词"balloon"。
 * @date 2022/2/13 21:24
 */
public class LiKou1189 {
    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("balloonballoonballoonb"));
    }
    static public int maxNumberOfBalloons(String text) {
        if (text != "" && text != null) {
            HashMap<Character, Integer> map = new HashMap<>();
            char[] chars = text.toCharArray();
            for (char c : chars) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            int[] arr ={map.getOrDefault('b',0),map.getOrDefault('a',0),map.getOrDefault('l',0)/2,
                    map.getOrDefault('o',0)/2,map.getOrDefault('n',0)} ;
            Arrays.sort(arr);
            return arr[0];
        }
        return 0;
    }
}
