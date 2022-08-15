package test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: YuRuixue
 * @Description: TODO
 * @date 2022/4/2 11:00
 */
public class test3 {
    public static void main(String[] args) {
        test3 test3 = new test3();
        Scanner scanner = new Scanner(System.in);
        test3.str = scanner.nextLine();
        test3.core = scanner.nextLine();
        StringBuilder builder = new StringBuilder();
        //test.test3.subsets(test.test3.str,builder);
        //System.out.println(test.test3.total);

    }
    String str ;
    String core;
    int total = 0;
    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯算法的递归路径

    // 主函数
    public List<List<Integer>> subsets(String str,StringBuilder builder) {
        char[] nums = str.toCharArray();
        backtrack(nums, 0,builder);
        return res;
    }

    // 回溯算法核心函数，遍历子集问题的回溯树
    void backtrack(char[] nums, int start,StringBuilder builder) {
        //System.out.println(builder.toString());
        if(builder != null && builder.toString().contains(core) && str.contains(builder.toString())){
            System.out.println(builder.toString());
            total ++;
        }
        // 回溯算法标准框架
        for (int i = start; i < nums.length; i++) {
            // 做选择
            builder.append(nums[i]);
            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtrack(nums, i + 1,builder);
            // 撤销选择
            builder.deleteCharAt(builder.length() -1);
        }
    }
}
