import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static int M;
	static char[][] arr;
	static boolean[][][] check;

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));

		int Testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= Testcase; t++) {
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			M = Integer.parseInt(str[1]);
			Dot start = null;
			arr = new char[N][M];
			check = new boolean[N][M][1 << 6];

			for (int i = 0; i < N; i++) {
				str = br.readLine().split("");
				for (int j = 0; j < M; j++) {
					arr[i][j] = str[j].charAt(0);
					if (arr[i][j] == '0') {
						start = new Dot(i, j, 0);
					}
				}
			}
			System.out.print("#" + t + " ");
			System.out.println(BFS(start));

		}
	}

	public static int BFS(Dot start) {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(start);
		check[q.peek().x][q.peek().y][0] = true;
		int Hour = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int qsize = 0; qsize < size; qsize++) {
				Dot d = q.poll();
				int currentX = d.x;
				int currentY = d.y;
				int currentKey = d.key;
				System.out.println(currentX + " " + currentY);
				if (arr[currentX][currentY] == '1') {
					return Hour;
				}

				for (int i = 0; i < 4; i++) {
					int nextX = currentX + dx[i];
					int nextY = currentY + dy[i];
					int key = currentKey;

					if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
						continue;
					}

					if (arr[nextX][nextY] == '#') {
						continue;
					}
					if ('a' <= arr[nextX][nextY] && arr[nextX][nextY] <= 'f') {
						key |= (1 << arr[nextX][nextY] - 'a');
					}
					if ('A' <= arr[nextX][nextY] && arr[nextX][nextY] <= 'F') {
						if ((key & (1 << (arr[nextX][nextY] - 'A'))) == 0) {
							continue;
						}
					}
					if (check[nextX][nextY][key]) {
						continue;
					}
					check[nextX][nextY][key] = true;
					q.add(new Dot(nextX, nextY, key));
				}
			}
			Hour++;
		}
		return -1;
	}
}

class Dot {
	int x;
	int y;
	int key;

	Dot(int x, int y, int key) {
		this.x = x;
		this.y = y;
		this.key = key;
	}
}
