package likou;

import java.util.Arrays;

/**
 * 游戏中弱角色的数量
 */
public class LiKou1996 {
    public static int numberOfWeakCharacters(int[][] properties) {
        //lamda表达式比较大小
        //->后的表达式若>0,则o1排在o2前面
        int result = 0, maxDefense = 0;
        Arrays.sort(properties, (o1,o2) -> o1[0]==o2[0] ? o1[1]-o2[1] : o2[0]-o1[0]);
        for(int[] i: properties){
            if(maxDefense > i[1]){
                result++;
            }
            else{
                maxDefense = i[1];
            }
        }
        return result;

        //方法2
        /*int weakNum=0;
        for(int i=0;i< properties.length;i++){
            for(int j=0;j< properties.length ;j++) {
                if(properties[i][0]<properties[j][0] &&
                        properties[i][1]<properties[j][1])
                {
                    weakNum++;
                    break;
                }
            }
        }
        return weakNum;*/
    }

    public static void main(String[] args) {
        int[][] properties = { {10, 20}, {9, 25}, {2, 44}, {10, 55} };
        System.out.println(numberOfWeakCharacters(properties));
    }
}
