package writtenquestions;

import java.util.*;

/**
 * @Author: YuRuixue
 * @Description: TODO
 * @date 2022/4/15 19:44
 */
public class phoneTest {
    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine();
        HashMap<Integer, String> map = new HashMap<>();
        List<String> strings = new ArrayList<>(Arrays.asList("ABC", "DEF", "GHI","JKL","MNO","PQRS","TUV","WXYZ"));
        for (int i = 2; i < 10; i++) {
            map.put(i,strings.get(i-2));
        }
        while (str.startsWith("1")){
            str = str.substring(1);
        }
        if(str.length() > 0){
            //用于控制下标位置，初始位置为0
            int index = 0;

            //获取第一个数字对应的字母
            String cur = getNumString(0,map,str).substring(index,index + 1);

            //用于存放最后输出的字符串
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 1; i < str.length(); i++) {
                if(str.charAt(i) == str.charAt(i-1) && !String.valueOf(str.charAt(i)).equals("1")){
                    //如果已经是最后一个字母，则将下标重新置为0
                    if(index == getNumString(i,map,str).length() - 1){
                        index = 0;
                    }
                    cur = getNumString(i,map,str).substring(++index,index + 1);
                }else {
                    stringBuilder.append(cur);
                    if("1".equals(String.valueOf(str.charAt(i)))){
                        cur = "";
                    }else {
                        cur = getNumString(i,map,str).substring(0,1);
                    }
                }
            }
            System.out.println(stringBuilder.toString());
        }else {
            System.out.println();
        }


    }

    /**
     * 用于获取数字当前所对应的字符串
     * @param i 下标
     * @param map map
     * @param str 输入的字符串
     * @return 当前字母
     */
    public static String getNumString(int i,HashMap<Integer, String> map,String str){
        return map.get(Integer.parseInt(str.substring(i,i+1)));
    }

}
