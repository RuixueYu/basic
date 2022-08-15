package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: YuRuixue
 * @Description: TODO
 * @date 2022/4/26 19:25
 */
public class r1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String totalStr = scanner.nextLine();
        //String totalStr = "a:3,b:5,c:2@a:1,b:2";
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        String s1 = totalStr.split("@")[0];
        if(totalStr.split("@").length == 1){
            System.out.println(s1+"@");
            return;
        }
        String s2 = totalStr.split("@")[1];
        String[] split1 = s1.split(",");
        String[] split2 = s2.split(",");
        for (String s : split1) {
            map1.put(s.split(":")[0],Integer.parseInt(s.split(":")[1]));
        }
        for (String s : split2) {
            map2.put(s.split(":")[0],Integer.parseInt(s.split(":")[1]));
        }
        Set<Map.Entry<String, Integer>> entries = map2.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            map1.put(key,map1.get(key)-entry.getValue());
        }
        StringBuilder stringBuilder = new StringBuilder();
        Set<Map.Entry<String, Integer>> entries2 = map1.entrySet();
        for (Map.Entry<String, Integer> entry : entries2) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if(value != 0){
                stringBuilder.append(key+":"+value+",");
            }
        }
        String toString = stringBuilder.toString();
        if(toString.length() == 0){
            System.out.println();
        }else {
            System.out.println(toString.substring(0,toString.length()-1));
        }

    }
}
