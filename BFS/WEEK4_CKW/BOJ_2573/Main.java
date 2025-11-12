package BFS.WEEK4_CKW.BOJ_2573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] xmove = {0,1,0,-1};
    static int[] ymove = {1,0,-1,0};
    //위,오,아래,왼


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int cnt = 0; // 맵에 있는 빙하 칸 수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > 0)
                    cnt++;
            }
        }

        /*if(cnt==0){
            System.out.println(0);
            return;
        }*/

        int answer = 0;

        while(true){
            cnt=0;
            boolean flag = false;
            Queue<int[]> q = new LinkedList<>();
            boolean[][] visit = new boolean[N][M];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(map[i][j]>0) {
                        cnt++;
                        if(!flag){
                            q.add(new int[]{i,j});
                            visit[i][j]=true;
                            flag=true;
                        }
                    }
                }
            }


            int bfscnt = 0;

            while(!q.isEmpty()){
                int[] tmp = q.poll();
                bfscnt++;
                int y = tmp[0]; int x = tmp[1];
                for(int k = 0; k < 4; k++){
                    int xx = x+xmove[k]; int yy = y+ymove[k];
                    if (xx >= 0 && xx < M && yy >= 0 && yy < N) {
                        if(map[yy][xx]>0 && !visit[yy][xx]) {
                            q.add(new int[]{yy, xx});
                            visit[yy][xx] = true;
                        }
                    }
                }
            }

            if(cnt==0){
                System.out.println(0);
                break;
            }

            if(bfscnt!=cnt) {
                System.out.println(answer);
                break;
            }

            answer++;

            Queue<int[]> mapq = new LinkedList<>();

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(map[i][j] <= 0){
                         for(int k = 0; k < 4; k++){
                            int xx = j+xmove[k]; int yy = i+ymove[k];
                            if (xx >= 0 && xx < M && yy >= 0 && yy < N) {
                                if(map[yy][xx]>0)
                                    mapq.add(new int[]{yy,xx});
                            }
                        }
                    }
                }
            }

             while(!mapq.isEmpty()){
                int[] tmp = mapq.poll();
                map[tmp[0]][tmp[1]]--;
            }

        }


    }


}
