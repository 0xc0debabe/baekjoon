import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = 1_000 * 1_000;
    static int n;
    static int arr[][];
    static int dp[][];
    static int answer = INF;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][3];
        dp = new int[n + 1][3];

        // 입력 값 저장
        for(int i = 1 ; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 0; k < 3; k++) {
            for(int i = 0 ; i < 3; i++) {
                if(i == k) dp[1][i] = arr[1][i];
                else dp[1][i] = INF;
            }

            // 열의 값인 0 -> RED, 1 -> GREEN, 2 -> BLUE로 칠했을 때의 최소값을 의미한다.
            for (int i = 2; i <= n; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
            }

            // 정답인 최솟값을 구하는 부분
            for(int i = 0 ; i < 3; i++)
                if(i != k) answer = Math.min(answer, dp[n][i]);
        }


        System.out.println(answer);
    }
}