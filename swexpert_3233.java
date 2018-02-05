import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int Testcase = sc.nextInt();
		for (int T = 1; T <= Testcase; T++) {
			long N = sc.nextInt();
			long M = sc.nextInt();
			long result = N/M;
			System.out.println("#"+T + " "+result*result);
		}
	}

}
