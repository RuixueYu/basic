package likou;

import java.util.Stack;

/**
 * 匹配括号
 */
public class LiKou20 {
    public static boolean isValid(String s) {
        //方法一：利用字符串replace
        /*if(s.length() == 0 || s.length() % 2 == 1)
            return false;
        else{
            int length = s.length() / 2;
            for (int i = 0; i < length; i++) {
                s = s.replace("()", "").replace("{}", "").replace("[]", "");
            }
        }
        return s.length() == 0;*/

        //方法二：利用栈
        Stack<Character> stack = new Stack<Character>();
        for(char c: s.toCharArray()){
            if(c=='(') {
                stack.push(')');
            } else if(c=='[') {
                stack.push(']');
            } else if(c=='{') {
                stack.push('}');
            } else if(stack.isEmpty()||c!=stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{(){}}[][]()"));
    }
}
