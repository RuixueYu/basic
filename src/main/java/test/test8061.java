package test;

/**
 * @Author: YuRuixue
 * @Description: 四边形面积
 * @date 2022/8/06/0006 19:41
 */
public class test8061 {
    public static void main(String[] args) {
        System.out.println(find());
    }
    public static long find() {
        long result;
        int x1 = 1;
        int y1 = 1;
        int x2 = 2;
        int y2 = 2;
        int x3 = 1;
        int y3 = 3;
        int x4 = 0;
        int y4 = 2;
        result = Math.round(Math.abs(((x1 * y2 - x2 * y1) + (x2 * y3 - x3 * y2) + (x3 * y4 - x4 * y3) + (x4 * y1 - y4 * x1)) / 2));
        return result;
    }
}
