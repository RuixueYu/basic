package likou;

public class LiKou1765 {
    public static int[][] highestPeak(int[][] isWater) {
        int[][] height =new int[isWater.length][isWater[0].length];
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[i].length; j++) {
                if(isWater[i][j] == 1){
                    height[i][j] = 5;
                    if(i+1 < isWater.length) {
                        height[i+1][j] = 6;
                    }
                    if(j+1 < isWater[i].length) {
                        height[i][j+1] = 6;
                    }
                    /*if(i-1 >= 0) {
                        height[i-1][j] = 6;
                    }
                    if(j-1 >= 0) {
                        height[i][j-1] = 6;
                    }*/
                }
            }
        }
        //return height;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height[i].length; j++) {
                if(height[i][j] == 0){
                    int min = 6;
                    if(i+1 < height.length && height[i+1][j] != 0) {
                        min = height[i+1][j];
                    }
                    if(j+1 < height[i].length && height[i][j+1] != 0) {
                        min = height[i][j+1] < min ? height[i][j+1] : min;
                    }
                    if(i-1 >= 0) {
                        min = height[i-1][j] < min ? height[i-1][j] : min;
                    }
                    if(j-1 >= 0) {
                        min = height[i][j-1] < min ? height[i][j-1] : min;
                    }
                    height[i][j] = min + 1 ;
                }
            }
        }
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height[i].length; j++) {
                height[i][j] = height[i][j] - 5;
            }
        }
        return height;
    }

    public static void main(String[] args) {
        int[][] isWater = {{0, 0, 0, 0, 0, 0, 1, 0},{0,1,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,1,0},{0,0,1,0,0,0,0,0}};
        int[][] height = highestPeak(isWater);
        for (int i = 0; i < height.length; i++) {
            for (int i1 = 0; i1 < height[i].length; i1++) {
                System.out.println(height[i][i1] );
            }
        }
    }
}
