package test;

/**
 * @Author: YuRuixue
 * @Description: 走路捡金币
 * @date 2022/4/19 20:05
 */
public class test5 {
    public static void main(String[] args) {

    }
    public static int test(int n,int k,int[] arr){
        int rightSum = 0;
        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || i == 1){
                rightSum += i;
                break;
            }else {
                rightSum += i;
            }
        }
        return 0;
    }
}
