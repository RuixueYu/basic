package algorithms.sort.test;

import java.util.HashMap;

/**
 * @Author : YuRuixue
 * @Description: 请设计一个计票器程序，通过输入有效候选人列表和投票结果，计算出1.每个有效候选人的票数；2.无效票数；3.获得票数最多的人。
 * 注意：如果候选人的票数相同，则通过候选人列表中候选人的顺序决定谁胜出。如果票数中的无效票多于最高票候选人的票数或者票数为空，则无人获胜。
 * @date :   2022-08-20 09:33
 */
public class CountingMachine {
    public static void main(String[] args) {
        String[] candidates = {"A", "B", "C"};
        String[] votingList = {"A", "B", "B","A", "B", "F","F","F","F"};
        System.out.println(countingMachine(candidates,votingList));
    }
    public static String countingMachine(String[] candidates,String[] votingList) {
        //记录无效票数
        int invaildVote = 0;
        //记录胜出者 初始化为第一个人
        String winner = candidates[0];

        StringBuilder builder = new StringBuilder();
        if(candidates.length > 0 ) {
            HashMap<String, Integer> map = new HashMap<>();
            for (String candidate : candidates) {
                map.put(candidate,0);
            }
            for (String vote : votingList) {
                if(map.containsKey(vote)) {
                    map.put(vote,map.get(vote) + 1);
                }else {
                    invaildVote++;
                }
            }
            builder.append(candidates[0] + "=" + map.get(candidates[0]) + " ");
            for (int i = 1; i < candidates.length; i++) {
                String temp = candidates[i];
                if(map.get(temp) > map.get(winner)) {
                    winner = temp;
                }
                builder.append(candidates[i] + "=" + map.get(candidates[i]) + " ");
            }
            builder.append("invalidVotes=" + invaildVote + " ");
            if(invaildVote > map.get(winner)) {

            }
            builder.append("Winner=" + ((invaildVote > map.get(winner) || map.get(winner) == 0) ? "N/A" : winner));
            return builder.toString();
        }
        return "";
    }
}
