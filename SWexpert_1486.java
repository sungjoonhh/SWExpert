import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int Testcase = sc.nextInt();
		for (int T = 1; T <= Testcase; T++) {
			int n = sc.nextInt();
			int max = sc.nextInt();
			int min = Integer.MAX_VALUE;
			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			for (int i = 1; i < 1 << n; i++) {
				int sum = 0;
				int bit = i;
				for (int j = 0; bit != 0; j++, bit >>= 1) {
					if ((1 & bit) == 0) {
						continue;
					}
					sum += arr[j];
				}
				if ((max - sum) <= 0 && Math.abs(max - sum) < min) {
					min = Math.abs(max - sum);
				}
			}
			System.out.println("#" + T + " " + min);

		}
	}

}