package offer;

import java.util.HashSet;

/**
 * @Author: YuRuixue
 * @Description: 第一个只出现一次的字符 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * @date 2022/3/23 17:16
 */
public class Offer50 {
    public static void main(String[] args) {
        String s = "abab";
        System.out.println(firstUniqChar(s));
    }
    public static char firstUniqChar(String s) {
        if(s.length() == 0){
            return ' ';
        }else{
            HashSet<Character> hashSet = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                if(hashSet.contains(s.charAt(i)) == false){
                    int index = s.substring(i + 1).indexOf(s.charAt(i));
                    hashSet.add(s.charAt(i));
                    if(index >= 0){
                        continue;
                    }else {
                        return s.charAt(i);
                    }
                }
            }
            return ' ';
        }

    }
}
