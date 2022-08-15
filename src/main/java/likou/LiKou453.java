package likou;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author: YuRuixue
 * @Description: 贪心算法-无重叠区间
 * @date 2022/8/14/0014 18:33
 */
public class LiKou453 {
    public static void main(String[] args) {
        //{start,end}
        int[][] intervals = {{1, 3}, {1, 4}, {4, 6}, {5, 8}, {7, 8}, {8, 11}};
//        System.out.println(intervals.length);//行数
//        System.out.println(intervals[0].length);//列数
        System.out.println(intervalSchedule(intervals));
    }
    public static int intervalSchedule(int[][] intervals) {
        if(intervals.length == 0) {
            return 0;
        }
        //1.对二维数组排序，以每个区间的end升序排列
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        //至少有一个区间不相交
        int count = 1;
        //排序后，第一个区间就是end最早的区间
        int x_end = intervals[0][1];
        for (int[] interval : intervals) {
            int start = interval[0];
            if(start > x_end) {
                count++;
                x_end = interval[1];
            }
        }
        return count;
    }
}
