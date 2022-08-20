package algorithms.sort.test;

/**
 * @Author: YuRuixue
 * @Description: TODO
 * @date 2022/8/07/0007 15:31
 */
public class mytools {
    public static void main(String[] args) {
        String funName = args[0];
        switch (funName) {
            case "add2":
                System.out.println(add2(Integer.parseInt(args[1]),Integer.parseInt(args[2])));
                break;
            case "add3":
                System.out.println(add3(Integer.parseInt(args[1]), Integer.parseInt(args[2]),Integer.parseInt(args[3])));
                break;
            case "stradd":
                System.out.println(stradd(args[1],args[2]));
                break;
            default:
        }
    }
    public static String add2(int a, int b) {
        int result = a + b;
        return a + " + " + b + " = " + result;
    }
    public static String add3(int a, int b, int c) {
        int result = a + b + c;
        return a + " + " + b + " + " + c  + " = " + result;
    }
    public static String stradd(String a, String b) {
        return a + " + " + b + " + " + " = " + a+b;
    }
}
