package BFS.WEEK4_CKW.BOJ_2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] xmove = {0,1,0,-1};
    static int[] ymove = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 2][M + 2];
        int[][][] visit = new int[2][N+2][M+2];
        visit[0][1][1] = 1;
        visit[1][1][1] = 1;

        for(int i = 0; i < N + 2; i++)
            Arrays.fill(map[i], 2);

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = line.charAt(j - 1) - '0';
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1,1,1,0});
        boolean find = false;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int y = tmp[0]; int x = tmp[1];
            int count = tmp[2]; int crash = tmp[3];

            if(y == N && x == M) {
                find=true;
                System.out.println(count);
                break;
            }

            for (int  i = 0; i < 4; i++) {
                int yy = y + ymove[i];
                int xx = x + xmove[i];
                if(yy==0 || yy==N+1 || xx==0 || xx==M+1)
                    continue;
                if(crash == 1 && visit[1][yy][xx]==0){
                    if(map[yy][xx]==0) {
                        visit[1][yy][xx] = 1;
                        q.add(new int[]{yy, xx, count + 1, 1});
                    }
                }
                else if(crash == 0){
                    if(map[yy][xx]==1){
                        visit[1][yy][xx] = 1;
                        q.add(new int[] {yy,xx,count+1,1});
                    }
                    else if(map[yy][xx]==0 && visit[0][yy][xx]==0){
                        visit[0][yy][xx] = 1;
                        q.add(new int[] {yy,xx,count+1,0});
                    }
                }
            }

        }

        if(!find){
            System.out.println(-1);
        }

    }

}
