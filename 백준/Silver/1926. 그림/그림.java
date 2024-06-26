import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int n, m;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    int tmp = dfs(i, j);
                    answer = Math.max(answer, tmp);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(answer);
    }

    static int dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= m || board[x][y] == 0) {
            return 0;
        }

        board[x][y] = 0;
        int sum = 1;
        sum += dfs(x + 1, y);
        sum += dfs(x - 1, y);
        sum += dfs(x, y + 1);
        sum += dfs(x, y - 1);
        return sum;
    }
}
