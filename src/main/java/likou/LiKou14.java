package likou;

public class LiKou14 {
    public static void main(String[] args) {
        String[] strs = {"aaa56e","aaa","aaah"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        //自己写的
        if(strs.length == 1)
            return strs[0];
        else{
            int minLength = strs[0].length();
            String longPrefix = "";
            for (int i = 1; i < strs.length; i++) {
                minLength = minLength < strs[i].length() ? minLength : strs[i].length();
            }
            for (int i = 0; i < minLength; i++) {
                for (int i1 = 0; i1 < strs.length-1; i1++) {
                    if(strs[i1].charAt(i) != strs[i1+1].charAt(i))
                        return longPrefix;
                    if(strs[i1].charAt(i) == strs[i1+1].charAt(i) && i1 == strs.length-2)
                        longPrefix += String.valueOf(strs[0].charAt(i));
                }
            }
            return longPrefix;
        }

        //网上方法
        /*if(strs.length==0)return "";
        //公共前缀比所有字符串都短，随便选一个先
        String s=strs[0];
        for (String string : strs) {
            while(!string.startsWith(s)){
                if(s.length()==0)return "";
                //公共前缀不匹配就让它变短！
                s=s.substring(0,s.length()-1);
            }
        }
        return s;*/

    }
}
