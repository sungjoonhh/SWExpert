import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Main {

	static int[] dx = { 1, -1, -1, 1 }; // ↖ ,↗, ↙,↘
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
			visited = new boolean[n][n]; // 재방문 방지를 위한 배열
			flags = new int[101]; // 같은 디저트 숫자 방문 방지를 위한 배열
			max = -1;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			//for (int i = 0; i < n; i++) {
			//	for (int j = 0; j < n; j++) {
				int i = 0, j=4;
					visited[i][j] = true; // 시작점 재방문 방지
					flags[arr[i][j]] = 1; // 시작점 디저트 숫자 방문 방지
					ax = i;
					by = j;
					dfs(i, j, 1, -1, 0);
					visited[i][j] = false; // 시작점 재방문 초기화
					flags[arr[i][j]] = 0; // 시작점 디저트 숫자 방문 초기화
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

	// count는 디저트 카페 방문 횟수를 나타낸다.
	// dir 방향을 나타낸다.
	// turn은 방향 변경 횟수를 나타낸다.
	static void dfs(int x, int y, int count, int dir, int turn) {

		// turn이 4가 넘어갈 경우 사각형 모양이 되지 않는다.
		if (turn > 4) {
			return;
		}

		// 4방향 대각선 방문
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			int nextDir = i;
			if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) {
				continue;
			}

			// 다음점이 시작점이면서 && 바로 되돌아 오는 경우를 방지하기 위해 count !=2 를 사용했다.
			if (nextX == ax && nextY == by && count != 2) {

				if (max < count) {
					System.out.println(nextX +" " +nextY +" "+count);
					//System.out.println("이때야 "+arr[nextX][nextY]);
					max = count;
					return;
				}
			}
			// 디저트 숫자가 같은 곳을 방문했을 경우
			if (flags[arr[nextX][nextY]] == 1) {
				continue;
			}
			// 방문했던 지점일 경우
			if (visited[nextX][nextY]) {
				continue;
			}
			// 방문한 디저트 점 숫자를 switch on 시킨다.
			flags[arr[nextX][nextY]] = 1;

			// 처음 시작 dir은 -1로 설정해 두어 처음에는 항상 turn이 1로 증가하게 만들었다.
			if (dir == nextDir) {
				// 현재 방향과 다음 방향이 같다면 좌표만 바꾼다.
				System.out.println(nextX+" "+nextY +" : "+count);

				dfs(nextX, nextY, count + 1, dir, turn);
			} else {
				// 현재 방향과 다음 방향이 다르다면 방향을 바꿔주며 turn 횟수를 올려준다.
				System.out.println(nextX+" "+nextY +" : "+count);
				dfs(nextX, nextY, count + 1, nextDir, turn + 1);
			}
			// 방문한 디저트 점 숫자를 switch off 시킨다.
			flags[arr[nextX][nextY]] = 0;
		}
	}

}
