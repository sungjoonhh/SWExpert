import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int Testcase = sc.nextInt();

		for (int T = 1; T <= Testcase; T++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N][N];
			int sum = 0;
			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();

				}
			}
			for(int i=0; i<=N-M; i++){
				for(int j=0; j<=N-M; j++){
					for(int x= 0; x<M; x++){
						for(int y= 0; y<M; y++){
							//System.out.print((i+x)+" "+(j+y)+"    ");
							sum += arr[i+x][j+y];
						}
					}
					//System.out.println();
					result = Math.max(result, sum);
					sum = 0;
				}
			}
			
			System.out.println("#"+T+" "+ result);
		}

	}

}
