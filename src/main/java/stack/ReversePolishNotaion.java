package stack;

import java.util.Stack;

/**
 * @Author: YuRuixue
 * @Description: 逆波兰表达式
 * @date 2022/4/21 22:23
 */
public class ReversePolishNotaion {
    public static void main(String[] args) {
        //中缀表达式 3*(17 -15)+18/6
        String[] noation = {"3","17","15","-","*","18","6","/","+",};
        System.out.println(caculate(noation));
    }
    /**
     * 中缀表达式的字符串
     * @param noation
     */
    public static int caculate(String[] noation){
        //1.定义一个栈，用于存操作数
        Stack<Integer> stack = new Stack<>();
        //2.遍历数组，将数字放入栈中，遇到操作符时将栈中的两个数字取出并运算，注意运算前后顺序，再将结果放入栈中
        for (String s : noation) {
            Integer o1;
            Integer o2;
            Integer result;
            switch (s){
                case "+":
                    o1 = stack.pop();
                    o2 = stack.pop();
                    result = o2 + o1;
                    stack.push(result);
                    break;
                case "-":
                    o1 = stack.pop();
                    o2 = stack.pop();
                    result = o2 - o1;
                    stack.push(result);
                    break;
                case "/":
                    o1 = stack.pop();
                    o2 = stack.pop();
                    result = o2 / o1;
                    stack.push(result);
                    break;
                case "*":
                    o1 = stack.pop();
                    o2 = stack.pop();
                    result = o2 * o1;
                    stack.push(result);
                    break;
                default:
                    stack.push(Integer.valueOf(s));
            }

        }
        return stack.pop();
    }
}
