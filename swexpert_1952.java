import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		int Tc = Integer.parseInt(br.readLine());
		int[] arr = new int[4];
		int[] cal = new int[12];

		for (int T = 1; T <=Tc; T++) {

			int[] dp = new int[12];
			String[] str = br.readLine().split(" ");
			for (int i = 0; i < 4; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			str = br.readLine().split(" ");

			for (int i = 0; i < 12; i++) {
				cal[i] = Integer.parseInt(str[i]);
			}
			dp[0] = Math.min(arr[1], arr[0] * cal[0]);
			dp[1] = Math.min(arr[1], arr[0] * cal[1]) + dp[0];
			dp[2] = Math.min(arr[1], arr[0] * cal[2]) + dp[1];
			dp[2] = Math.min(arr[2], dp[2]);

			for (int i = 3; i < 12; i++) {
				dp[i] = Math.min(arr[1], arr[0] * cal[i]) + dp[i - 1];
				dp[i] = Math.min(dp[i], arr[2] + dp[i - 3]);
			}

			dp[11] = Math.min(arr[3], dp[11]);

			System.out.println("#"+T+" "+dp[11]);
		}

	}
}