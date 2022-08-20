package writtenquestions;

import java.util.Scanner;

public class KnapsackProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] w = {20, 30, 50,30,50,30,40,10};
		int[] val = {300, 500, 620,370,400,450,380,150};
		int n = val.length;
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int[][] v = new int[n+1][m+1];

		int[][] path = new int[n+1][m+1];

		for(int i = 0; i < v.length; i++) {
			v[i][0] = 0;
		}
		for(int i=0; i < v[0].length; i++) {
			v[0][i] = 0;
		}

		for(int i = 1; i < v.length; i++) {
			for(int j=1; j < v[0].length; j++) {
				if(w[i-1]> j) {
					v[i][j]=v[i-1][j];
				} else {
					if(v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
						v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
						path[i][j] = 1;
					} else {
						v[i][j] = v[i - 1][j];
					}
					
				}
			}
		}

		int count = 0;
		int i = path.length - 1;
		int j = path[0].length - 1;
		while(i > 0 && j > 0 ) {
			if(path[i][j] == 1) {
				count +=val[i-1];
				j -= w[i-1];
			}
			i--;
		}
		System.out.println(count);
		
	}
}
