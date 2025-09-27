package BFS.WEEK3_CKW.BOJ_2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int cnt;
    static int[] xmove = {0, 1, 0, -1};
    static int[] ymove = {-1, 0, 1, 0};
    // 위, 오, 아래, 왼

    public static void bfs(int[][] m, Queue<int[]> q, int k){
        int[] tmp = q.poll();
        int y = tmp[0];
        int x = tmp[1];

        for(int i=0; i<4; i++){
            if(m[y+ymove[i]][x+xmove[i]] > k){
                m[y+ymove[i]][x+xmove[i]] = 0;
                q.add(new int[]{y+ymove[i], x+xmove[i]});
            }
        }
        if(q.isEmpty()){
            return;
        }
        else{
            bfs(m, q, k);
        }



    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N+2][N+2];
        int max = 0;

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(max < map[i][j]){
                    max = map[i][j];
                }
            }
        }
        int k = 0;
        int maxcnt = 0;
        while(k <= max) {
            int[][] tmp = new int[N+2][N+2];
            for(int i=0; i<N+2; i++){
                System.arraycopy(map[i], 0, tmp[i], 0, N+2);
            }
            cnt=0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (tmp[i][j] > k) {
                        cnt++;
                        tmp[i][j] = 0;
                        Queue<int[]> q = new LinkedList<>();
                        q.add(new int[]{i, j});
                        bfs(tmp, q, k);
                    }
                }
            }

            if(maxcnt < cnt){
                maxcnt = cnt;
            }
            k++;
        }
        System.out.println(maxcnt);

    }
}
