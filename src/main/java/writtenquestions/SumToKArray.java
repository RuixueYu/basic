package writtenquestions;

import java.sql.Array;
import java.util.*;

/**
 * @Author : YuRuixue
 * @Description: TODO
 * @date :   2022-08-24 20:03
 */
public class SumToKArray {
    public static void main(String[] args) {
        int[] c = {3,6,7,9};
        int t=9;
        System.out.println(sumToKArray(c, t));
    }
    static List<List<Integer>>sumToKArray(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        Arrays.sort(candidates);
        process(candidates, target, 0, 0, res, path);
        return res;
    }
    static void process(int[] candidates, int target, int sum, int startIndex, List<List<Integer>> res, Deque<Integer> path) {
        if(sum == target) {
            res.add(new ArrayList<>(path));
        }
        if(sum > target) {
            return;
        }
        for(int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];
            if(sum > target) {
                break;
            }
            path.add(candidates[i]);
            process(candidates,target,sum, i, res, path);
            path.removeLast();
            sum -= candidates[i];
        }
    }
}
