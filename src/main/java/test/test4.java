package test;

/**
 * @Author: YuRuixue
 * @Description: TODO
 * @date 2022/4/12 19:54
 */
public class test4 {
    static int x = 0;
    static int y = 0;
    public static void main(String[] args) {
        String s = "RUL";
        for (int i = 0; i < s.length(); i++) {
            judge(s.charAt(i));

        }
        System.out.println("("+x+","+y+")");
    }
    public static void judge(char c){
        switch (c) {
            case 'L':
               x -= 1;
               break;
            case 'R':
                x += 1;
                break;
            case 'U':
                y += 1;
                break;
            case 'D':
                y -= 1;
            default:
        }
    }
}
