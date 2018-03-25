import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Main {

	static int[] dx = { 1, -1, -1, 1 }; // �� ,��, ��,��
	static int[] dy = { -1, 1, -1, 1 };
	static int n;
	static int[][] arr;
	static boolean[][] visited;
	static int[] flags;
	static int ax;
	static int by;
	static int max;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		//Scanner sc2 = new Scanner(new FileOutputStream("output.txt"));
		
		int Testcase = sc.nextInt();
		for (int T = 0; T < Testcase; T++) {

			n = sc.nextInt();
			arr = new int[n][n];
			visited = new boolean[n][n]; // ��湮 ������ ���� �迭
			flags = new int[101]; // ���� ����Ʈ ���� �湮 ������ ���� �迭
			max = -1;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			//for (int i = 0; i < n; i++) {
			//	for (int j = 0; j < n; j++) {
				int i = 0, j=4;
					visited[i][j] = true; // ������ ��湮 ����
					flags[arr[i][j]] = 1; // ������ ����Ʈ ���� �湮 ����
					ax = i;
					by = j;
					dfs(i, j, 1, -1, 0);
					visited[i][j] = false; // ������ ��湮 �ʱ�ȭ
					flags[arr[i][j]] = 0; // ������ ����Ʈ ���� �湮 �ʱ�ȭ
					Init();

			//	}
		//	}

			System.out.println("#" + (T + 1) + " " + max);
		}

	}

	static void Init() {
		for (int i = 0; i < 100; i++) {
			flags[i] = 0;
		}
	}

	// count�� ����Ʈ ī�� �湮 Ƚ���� ��Ÿ����.
	// dir ������ ��Ÿ����.
	// turn�� ���� ���� Ƚ���� ��Ÿ����.
	static void dfs(int x, int y, int count, int dir, int turn) {

		// turn�� 4�� �Ѿ ��� �簢�� ����� ���� �ʴ´�.
		if (turn > 4) {
			return;
		}

		// 4���� �밢�� �湮
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			int nextDir = i;
			if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) {
				continue;
			}

			// �������� �������̸鼭 && �ٷ� �ǵ��� ���� ��츦 �����ϱ� ���� count !=2 �� ����ߴ�.
			if (nextX == ax && nextY == by && count != 2) {

				if (max < count) {
					System.out.println(nextX +" " +nextY +" "+count);
					//System.out.println("�̶��� "+arr[nextX][nextY]);
					max = count;
					return;
				}
			}
			// ����Ʈ ���ڰ� ���� ���� �湮���� ���
			if (flags[arr[nextX][nextY]] == 1) {
				continue;
			}
			// �湮�ߴ� ������ ���
			if (visited[nextX][nextY]) {
				continue;
			}
			// �湮�� ����Ʈ �� ���ڸ� switch on ��Ų��.
			flags[arr[nextX][nextY]] = 1;

			// ó�� ���� dir�� -1�� ������ �ξ� ó������ �׻� turn�� 1�� �����ϰ� �������.
			if (dir == nextDir) {
				// ���� ����� ���� ������ ���ٸ� ��ǥ�� �ٲ۴�.
				System.out.println(nextX+" "+nextY +" : "+count);

				dfs(nextX, nextY, count + 1, dir, turn);
			} else {
				// ���� ����� ���� ������ �ٸ��ٸ� ������ �ٲ��ָ� turn Ƚ���� �÷��ش�.
				System.out.println(nextX+" "+nextY +" : "+count);
				dfs(nextX, nextY, count + 1, nextDir, turn + 1);
			}
			// �湮�� ����Ʈ �� ���ڸ� switch off ��Ų��.
			flags[arr[nextX][nextY]] = 0;
		}
	}

}
