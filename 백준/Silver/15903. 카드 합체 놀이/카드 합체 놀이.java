import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }
        for (int i = 0; i < m; i++) {
            long poll1 = pq.poll();
            long poll2 = pq.poll();
            pq.add(poll1 + poll2);
            pq.add(poll1 + poll2);
        }

        long answer = 0;
        while (!pq.isEmpty()) {
            answer += pq.poll();
        }
        System.out.println(answer);
    }
}