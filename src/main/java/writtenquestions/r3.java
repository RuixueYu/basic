package writtenquestions;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author: YuRuixue
 * @Description: TODO
 * @date 2022/4/26 20:07
 */
public class r3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        HashSet<String> set = new HashSet<>();
        int groupNum = scanner.nextInt();
        if(groupNum == 0){
            System.out.print(1);
            return;
        }
        String[] personName = new String[groupNum];
        for (int i = 0; i < groupNum; i++) {
            personName[i] = scanner.next();
        }
        for (String s : personName) {
            String[] split = s.split(",");
            for (String s1 : split) {
                set.add(s1);
            }
        }
        //System.out.println(set);
        System.out.print(set.size());
    }
}
