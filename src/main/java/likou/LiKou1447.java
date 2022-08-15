package likou;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: YuRuixue
 * @Description: 最简分数
 * @date 2022/2/10 13:44
 */
public class LiKou1447 {
    public static void main(String[] args) {
        System.out.println(simplifiedFractions(9));
    }
    static public List<String> simplifiedFractions(int n) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                //方法一
                /*if(hasSameNum(i,j) == false){
                    list.add(j + "/" + i);
                }*/
                //方法二：使用gcb函数判断
                if(gcd(j,i) == 1){
                    list.add(j + "/" + i);
                }
            }
        }
        return list;
    }
    //方法一自己写的
    static boolean hasSameNum(int n,int m){
        List<Integer> divisor1 = getDivisor(n);
        List<Integer> divisor2 = getDivisor(m);
        //找出两个列表中的相同元素
        List<Integer> same = divisor1.stream().filter(s -> divisor2.contains(s)).collect(Collectors.toList());
        return same.size() != 0;
    }
    static List<Integer> getDivisor(int num){
        ArrayList<Integer> divisors = new ArrayList<>();
        for (int i = 2; i <= num / 2; i++) {
            if(num % i == 0){
                divisors.add(i);
            }
        }
        divisors.add(num);
        return divisors;
    }

    //方法二：求两个数的最大公约数
    static int  gcd(int  a,int  b){
        if(b == 0) {
            return a;
        }
        return gcd(b,a % b);
    }

}
