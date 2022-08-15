package offer;

/**
 * @Author: YuRuixue
 * @Description: 旋转数组的最小数字
 * @date 2022/3/23 16:52
 */

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 给你一个可能存在重复元素值的数组numbers，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。
 * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 */
public class Offer11 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3,1,2};
        System.out.println(minArray(numbers));
    }
    public static int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i+1] < numbers[i]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }
}
