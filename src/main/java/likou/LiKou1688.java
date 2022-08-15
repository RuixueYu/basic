package likou;

/**
 * 队伍配对数
 */
public class LiKou1688 {
    public static int numberOfMatches(int n) {
        int count = 0;
        while (n > 1){
            count += n / 2 ;
            n = n % 2 == 1 ? n / 2 + 1 : n / 2;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(numberOfMatches(1));
    }
}