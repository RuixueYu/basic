package likou;

import java.util.ArrayList;

/**
 * 寻找符合要求的正方形
 */
public class LiKou2013 {
    ArrayList<int[]> list = new ArrayList<>();
    public LiKou2013() {

    }

    public void add(int[] point) {
        list.add(point);
    }

    public int count(int[] point) {
        if(list.size() < 3)
            return 0;
        else{
            int count = 0;
            int x = point[0];
            int y = point[1];
            for (int[] ints : list) {
                int x1 = ints[0];
                int y1 = ints[1];
                if(y1 == y){
                    int length = x1 > x ? x1-x : x-x1;
                    for (int[] ints1 : list) {
                        if(ints1[0] == x1 && ints1[1] == y-length){
                            for (int[] ints2 : list) {
                                if(ints2[0] == x && ints2[1] == y-length)
                                    count ++;

                            }
                        }
                        if(ints1[0] == x1 && ints1[1] == y + length){
                            for (int[] ints2 : list) {
                                if(ints2[0] == x && ints2[1] == y + length)
                                    count ++;

                            }
                        }
                    }
                }

            }
            return count;
        }
    }
    public static void main(String[] args) {
        LiKou2013 liKou2013 = new LiKou2013();
//        liKou2013.add(new int[]{1, 1});
//        liKou2013.add(new int[]{1, 2});
//        liKou2013.add(new int[]{2, 1});
        liKou2013.add(new int[]{3, 10});
        liKou2013.add(new int[]{11, 2});
        liKou2013.add(new int[]{3, 2});
//        liKou2013.add(new int[]{11, 10});
        System.out.println(liKou2013.count(new int[]{11, 10}));

    }
}
