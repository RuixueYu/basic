package likou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: YuRuixue
 * @Description: 矩阵中的幸运数
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 * 幸运数是指矩阵中满足同时下列两个条件的元素：
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 * @date 2022/2/15 13:09
 */
public class LiKou1380 {
    public static void main(String[] args) {
        int[][] matrix= {{1,10,4,2},{9,3,8,7},{15,16,17,12}};
        System.out.println(luckyNumbers(matrix));

    }
    static public List<Integer> luckyNumbers (int[][] matrix) {
        ArrayList<Integer> integers = new ArrayList<>();
        //声明长度为矩阵行数的数组
        int[] tempROw = new int[matrix.length];
        //声明长度为矩阵列数的数组
        int[] tempCol = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //将第i行，第j列的数分别存入数组中
                for(int j1 = 0;j1 < matrix[0].length; j1++){
                    tempCol[j1] = matrix[i][j1];
                }
                for(int i1 = 0;i1 < matrix.length; i1++){
                    tempROw[i1] = matrix[i1][j];
                }
                Arrays.sort(tempCol);
                Arrays.sort(tempROw);
                if(tempCol[0] == tempROw[matrix.length - 1]){
                    integers.add(tempCol[0]);
                }
            }
        }
        return integers;

    }
}
