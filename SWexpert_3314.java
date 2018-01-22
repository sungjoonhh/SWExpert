import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new java.io.FileInputStream("input.txt"));

		Scanner sc = new Scanner(System.in);
		int Testcase = sc.nextInt();
		for (int T = 1; T <= Testcase; T++) {
			int sum = 0;

			for (int cnt = 0; cnt < 5; cnt++) {
				int n = sc.nextInt();
				if (n < 40) {
					n = 40;
				}
				sum += n;
			}
			System.out.println("#" + T + " " + sum / 5);
		}
	}

}