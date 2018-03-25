import java.io.FileInputStream;
import java.util.*;

class Main {
	static int[] arr;// ���� �迭
	static int[] op;// ������ Ƚ���� ������ �迭
	static ArrayList<Integer> list; // �ּҰ��� �ִ밪�� ã�� ���� ��� ������ ��������
	static char[] MH; // ���������� �������� (������� ���� X)
	static int T;
	static int N;
	static int count = 0;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		// Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			arr = new int[N];
			op = new int[4];
			MH = new char[N]; // ���������� �������� (������� ���� X)

			list = new ArrayList<Integer>();
			for (int i = 0; i < 4; i++) {
				op[i] = sc.nextInt();
			}

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			DFS(1, arr[0]); // ��� ����
			Collections.sort(list);
			System.out.println("#" + t + " " + (list.get(list.size() - 1) - list.get(0)));
		}
	}

	// x�� ���� �����̰� sum�� �װ����� ���� �� �� �̴�.
	static void DFS(int x, int sum) {
		// ('+', '-', '*', '/') �����ڵ��� �ѹ��� �� Ȯ���ؾ��� (DFS ��üŽ���̴ϱ�)
		for (int i = 0; i < 4; i++) {
			// ������ �����ڸ��� ������ �ּ� ��� 0�̸� �� �����ڰ� �����Ƿ� ���
			if (op[i] != 0) {
				op[i]--; // ���� �����ڸ� �ϳ��� ����.
				switch (i) {
				case 0:
					MH[x - 1] = '+'; // �ʿ������ ����Ȯ����
					DFS(x + 1, sum + arr[x]); // ���� ���� ����ؾߵǴϱ�
					break;
				case 1:
					MH[x - 1] = '-'; // �ʿ������ ����Ȯ����
					DFS(x + 1, sum - arr[x]); // ���� ���� ����ؾߵǴϱ�
					break;
				case 2:
					MH[x - 1] = '*'; // �ʿ������ ����Ȯ����
					DFS(x + 1, sum * arr[x]); // ���� ���� ����ؾߵǴϱ�
					break;
				case 3:
					MH[x - 1] = '/'; // �ʿ������ ����Ȯ����
					DFS(x + 1, sum / arr[x]); // ���� ���� ����ؾߵǴϱ�
					break;
				}
				MH[x - 1] = 0; // �ʿ������ ����Ȯ����
				op[i]++; // ����� �������� �ٽ� �߰����ش�.
			}
		}

		// ī��Ʈ�� �Է°��� ������ �� ��� (��� ���ڸ� �� ������� ���)
		if (x == N) {
			for (int i = 0; i < N; i++) {
				// System.out.print(arr[i] + " ");
				// System.out.print(MH[i] + " ");
			}

			// System.out.println("= " + sum);
			list.add(sum);
		}
	}

}
